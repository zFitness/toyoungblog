package pers.zheng.blog.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.entity.Sort;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleSummaryVO
 * @Description 文章概要
 * @Author zheng
 * @Date 2020/10/12 12:24
 * @Version 1.0
 */
@Data
public class ArticleItemDTO {

    private Integer articleId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章别名
     */
    private String articleSlug;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    /**
     * 文章评论数
     */
    private Long articleCommentCount;

    /**
     * 文章摘要
     */
    private String articleSummary;

    /**
     * 文章分类
     */
    private Sort sort;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 文章标签
     */
    private List<Label> labels;

    /**
     * 是否开启评论
     */
    private Boolean commentStatus;
}
