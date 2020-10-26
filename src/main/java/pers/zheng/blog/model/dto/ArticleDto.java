package pers.zheng.blog.model.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName ArticleSummaryVO
 * @Description 文章概要
 * @Author zheng
 * @Date 2020/10/12 12:24
 * @Version 1.0
 */
@Data
@ToString(callSuper = true)
public class ArticleDto extends ArticleItemDto {
    private String articleContent;
}
