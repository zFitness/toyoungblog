package pers.zheng.blog.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.service.XzArticlesService;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/10 15:19
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Autowired
    private XzArticlesService xzArticlesService;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("测试");
        System.out.println(xzArticlesService.getArticleItems());
        model.addAttribute("articleItems", xzArticlesService.getArticleItems());
        return "index";
    }
}
