package pers.zheng.blog.entity;

import java.io.Serializable;

/**
 * (XzArticleLabel)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:22:56
 */
public class XzArticleLabel implements Serializable {
    private static final long serialVersionUID = 911985186110460559L;

    private Integer id;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 标签id
     */
    private Integer labelId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

}