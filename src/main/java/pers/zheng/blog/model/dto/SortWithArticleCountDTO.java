package pers.zheng.blog.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/15
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SortWithArticleCountDTO extends SortDTO {
    /**
     * 分类的文章数量
     */
    private Integer count;
}
