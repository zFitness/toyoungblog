package pers.zheng.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.zheng.blog.dao.SortDao;


@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private SortDao sortsDao;

    @Test
    void contextLoads() {
        System.out.println(sortsDao.selectById(2));
    }

}
