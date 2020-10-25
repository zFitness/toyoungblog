package pers.zheng.blog.controller.content;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.vo.ArticleItemVo;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/10 15:19
 * @Version 1.0
 */
@Slf4j
@Controller
public class IndexPageController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "p", defaultValue = "1", required = false) int p) {
        log.info(p + "");
        int size = 10;
        IPage<ArticleItemVo> articleItems = articlesService.getArticleItems(p, size);
        log.info(articleItems.getRecords().toString());
        log.info(articleItems.getCurrent()+"");
        model.addAttribute("articleItems", articleItems);
        return "index";
    }
}
