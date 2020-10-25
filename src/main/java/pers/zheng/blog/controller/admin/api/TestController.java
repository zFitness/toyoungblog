package pers.zheng.blog.controller.admin.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author zheng
 * @Date 2020/9/28 18:01
 * @Version 1.0
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "index";
    }
}
