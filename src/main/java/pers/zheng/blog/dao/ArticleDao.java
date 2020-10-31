package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.dto.ArticleItemDto;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.model.vo.ArticleContentVo;
import pers.zheng.blog.model.vo.ArticleItemVo;

/**
 * (XzArticles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    IPage<ArticleItemVo> getArticleItem(Page<?> page, String state);

    ArticleContentVo getArticleById(Long articleId);

    IPage<ArticleItemVo> getArticleItemByLabel(Page<ArticleItemVo> page, String state, int labelId);

    IPage<ArticleItemVo> getArticleItemsByName(Page<ArticleItemVo> page, String state, String keyword);

    IPage<ArticleItemDto> getArticleDtoItems(Page<ArticleItemVo> page);
}