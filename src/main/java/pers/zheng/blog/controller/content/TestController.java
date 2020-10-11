package pers.zheng.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zheng
 * @Date 2020/9/28 18:01
 * @Version 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("name","hello pillar");
        return "index";
    }
}
