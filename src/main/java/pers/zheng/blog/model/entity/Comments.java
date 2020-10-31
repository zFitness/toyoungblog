package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (XzComments)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Data
@TableName("ty_comments")
public class Comments implements Serializable {
    private static final long serialVersionUID = 882658646303495437L;
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
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

}