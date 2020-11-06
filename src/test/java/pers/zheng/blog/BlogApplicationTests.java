package pers.zheng.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.model.entity.Sort;


@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private SortDao sortsDao;
    @Autowired
    private ArticleSortDao articleSortDao;

    @Test
    void contextLoads() {
//        System.out.println(sortsDao.selectById(2));
        Sort sort = articleSortDao.getSortByArticleId(8L);
        System.out.println(sort);
    }

}
