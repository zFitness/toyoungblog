package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.ArticlesDao;
import pers.zheng.blog.entity.Articles;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.vo.ArticleContentVo;
import pers.zheng.blog.vo.ArticleItemVo;

import java.util.List;

/**
 * @ClassName XzArticlesServiceImpl
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/11 23:30
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesDao articlesDao;

    @Override
    public List<Articles> getAll() {
        return articlesDao.selectList(null);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItems(int p, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItem(page, 1);
    }


    @Override
    public ArticleContentVo getArticleById(Long articleId) {
        return articlesDao.getArticleById(articleId);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItemByLabel(page, 1, labelId);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItemsByName(int p, int size, String keyword) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return articlesDao.getArticleItemsByName(page, 1, keyword);
    }
}
