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
    /**
     * 标签描述
     */
    private String labelDescription;

    /**
     * 标签对应的文章数量
     */
    private Integer articleCount;
}
