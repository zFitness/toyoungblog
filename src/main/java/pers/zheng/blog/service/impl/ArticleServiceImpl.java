package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleDao;
import pers.zheng.blog.dao.ArticleLabelDao;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.content.ArticleNotFoundException;
import pers.zheng.blog.model.dto.ArticleDTO;
import pers.zheng.blog.model.dto.ArticleItemDTO;
import pers.zheng.blog.model.entity.*;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.model.vo.ArticleContentVO;
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
    public ArticleContentVO getArticleById(Long articleId) {
        ArticleContentVO article = articlesDao.getArticleById(articleId);
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
     * @param articleDto
     * @return
     */
    @Override
    public int insertArticle(ArticleDTO articleDto) {
        //包装类型没有默认值
        Article article = new Article();

        article.setArticleTitle(articleDto.getArticleTitle());
        article.setArticleContent(articleDto.getArticleContent());
        article.setCreateTime(articleDto.getCreateTime());
        article.setUpdateTime(articleDto.getCreateTime());
        article.setArticleStatus(articleDto.getArticleStatus());
        //使用 <!--more--> 自动生成摘要
        article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDto.getArticleContent()));
        int count = articlesDao.insert(article);
        if (count == 0) {
            throw new RuntimeException("文章插入失败");
        }

        //创建标签
        for (Label label : articleDto.getLabels()) {
            ArticleLabel articleLabel = new ArticleLabel();
            articleLabel.setArticleId(article.getArticleId());
            articleLabel.setLabelId(label.getLabelId());
            articleLabelDao.insert(articleLabel);
        }

        //添加分类
        Sort sort = articleDto.getSort();
        if (sort.getSortId() != null) {
            ArticleSort articleSort = new ArticleSort();
            articleSort.setArticleId(article.getArticleId());
            articleSort.setSortId(sort.getSortId());
            articleSortDao.insert(articleSort);
        }
        return count;
    }

    @Override
    public ArticleDTO getArticleDtoById(int id) {
        Article article = articlesDao.selectById(id);
        ArticleDTO articleDto = new ArticleDTO();
        articleDto.setArticleId(article.getArticleId());
        articleDto.setArticleTitle(article.getArticleTitle());
        articleDto.setArticleSummary(article.getArticleSummary());
        articleDto.setCreateTime(article.getCreateTime());
        articleDto.setArticleContent(article.getArticleContent());
        articleDto.setArticleStatus(article.getArticleStatus());
        //返回文章的标签
        List<Label> labels = articleLabelDao.listLabelByArticle(article.getArticleId());
        articleDto.setLabels(labels);
        //返回文章的分类
        Sort sort = articleSortDao.getSortByArticleId(article.getArticleId());
        articleDto.setSort(sort);
        return articleDto;
    }

    /**
     * 更新文章
     *
     * @param articleDto
     * @return
     */
    @Override
    public int updateArticle(ArticleDTO articleDto) {
        Article article = articlesDao.selectById(articleDto.getArticleId());
        if (article != null) {
            article.setArticleTitle(articleDto.getArticleTitle());
            article.setArticleContent(articleDto.getArticleContent());
            article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDto.getArticleContent()));
            article.setArticleStatus(articleDto.getArticleStatus());
            article.setCreateTime(articleDto.getCreateTime());
            article.setUpdateTime(new Date());
            //更新文章的的分类
            LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ArticleSort::getArticleId, article.getArticleId());
            articleSortDao.delete(wrapper);
            Sort sort = articleDto.getSort();
            ArticleSort articleSort = new ArticleSort();
            articleSort.setArticleId(article.getArticleId());
            articleSort.setSortId(sort.getSortId());
            articleSortDao.insert(articleSort);
            //更新文章的标签
            //先判断提交的标签是否
            LambdaQueryWrapper<ArticleLabel> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(ArticleLabel::getArticleId, article.getArticleId());
            articleLabelDao.delete(wrapper1);
            for (Label label : articleDto.getLabels()) {
                ArticleLabel articleLabel = new ArticleLabel();
                articleLabel.setArticleId(article.getArticleId());
                articleLabel.setLabelId(label.getLabelId());
                articleLabelDao.insert(articleLabel);
            }
            return articlesDao.updateById(article);
        } else {
            return 0;
        }
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
}
