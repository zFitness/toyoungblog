package pers.zheng.blog.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.zheng.blog.model.entity.Sheet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SheetDTO extends Sheet {
    /**
     * 文章id
     */
    private Integer sheetId;
    /**
     * 内容
     */
    private String sheetContent;
    /**
     * 标题
     */
    @NotBlank(message = "页面标题不能为空")
    @Size(max = 50, message = "页面标题的字符长度不能超过 {max}")
    private String sheetTitle;
    /**
     * 别名
     */
    @NotBlank(message = "别名不能为空")
    @Size(max = 100, message = "页面标题的字符长度不能超过 {max}")
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
