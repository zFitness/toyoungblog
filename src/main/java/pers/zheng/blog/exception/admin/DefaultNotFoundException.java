package pers.zheng.blog.exception.admin;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class DefaultNotFoundException extends RuntimeException {
    public DefaultNotFoundException() {
    }

    public DefaultNotFoundException(String message) {
        super(message);
    }
}
