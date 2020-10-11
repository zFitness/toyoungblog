package pers.zheng.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/10 15:19
 * @Version 1.0
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model){
        System.out.println("测试");
        model.addAttribute("name","hello pillar");
        return "index";
    }
}
