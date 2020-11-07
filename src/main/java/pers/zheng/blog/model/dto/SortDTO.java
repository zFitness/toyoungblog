package pers.zheng.blog.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
    private String sortAlias;
    /**
     * 分类描述
     */
    private String sortDescription;
    /**
     * 父分类ID
     */
    private Integer parentSortId;
    /**
     * 分类的文章数量
     */
    private Integer count;
}
