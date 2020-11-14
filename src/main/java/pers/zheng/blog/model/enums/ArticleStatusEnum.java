package pers.zheng.blog.model.enums;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/14
 */
public enum ArticleStatusEnum {
    /**
     * 文章不可见
     */
    DRAFT("publish"),
    /**
     * 文章可见
     */
    PUBLISH("draft");


    private final String value;

    ArticleStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
