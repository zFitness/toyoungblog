package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (XzComments)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:02
 */
@Data
@TableName("ty_comment")
public class Comment implements Serializable {
    private static final long serialVersionUID = 882658646303495437L;


}