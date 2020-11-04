package pers.zheng.blog.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.entity.Sort;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleContentVo
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/17 18:24
 * @Version 1.0
 */
@Data
public class ArticleContentVO {
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
     * 转换后的目录html
     */
    private String articleTocHtml;
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


    /**
     * 分类
     */
    private Sort sort;

    /**
     * 标签
     */
    private List<Label> labels;
}
