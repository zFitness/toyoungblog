package pers.zheng.blog.exception.content;

/**
 * @ClassName TestException
 * @Description TODO
 * @Author zheng
 * @Date 2020/11/4 9:11
 * @Version 1.0
 */
public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message) {
        super(message);
    }
}
