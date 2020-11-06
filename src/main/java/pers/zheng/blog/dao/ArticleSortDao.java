package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.entity.ArticleSort;
import pers.zheng.blog.model.entity.Sort;

import java.util.List;

/**
 * 文章标签表
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface ArticleSortDao extends BaseMapper<ArticleSort> {

    Sort getSortByArticleId(Long articleId);
}