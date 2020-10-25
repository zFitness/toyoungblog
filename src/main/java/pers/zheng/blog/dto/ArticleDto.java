package pers.zheng.blog.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import pers.zheng.blog.entity.Sorts;

import java.util.Date;

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
