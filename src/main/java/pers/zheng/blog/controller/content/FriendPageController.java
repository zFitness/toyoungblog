package pers.zheng.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName FriendController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/21 10:25
 * @Version 1.0
 */
@Controller
@RequestMapping("/friends")
public class FriendPageController {
    @RequestMapping("")
    public String friends(Model model) {

        return "friend-links";
    }
}
