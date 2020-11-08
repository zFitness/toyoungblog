package pers.zheng.blog.exception.admin;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class LoginException extends RuntimeException{
    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
