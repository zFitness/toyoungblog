package pers.zheng.blog.controller.admin.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/23 13:46
 * @Version 1.0
 */
@Controller
public class AdminController {
    @GetMapping("/admin")
    public void index(HttpServletResponse response) {
        try {
            response.sendRedirect("/admin/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
