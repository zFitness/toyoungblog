package pers.zheng.blog.controller.content;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/16
 */
@Controller
public class MainController {

    @GetMapping("/favicon.ico")
    public void favicon(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://img.zmblog.wang/blogfavicon.ico");
    }

    @GetMapping(value = "robots.txt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String robots(Model model) {
        model.addAttribute("name", "哈复活复活");
        return "other/robots.txt";
    }

}
