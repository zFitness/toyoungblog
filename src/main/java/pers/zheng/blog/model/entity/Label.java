package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * (XzLabels)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Data
@TableName("ty_label")
public class Label implements Serializable {
    private static final long serialVersionUID = -81886925531446951L;
    /**
     * 标签id
     */
    @TableId(type = IdType.AUTO)
    private Integer labelId;
    /**
     * 标签名称
     */
    private String labelName;
    /**
     * 标签描述
     */
    private String labelDescription;


}