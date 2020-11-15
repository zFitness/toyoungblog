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
public class LabelDTO {
    /**
     * 标签id
     */
    private Integer labelId;
    /**
     * 标签名称
     */
    @NotBlank(message = "标签名不能为空")
    private String labelName;

    @NotBlank(message = "别名不能为空")
    private String labelSlug;
    /**
     * 标签描述
     */
    private String labelDescription;

}
