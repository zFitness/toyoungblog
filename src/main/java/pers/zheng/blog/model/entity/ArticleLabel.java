package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (XzArticleLabel)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:22:56
 */
@Data
@TableName("ty_article_label")
public class ArticleLabel implements Serializable {
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




}