package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleDao;
import pers.zheng.blog.dao.ArticleLabelDao;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.admin.ItemExistException;
import pers.zheng.blog.exception.content.ArticleNotFoundException;
import pers.zheng.blog.model.dto.ArticleDTO;
import pers.zheng.blog.model.dto.ArticleItemDTO;
import pers.zheng.blog.model.entity.*;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.model.vo.ArticleVO;
import pers.zheng.blog.model.vo.ArticleItemVO;
import pers.zheng.blog.service.ArticleService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;
import pers.zheng.blog.util.MarkdownUtils;

import java.util.Date;
import java.util.List;

/**
 * @ClassName XzArticlesServiceImpl
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/11 23:30
 * @Version 1.0
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articlesDao;

    @Autowired
    private ArticleSortDao articleSortDao;

    @Autowired
    private SortDao sortDao;

    @Autowired
    private ArticleLabelDao articleLabelDao;

    @Override
    public List<Article> getAll() {
        return articlesDao.selectList(null);
    }

    @Override
    public IPage<ArticleItemVO> listArticlePages(int p, int size) {
        Page<ArticleItemVO> pageConf = new Page<>(p, size);
        IPage<ArticleItemVO> page = articlesDao.listArticlePages(pageConf, "publish");
        /**
         * 添加分类
         */
        return setArticleItemSorts(page);
    }

    @Override
    public IPage<ArticleItemDTO> listArticleDtoItems(int current, int size, String title) {
        Page<ArticleItemDTO> pageConf = new Page<>(current, size);
        IPage<ArticleItemDTO> resultPage = articlesDao.listArticleDtoItems(pageConf, title);
        //获取文章的分类
        for (ArticleItemDTO record : resultPage.getRecords()) {
            Sort sort = articleSortDao.getSortByArticleId(record.getArticleId());
            record.setSort(sort);
        }
        //获取文章的标签
        for (ArticleItemDTO record : resultPage.getRecords()) {
            List<Label> labels = articleLabelDao.listLabelByArticle(record.getArticleId());
            record.setLabels(labels);
        }
        return resultPage;
    }

    /**
     * 根据id获取文章
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVO getArticleById(Long articleId) {
        ArticleVO article = articlesDao.getArticleById(articleId);
        if (article == null) {
            throw new ArticleNotFoundException("没有这篇文章");
        }

        //获得分类
        LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleSort::getArticleId, article.getArticleId());
        ArticleSort articleSort = articleSortDao.selectOne(wrapper);
        Sort sort = null;
        if (articleSort != null) {
            sort = sortDao.selectById(articleSort.getSortId());
            article.setSort(sort);
        }
        //获得标签
        List<Label> labels = articleLabelDao.listLabelByArticle(article.getArticleId());
        article.setLabels(labels);
        //markdown转换
        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(article.getArticleContent());
        article.setArticleContent(markdownEntity.toString());
        article.setArticleTocHtml(markdownEntity.getHtmlTOC());
        return article;
    }

    /**
     * 根据标签名查找
     *
     * @param p
     * @param labelId
     * @param size
     * @return
     */
    @Override
    public IPage<ArticleItemVO> listArticleItemsByLabel(int p, Integer labelId, int size) {
        Page<ArticleItemVO> page = new Page<>(p, size);
        IPage<ArticleItemVO> publishArticle = articlesDao.listArticleItemByLabel(page, "publish", labelId);
        return setArticleItemSorts(publishArticle);
    }

    /**
     * 根据文章名查找
     *
     * @param p
     * @param size
     * @param keyword
     * @return
     */
    @Override
    public IPage<ArticleItemVO> listArticleItemsByName(int p, int size, String keyword) {
        Page<ArticleItemVO> page = new Page<>(p, size);
        IPage<ArticleItemVO> publishArticle = articlesDao.listArticleItemsByName(page, "publish", keyword);
        IPage<ArticleItemVO> articleItems = setArticleItemSorts(publishArticle);
        for (ArticleItemVO itemVo : articleItems.getRecords()) {
            MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(itemVo.getArticleSummary());
            itemVo.setArticleSummary(markdownEntity.toString());
        }
        return articleItems;
    }

    /**
     * 给文章列表的每一项添加分类
     *
     * @param publishArticle
     * @return
     */
    @NotNull
    private IPage<ArticleItemVO> setArticleItemSorts(IPage<ArticleItemVO> publishArticle) {
        for (ArticleItemVO record : publishArticle.getRecords()) {
            LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ArticleSort::getArticleId, record.getArticleId());
            ArticleSort articleSort = articleSortDao.selectOne(wrapper);
            Sort sort = null;
            if (articleSort != null) {
                sort = sortDao.selectById(articleSort.getSortId());
                record.setSort(sort);
            }
        }
        return publishArticle;
    }

    /**
     * 添加文章
     *
     * @param articleDTO
     * @return
     */
    @Override
    public int insertArticle(ArticleDTO articleDTO) {
        //查询别名是否存在
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getArticleSlug, articleDTO.getArticleSlug())
                .last("limit 1");
        int i = articlesDao.selectCount(wrapper);
        if (i != 0) {
            throw new ItemExistException("相同别名的文章已经存在");
        }

        //包装类型没有默认值
        Article article = new Article();

        article.setArticleTitle(articleDTO.getArticleTitle())
                .setArticleSlug(articleDTO.getArticleSlug())
                .setCreateTime(articleDTO.getCreateTime())
                .setUpdateTime(articleDTO.getCreateTime())
                .setArticleContent(articleDTO.getArticleContent())
                .setCommentStatus(articleDTO.getCommentStatus())
                .setArticleStatus(articleDTO.getArticleStatus());

        //使用 <!--more--> 自动生成摘要
        article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDTO.getArticleContent()));
        int count = articlesDao.insert(article);
        if (count == 0) {
            throw new RuntimeException("文章插入失败");
        }

        //创建标签
        for (Label label : articleDTO.getLabels()) {
            ArticleLabel articleLabel = new ArticleLabel();
            articleLabel.setArticleId(article.getArticleId());
            articleLabel.setLabelId(label.getLabelId());
            articleLabelDao.insert(articleLabel);
        }

        //添加分类
        Sort sort = articleDTO.getSort();
        if (sort.getSortId() != null) {
            ArticleSort articleSort = new ArticleSort();
            articleSort.setArticleId(article.getArticleId());
            articleSort.setSortId(sort.getSortId());
            articleSortDao.insert(articleSort);
        }
        return count;
    }

    /**
     * 根据id获取文章
     *
     * @param id
     * @return
     */
    @Override
    public ArticleDTO getArticleDTOById(int id) {
        Article article = articlesDao.selectById(id);
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleId(article.getArticleId())
                .setArticleTitle(article.getArticleTitle())
                .setArticleSummary(article.getArticleSummary())
                .setCreateTime(article.getCreateTime())
                .setArticleContent(article.getArticleContent())
                .setArticleStatus(article.getArticleStatus())
                .setArticleSlug(article.getArticleSlug())
                .setCommentStatus(article.getCommentStatus());
        //返回文章的标签
        List<Label> labels = articleLabelDao.listLabelByArticle(article.getArticleId());
        articleDTO.setLabels(labels);
        //返回文章的分类
        Sort sort = articleSortDao.getSortByArticleId(article.getArticleId());
        articleDTO.setSort(sort);
        return articleDTO;
    }

    /**
     * 更新文章
     *
     * @param articleDTO
     * @return
     */
    @Override
    public int updateArticle(ArticleDTO articleDTO) {
        if (articleDTO.getArticleId() == null) {
            throw new DefaultNotFoundException("文章不存在");
        }

        //查询修改后的别名是否存在
        LambdaQueryWrapper<Article> wrapperSlug = new LambdaQueryWrapper<>();
        wrapperSlug.eq(Article::getArticleSlug, articleDTO.getArticleSlug())
                .ne(Article::getArticleId, articleDTO.getArticleId())
                .last("limit 1");
        int i = articlesDao.selectCount(wrapperSlug);
        if (i != 0) {
            throw new ItemExistException("相同别名的页面已经存在");
        }

        Article article = articlesDao.selectById(articleDTO.getArticleId());
        if (article == null) {
            throw new DefaultNotFoundException("文章不存在");
        }

        article.setArticleTitle(articleDTO.getArticleTitle())
                .setArticleSlug(articleDTO.getArticleSlug())
                .setArticleContent(articleDTO.getArticleContent())
                .setArticleSummary(MarkdownUtils.getSummaryInMD(articleDTO.getArticleContent()))
                .setArticleStatus(articleDTO.getArticleStatus())
                .setCreateTime(articleDTO.getCreateTime())
                .setUpdateTime(new Date())
                .setCommentStatus(articleDTO.getCommentStatus());

        //更新文章的的分类
        //1.先删除之前的文章分类关系
        LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleSort::getArticleId, article.getArticleId());
        articleSortDao.delete(wrapper);
        Sort sort = articleDTO.getSort();
        ArticleSort articleSort = new ArticleSort();
        articleSort.setArticleId(article.getArticleId());
        articleSort.setSortId(sort.getSortId());
        articleSortDao.insert(articleSort);
        //更新文章的标签
        //先判断提交的标签是否
        LambdaQueryWrapper<ArticleLabel> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(ArticleLabel::getArticleId, article.getArticleId());
        articleLabelDao.delete(wrapper1);
        for (Label label : articleDTO.getLabels()) {
            ArticleLabel articleLabel = new ArticleLabel();
            articleLabel.setArticleId(article.getArticleId());
            articleLabel.setLabelId(label.getLabelId());
            articleLabelDao.insert(articleLabel);
        }
        return articlesDao.updateById(article);

    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @Override
    public int deleteArticleById(int id) {
        //删除
        int i = articlesDao.deleteById(id);
        if (i == 0) {
            throw new DefaultNotFoundException("文章不存在");
        }
        //删除文章相关的标签记录
        LambdaQueryWrapper<ArticleLabel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleLabel::getArticleId, id);
        articleLabelDao.delete(wrapper);
        //删除文章相关的分类记录
        LambdaQueryWrapper<ArticleSort> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(ArticleSort::getArticleId, id);
        articleSortDao.delete(wrapper1);
        //返回影响行数
        return i;
    }

    /**
     * 设置文章状态
     *
     * @param articleId
     * @param articleStatus
     * @return
     */
    @Override
    public int setArticleStatus(int articleId, String articleStatus) {
        Article article = articlesDao.selectById(articleId);
        if (article != null) {
            article.setArticleStatus(articleStatus);
            return articlesDao.updateById(article);
        }
        return 0;
    }

    /**
     * 分类下的文章
     *
     * @param p
     * @param sortId
     * @param size
     * @return
     */
    @Override
    public IPage<ArticleItemVO> getArticleItemsBySort(int p, Integer sortId, int size) {
        Page<ArticleItemVO> page = new Page<>(p, size);
        IPage<ArticleItemVO> publishArticle = articlesDao.getArticleItemBySort(page, "publish", sortId);
        return setArticleItemSorts(publishArticle);
    }

    /**
     * 得到上一篇文章
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleItemVO getPrevArticleItemByArticleId(Long articleId) {
        return articlesDao.getPrevArticleItemByArticleId(articleId);
    }

    /**
     * 下一篇文章
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleItemVO getNextArticleItemByArticleId(Long articleId) {
        return articlesDao.getNextArticleItemByArticleId(articleId);
    }

    /**
     * 根据别名获取文章
     *
     * @param articleSlug 别名
     * @param status      状态
     * @return ArticleVO
     */
    @Override
    public ArticleVO getArticleBySlug(String articleSlug, String status) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getArticleSlug, articleSlug)
                .eq(StringUtils.isNotEmpty(status), Article::getArticleStatus, status);

        Article article = articlesDao.selectOne(wrapper);
        if (article == null) {
            throw new ArticleNotFoundException("文章不存在");
        }
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);

        return articleVO;
    }
}
