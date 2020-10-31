package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Option
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 22:07
 * @Version 1.0
 */
@Data
@TableName("ty_options")
public class Option {
    @TableId(type = IdType.AUTO)
    private Integer optionId;
    private String optionName;
    private String optionValue;
}
