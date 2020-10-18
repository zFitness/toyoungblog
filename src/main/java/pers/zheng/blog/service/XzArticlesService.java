package pers.zheng.blog.service;

import pers.zheng.blog.entity.XzArticles;
import pers.zheng.blog.vo.ArticleContentVo;
import pers.zheng.blog.vo.ArticleItemVo;

import java.util.List;

/**
 * (XzArticles)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public interface XzArticlesService {
    List<XzArticles> getAll();

    List<ArticleItemVo> getArticleItems();

    ArticleContentVo getArticleById(Long articleId);
}