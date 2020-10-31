package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticleDao;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.model.dto.ArticleDto;
import pers.zheng.blog.model.dto.ArticleItemDto;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.model.entity.ArticleSort;
import pers.zheng.blog.model.entity.Sort;
import pers.zheng.blog.model.vo.ArticleContentVo;
import pers.zheng.blog.model.vo.ArticleItemVo;
import pers.zheng.blog.service.ArticleService;
import pers.zheng.blog.util.MarkdownUtils;

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

    @Override
    public List<Article> getAll() {
        return articlesDao.selectList(null);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItems(int p, int size) {
        Page<ArticleItemVo> pageConf = new Page<>(p, size);
        IPage<ArticleItemVo> page = articlesDao.getArticleItem(pageConf, "publish");
        /**
         * 添加分类
         */
        return setArticleItemSorts(page);
    }

    @Override
    public IPage<ArticleItemDto> getArticleDtoItems(int p, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleDtoItems(page);
    }

    /**
     * 根据id获取文章
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleContentVo getArticleById(Long articleId) {
        ArticleContentVo article = articlesDao.getArticleById(articleId);
        LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleSort::getArticleId, article.getArticleId());
        ArticleSort articleSort = articleSortDao.selectOne(wrapper);
        Sort sort = null;
        if (articleSort != null) {
            sort = sortDao.selectById(articleSort.getSortId());
        } else {
            sort = sortDao.selectById(2);
        }
        article.setSort(sort);
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
    public IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        IPage<ArticleItemVo> publishArticle = articlesDao.getArticleItemByLabel(page, "publish", labelId);
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
    public IPage<ArticleItemVo> getArticleItemsByName(int p, int size, String keyword) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        IPage<ArticleItemVo> publishArticle = articlesDao.getArticleItemsByName(page, "publish", keyword);
        return setArticleItemSorts(publishArticle);
    }

    /**
     * 给文章列表的每一项添加数据
     *
     * @param publishArticle
     * @return
     */
    @NotNull
    private IPage<ArticleItemVo> setArticleItemSorts(IPage<ArticleItemVo> publishArticle) {
        for (ArticleItemVo record : publishArticle.getRecords()) {
            LambdaQueryWrapper<ArticleSort> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ArticleSort::getArticleId, record.getArticleId());
            ArticleSort articleSort = articleSortDao.selectOne(wrapper);
            Sort sort = null;
            if (articleSort != null) {
                sort = sortDao.selectById(articleSort.getSortId());
            } else {
                sort = sortDao.selectById(2);
            }
            record.setSort(sort);
        }
        return publishArticle;
    }

    @Override
    public int createArticle(ArticleDto articleDto) {
        //包装类型没有默认值
        Article article = new Article();

        article.setArticleTitle(articleDto.getArticleTitle());
        article.setArticleContent(articleDto.getArticleContent());
        article.setArticleDate(articleDto.getArticleDate());
        article.setArticleStatus(articleDto.getArticleStatus());
        //如果没有填写摘要则自动生成摘要
        if (articleDto.getArticleSummary() == null || articleDto.getArticleSummary().equals("")) {
            article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDto.getArticleContent()));
        } else {
            article.setArticleSummary(articleDto.getArticleSummary());
        }

        return articlesDao.insert(article);
    }

    @Override
    public ArticleDto getArticleDtoById(int id) {
        Article article = articlesDao.selectById(id);
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleId(article.getArticleId());
        articleDto.setArticleTitle(article.getArticleTitle());
        articleDto.setArticleSummary(article.getArticleSummary());
        articleDto.setArticleDate(article.getArticleDate());
        articleDto.setArticleContent(article.getArticleContent());
        articleDto.setArticleStatus(article.getArticleStatus());
        return articleDto;
    }

    @Override
    public int updateArticle(ArticleDto articleDto) {
        Article article = articlesDao.selectById(articleDto.getArticleId());
        if (article != null) {
            article.setArticleContent(articleDto.getArticleContent());
            //如果没有填写摘要则自动生成摘要
            if (articleDto.getArticleSummary() == null || articleDto.getArticleSummary().equals("")) {
                article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDto.getArticleContent()));
            } else {
                article.setArticleSummary(articleDto.getArticleSummary());
            }
            article.setArticleTitle(articleDto.getArticleTitle());
            article.setArticleStatus(articleDto.getArticleStatus());
            article.setArticleDate(articleDto.getArticleDate());
            return articlesDao.updateById(article);
        } else {
            return 0;
        }
    }

    @Override
    public int deleteArticleById(int id) {
        //返回影响行数
        return articlesDao.deleteById(id);
    }

    @Override
    public int setArticleStatus(int articleId, String articleStatus) {
        Article article = articlesDao.selectById(articleId);
        if (article != null) {
            article.setArticleStatus(articleStatus);
            return articlesDao.updateById(article);
        }
        return 0;
    }
}
