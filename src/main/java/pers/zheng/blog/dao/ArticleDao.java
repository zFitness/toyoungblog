package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.dto.ArticleItemDTO;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.model.vo.ArticleContentVO;
import pers.zheng.blog.model.vo.ArticleItemVO;

/**
 * (XzArticles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    IPage<ArticleItemVO> listArticlePages(Page<?> page, String state);

    ArticleContentVO getArticleById(Long articleId);

    IPage<ArticleItemVO> getArticleItemByLabel(Page<ArticleItemVO> page, String state, int labelId);

    IPage<ArticleItemVO> listArticleItemsByName(Page<ArticleItemVO> page, String state, String keyword);

    IPage<ArticleItemDTO> listArticleDtoItems(Page<ArticleItemDTO> page, String title);

    IPage<ArticleItemVO> getArticleItemBySort(Page<ArticleItemVO> page, String state, Integer sortId);

    ArticleItemVO getPrevArticleItemByArticleId(Long articleId);

    ArticleItemVO getNextArticleItemByArticleId(Long articleId);
}