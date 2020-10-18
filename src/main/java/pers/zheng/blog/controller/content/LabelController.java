package pers.zheng.blog.controller.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/18 12:49
 * @Version 1.0
 */
@Controller
@RequestMapping("/label")
public class LabelController {
    /**
     * @return
     */
    @RequestMapping("")
    public String getAll() {
        return "a";
    }

    @GetMapping("/{labelName}")
    public String getOne(@PathVariable String labelName) {

        return "label";
    }

}
