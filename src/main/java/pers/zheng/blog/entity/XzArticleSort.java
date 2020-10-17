package pers.zheng.blog.entity;

import java.io.Serializable;

/**
 * (XzArticleSort)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:01
 */
public class XzArticleSort implements Serializable {
    private static final long serialVersionUID = 997887738957334353L;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 分类id
     */
    private Integer sortId;

    private Integer id;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}