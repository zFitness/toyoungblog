package pers.zheng.blog.exception.admin;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class ItemExistException extends RuntimeException{
    public ItemExistException() {
    }

    public ItemExistException(String message) {
        super(message);
    }
}
