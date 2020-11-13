package pers.zheng.blog.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.entity.Sort;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Accessors(chain = true)
public class ArticleDTO {
    private Long articleId;

    /**
     * 文章标题
     */
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 20, message = "标题长度在20以内")
    private String articleTitle;

    /**
     * 文章别名
     */
    @NotBlank(message = "别名不能为空")
    @Length(min = 1, max = 50, message = "别名长度在50以内")
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
    @NotNull(message = "发表时间不能为空")
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
     * 文章内容
     */
    @NotBlank(message = "文章不能为空")
    private String articleContent;

    /**
     * 开启评论
     */
    @NotNull(message = "必须选择是否开启评论状态")
    private Boolean commentStatus;

    /**
     * 分类
     */
    private Sort sort;

    /**
     * 文章状态
     */
    @NotBlank(message = "必须设置文章状态，可选值publish/draft")
    private String articleStatus;

    /**
     * 标签
     */
    private List<Label> labels;
}
