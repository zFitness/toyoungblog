package pers.zheng.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.entity.ArticleLabel;
import pers.zheng.blog.model.entity.Label;

import java.util.List;

/**
 * (XzArticleLabel)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:22:56
 */
@Mapper
@Repository
public interface ArticleLabelDao {

    List<Label> getLabelByArticle(Long articleId);
}