package pers.zheng.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.zheng.blog.dao.SortsDao;


@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private SortsDao sortsDao;

    @Test
    void contextLoads() {
        System.out.println(sortsDao.selectById(2));
    }

}
