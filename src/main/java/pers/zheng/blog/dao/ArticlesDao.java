package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.entity.Articles;
import pers.zheng.blog.vo.ArticleContentVo;
import pers.zheng.blog.vo.ArticleItemVo;

/**
 * (XzArticles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface ArticlesDao extends BaseMapper<Articles> {
    IPage<ArticleItemVo> getArticleItem(Page<?> page, Integer state);

    ArticleContentVo getArticleById(Long articleId);

    IPage<ArticleItemVo> getArticleItemByLabel(Page<ArticleItemVo> page, int state, int labelId);

    IPage<ArticleItemVo> getArticleItemsByName(Page<ArticleItemVo> page, int state, String keyword);
}