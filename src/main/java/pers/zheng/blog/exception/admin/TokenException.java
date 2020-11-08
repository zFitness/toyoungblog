package pers.zheng.blog.exception.admin;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class TokenException extends RuntimeException{
    public TokenException() {
    }

    public TokenException(String message) {
        super(message);
    }
}
