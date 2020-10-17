package pers.zheng.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (XzComments)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
public class XzComments implements Serializable {
    private static final long serialVersionUID = 882658646303495437L;
    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 评论时间
     */
    private Date commentDate;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 父评论id
     */
    private Integer parentCommentId;
    /**
     * 评论用户名
     */
    private String commentUserName;
    /**
     * 评论用户邮箱
     */
    private String commentUserEmail;
    /**
     * 用户网站链接
     */
    private String commentUserUrl;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentUserEmail() {
        return commentUserEmail;
    }

    public void setCommentUserEmail(String commentUserEmail) {
        this.commentUserEmail = commentUserEmail;
    }

    public String getCommentUserUrl() {
        return commentUserUrl;
    }

    public void setCommentUserUrl(String commentUserUrl) {
        this.commentUserUrl = commentUserUrl;
    }

}