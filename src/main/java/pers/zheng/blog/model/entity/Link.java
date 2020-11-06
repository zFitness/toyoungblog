package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Links
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 20:05
 * @Version 1.0
 */
@Data
@TableName("ty_link")
public class Link {
    @TableId(type = IdType.AUTO)
    private Integer linkId;
    private String linkUrl;
    private String linkName;
    private String linkImage;
    private String linkTarget;
    private String linkDescription;
    @TableField("is_visible")
    private Boolean visible;
    private Date linkUpdated;
    private String linkRss;

}
