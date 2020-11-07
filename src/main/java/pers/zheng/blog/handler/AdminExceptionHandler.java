package pers.zheng.blog.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.zheng.blog.exception.LinkNotFoundException;
import pers.zheng.blog.model.dto.result.ResponseCode;
import pers.zheng.blog.model.dto.result.Result;

import javax.validation.ConstraintViolationException;

/**
 * @ClassName BlogContentExceptionHandler
 * @Description 博客前台异常处理
 * @Author zheng
 * @Date 2020/11/4 9:06
 * @Version 1.0
 */
@RestControllerAdvice(basePackages = {"pers.zheng.blog.controller.admin",})
public class AdminExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    public Result test(Exception e) {
        return new Result(501, e.getMessage(), null);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handler2(Exception e) {
        return new Result(501, e.getMessage(), null);
    }

    @ExceptionHandler({LinkNotFoundException.class})
    public Result handler3(Exception e) {
        return new Result(502, e.getMessage(), null);
    }
}

