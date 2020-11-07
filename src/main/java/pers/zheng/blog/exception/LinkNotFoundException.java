package pers.zheng.blog.exception;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {
    }

    public LinkNotFoundException(String message) {
        super(message);
    }
}
