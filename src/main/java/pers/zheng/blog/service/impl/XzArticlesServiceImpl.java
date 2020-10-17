package pers.zheng.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.XzArticlesDao;
import pers.zheng.blog.entity.XzArticles;
import pers.zheng.blog.service.XzArticlesService;
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
    public List<ArticleItemVo> getArticleItems() {
        return xzArticlesDao.getArticleItem();
    }
}
