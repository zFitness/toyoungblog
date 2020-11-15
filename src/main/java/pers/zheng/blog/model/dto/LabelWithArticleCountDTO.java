package pers.zheng.blog.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;


/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class LabelWithArticleCountDTO extends LabelDTO {
    /**
     * 标签对应的文章数量
     */
    private Integer articleCount;
}
