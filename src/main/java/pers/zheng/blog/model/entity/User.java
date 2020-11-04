package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (XzUsers)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
@Data
@TableName("ty_user")
public class User implements Serializable {
    private static final long serialVersionUID = 704758868845611742L;
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 昵称
     */
    private String userNickname;
    /**
     * 头像
     */
    private String avatar;

    private String introduction;

    private List<String> roles;

}