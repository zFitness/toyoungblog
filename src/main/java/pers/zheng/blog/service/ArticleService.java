package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import pers.zheng.blog.model.dto.ArticleDTO;
import pers.zheng.blog.model.dto.ArticleItemDTO;
import pers.zheng.blog.model.entity.Article;
import pers.zheng.blog.model.vo.ArticleContentVO;
import pers.zheng.blog.model.vo.ArticleItemVO;

import java.util.List;

/**
 * (XzArticles)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public interface ArticleService {
    List<Article> getAll();

    IPage<ArticleItemVO> listArticlePages(int p, int size);

    IPage<ArticleItemDTO> listArticleDtoItems(int current, int size, String title);

    ArticleContentVO getArticleById(Long articleId);

    IPage<ArticleItemVO> getArticleItemsByLabel(int p, Integer labelId, int size);

    IPage<ArticleItemVO> listArticleItemsByName(int p, int size, String keyword);

    int insertArticle(ArticleDTO article);

    ArticleDTO getArticleDtoById(int id);

    int updateArticle(ArticleDTO articleDto);

    int deleteArticleById(int id);

    int setArticleStatus(int articleId, String articleStatus);

    IPage<ArticleItemVO> getArticleItemsBySort(int p, Integer sortId, int size);

    ArticleItemVO getPrevArticleItemByArticleId(Long articleId);

    ArticleItemVO getNextArticleItemByArticleId(Long articleId);
}