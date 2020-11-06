package pers.zheng.blog.exception;

/**
 * @ClassName TestException
 * @Description TODO
 * @Author zheng
 * @Date 2020/11/4 9:11
 * @Version 1.0
 */
public class LabelNotFoundException extends RuntimeException {
    public LabelNotFoundException() {
    }

    public LabelNotFoundException(String message) {
        super(message);
    }
}
