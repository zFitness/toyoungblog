package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import pers.zheng.blog.entity.Articles;
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
    List<Articles> getAll();

    IPage<ArticleItemVo> getArticleItems(int p, int size);

    ArticleContentVo getArticleById(Long articleId);

    IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size);

    IPage<ArticleItemVo> getArticleItemsByName(int p, int size, String keyword);
}