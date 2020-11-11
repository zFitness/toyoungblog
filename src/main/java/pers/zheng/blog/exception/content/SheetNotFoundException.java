package pers.zheng.blog.exception.content;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/10
 */
public class SheetNotFoundException extends RuntimeException {

    public SheetNotFoundException() {
    }

    public SheetNotFoundException(String message) {
        super(message);
    }
}
