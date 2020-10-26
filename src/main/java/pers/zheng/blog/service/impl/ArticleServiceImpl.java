package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticlesDao;
import pers.zheng.blog.model.dto.ArticleDto;
import pers.zheng.blog.model.dto.ArticleItemDto;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.util.MarkdownUtils;
import pers.zheng.blog.model.vo.ArticleContentVo;
import pers.zheng.blog.model.vo.ArticleItemVo;

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
public class ArticleServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesDao articlesDao;

    @Override
    public List<Article> getAll() {
        return articlesDao.selectList(null);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItems(int p, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItem(page, "publish");
    }

    @Override
    public IPage<ArticleItemDto> getArticleDtoItems(int p, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleDtoItems(page);
    }


    @Override
    public ArticleContentVo getArticleById(Long articleId) {
        return articlesDao.getArticleById(articleId);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItemByLabel(page, 1, labelId);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItemsByName(int p, int size, String keyword) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItemsByName(page, 1, keyword);
    }

    @Override
    public int createArticle(ArticleDto articleDto) {
        //包装类型没有默认值
        Article article = new Article();

        article.setArticleTitle(articleDto.getArticleTitle());
        article.setArticleContent(articleDto.getArticleContent());
        article.setArticleDate(articleDto.getArticleDate());
        article.setArticleStatus(articleDto.getArticleStatus());
        if (articleDto.getArticleSummary() == null || articleDto.getArticleSummary().equals("")) {
            article.setArticleSummary(MarkdownUtils.getSummaryInMD(articleDto.getArticleContent()));
        } else {
            article.setArticleSummary(articleDto.getArticleSummary());
        }

        return articlesDao.insert(article);
    }
}
