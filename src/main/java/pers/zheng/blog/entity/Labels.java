package pers.zheng.blog.entity;

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
@TableName("ty_labels")
public class Labels implements Serializable {
    private static final long serialVersionUID = -81886925531446951L;
    /**
     * 标签id
     */
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