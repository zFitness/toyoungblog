package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import pers.zheng.blog.dto.ArticleDto;
import pers.zheng.blog.dto.ArticleItemDto;
import pers.zheng.blog.entity.Article;
import pers.zheng.blog.vo.ArticleContentVo;
import pers.zheng.blog.vo.ArticleItemVo;

import java.util.List;

/**
 * (XzArticles)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public interface ArticlesService {
    List<Article> getAll();

    IPage<ArticleItemVo> getArticleItems(int p, int size);

    IPage<ArticleItemDto> getArticleDtoItems(int p, int size);

    ArticleContentVo getArticleById(Long articleId);

    IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size);

    IPage<ArticleItemVo> getArticleItemsByName(int p, int size, String keyword);

    int createArticle(ArticleDto article);
}