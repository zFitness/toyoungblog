package pers.zheng.blog.model.entity;

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
@TableName("ty_links")
public class Links {
    @TableId
    private Integer linkId;
    private String linkUrl;
    private String linkName;
    private String linkImage;
    private String linkTarget;
    private String linkDescription;
    private Integer linkVisible;
    private Date linkUpdated;
    private String linkRss;

}