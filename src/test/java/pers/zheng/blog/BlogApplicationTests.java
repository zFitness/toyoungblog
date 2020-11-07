package pers.zheng.blog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.zheng.blog.dao.ArticleSortDao;
import pers.zheng.blog.dao.LabelDao;
import pers.zheng.blog.dao.SortDao;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.entity.Sort;

import java.util.List;


@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private SortDao sortsDao;
    @Autowired
    private ArticleSortDao articleSortDao;
    @Autowired
    private LabelDao labelDao;

    @Test
    void contextLoads() {
//        System.out.println(sortsDao.selectById(2));
        Sort sort = articleSortDao.getSortByArticleId(8L);
        System.out.println(sort);
    }

    @Test
    void ss() {
        //先查询
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Label::getLabelName, "dddd");
        List<Label> labels = labelDao.selectList(queryWrapper);
        System.out.println(labels);
    }

}
