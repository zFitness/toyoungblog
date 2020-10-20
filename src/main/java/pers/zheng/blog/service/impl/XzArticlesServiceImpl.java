package pers.zheng.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.XzArticlesDao;
import pers.zheng.blog.entity.XzArticles;
import pers.zheng.blog.service.XzArticlesService;
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
public class XzArticlesServiceImpl implements XzArticlesService {
    @Autowired
    private XzArticlesDao xzArticlesDao;

    @Override
    public List<XzArticles> getAll() {
        return xzArticlesDao.selectList(null);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItems(int p, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return xzArticlesDao.getArticleItem(page, 1);
    }


    @Override
    public ArticleContentVo getArticleById(Long articleId) {
        return xzArticlesDao.getArticleById(articleId);
    }

    @Override
    public IPage<ArticleItemVo> getArticleItemsByLabel(int p, Integer labelId, int size) {
        Page<ArticleItemVo> page = new Page<>(p, size);
        return xzArticlesDao.getArticleItemByLabel(page, 1, labelId);
    }
}
