package pers.zheng.blog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
@Data
public class SortDTO {
    private Integer sortId;
    /**
     * 分类名称
     */
    @NotBlank(message = "分类名不能为空")
    private String sortName;
    /**
     * 分类别名
     */
    @NotBlank(message = "别名不能为空")
    private String sortAlias;
    /**
     * 分类描述
     */
    private String sortDescription;
    /**
     * 父分类ID
     */
    @NotNull(message = "父分类不能为null")
    private Integer parentSortId;

}
