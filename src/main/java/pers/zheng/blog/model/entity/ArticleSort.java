package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (XzArticleSort)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:01
 */
@Data
@TableName("ty_article_sort")
public class ArticleSort implements Serializable {
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



}