package pers.zheng.blog.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.zheng.blog.exception.admin.DefaultNotFoundException;
import pers.zheng.blog.exception.admin.ItemExistException;
import pers.zheng.blog.exception.admin.LinkNotFoundException;
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

    @ExceptionHandler({DefaultNotFoundException.class})
    public Result handler4(Exception e) {
        return new Result(503, e.getMessage(), null);
    }

    @ExceptionHandler({ItemExistException.class})
    public Result handler5(Exception e) {
        return new Result(504, e.getMessage(), null);
    }
}

