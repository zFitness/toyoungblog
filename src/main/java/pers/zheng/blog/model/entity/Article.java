package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (XzArticles)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Data
@TableName("ty_article")
public class Article implements Serializable {
    private static final long serialVersionUID = 647796731339516238L;
    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Long articleId;
    /**
     * 文章内容
     */
    @TableField("article_content")
    private String articleContent;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章访问量
     */
    private Long articleViewCount;
    /**
     * 文章点赞数
     */
    private Long articleLikeCount;
    /**
     * 文章发布日期
     */
    private Date articleDate;
    /**
     * 文章评论数
     */
    private Long articleCommentCount;

    /**
     * 文章摘要
     */
    private String articleSummary;

    private String articleStatus;
}