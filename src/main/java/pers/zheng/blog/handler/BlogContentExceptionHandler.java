package pers.zheng.blog.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pers.zheng.blog.exception.ArticleNotFoundException;

/**
 * @ClassName BlogContentExceptionHandler
 * @Description 博客前台异常处理
 * @Author zheng
 * @Date 2020/11/4 9:06
 * @Version 1.0
 */
@ControllerAdvice(basePackages = {"pers.zheng.blog.controller.content",})
public class BlogContentExceptionHandler {
    @ExceptionHandler({ArticleNotFoundException.class})
    public String test(Exception e, Model model) {
        model.addAttribute("error_message", e.getMessage());
        return "error/404";
    }

}

