package pers.zheng.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/11 21:53
 * @Version 1.0
 */
@Controller
public class ArticleController {
    @RequestMapping("/article/{articleId}")
    public String test(Model model, @PathVariable("articleId") Long articleId) {
        model.addAttribute("name", "hello pillar");
        return "article";
    }
}
