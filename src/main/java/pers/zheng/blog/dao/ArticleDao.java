package pers.zheng.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.zheng.blog.model.dto.ArticleItemDTO;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.model.vo.ArticleVO;
import pers.zheng.blog.model.vo.ArticleItemVO;

import java.util.List;

/**
 * (XzArticles)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Mapper
@Repository
public interface ArticleDao extends BaseMapper<Article> {
    /**
     * 返回文章的 sitemap
     * @return
     */
    List<ArticleItemVO> listAllArticleSiteMap();
    /**
     * 分页查询
     *
     * @param page
     * @param state
     * @return
     */
    IPage<ArticleItemVO> listArticlePages(Page<?> page, String state);

    /**
     * 根据文章id获取文章
     *
     * @param articleId
     * @return
     */
    ArticleVO getArticleById(Integer articleId);

    /**
     * 根据标签分页获取文章
     *
     * @param page
     * @param state
     * @param labelId
     * @return
     */
    IPage<ArticleItemVO> listArticleItemByLabel(Page<ArticleItemVO> page, String state, int labelId);

    /**
     * 搜索分页
     *
     * @param page
     * @param state
     * @param keyword
     * @return
     */
    IPage<ArticleItemVO> listArticleItemsByName(Page<ArticleItemVO> page, String state, String keyword);

    /**
     * 后台搜索分页
     *
     * @param page
     * @param title
     * @return
     */
    IPage<ArticleItemDTO> listArticleDtoItems(Page<ArticleItemDTO> page, String title);

    /**
     * 根据分类分页查找文章
     *
     * @param page
     * @param state
     * @param sortId
     * @return
     */
    IPage<ArticleItemVO> getArticleItemBySort(Page<ArticleItemVO> page, String state, Integer sortId);

    /**
     * 当前文章的上一篇
     *
     * @param articleId
     * @return
     */
    ArticleItemVO getPrevArticleItemByArticleId(Integer articleId);

    /**
     * 当前文章的下一篇
     *
     * @param articleId
     * @return
     */
    ArticleItemVO getNextArticleItemByArticleId(Integer articleId);
}