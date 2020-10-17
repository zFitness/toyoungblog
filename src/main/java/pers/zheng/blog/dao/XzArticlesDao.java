package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.entity.XzArticles;
import pers.zheng.blog.vo.ArticleItemVo;

import java.util.List;

/**
 * (XzArticles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface XzArticlesDao extends BaseMapper<XzArticles> {
    List<ArticleItemVo> getArticleItem();
}