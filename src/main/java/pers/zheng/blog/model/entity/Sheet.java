package pers.zheng.blog.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/10
 */
@Data
@TableName("ty_sheet")
public class Sheet {
    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Integer sheetId;
    /**
     * 内容
     */
    @TableField("sheet_content")
    private String sheetContent;
    /**
     * 标题
     */
    private String sheetTitle;
    /**
     * 别名
     */
    private String sheetSlug;
    /**
     * 访问量
     */
    private Long sheetViewCount;
    /**
     * 点赞数
     */
    private Long sheetLikeCount;
    /**
     * 发布日期
     */
    private Date createTime;
    /**
     * 评论数
     */
    private Long sheetCommentCount;

    private String sheetStatus;

    private Date updateTime;

    private Boolean commentStatus;
}
