package pers.zheng.blog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
@Data
public class LinkDTO {
    private Integer linkId;


    @NotBlank(message = "链接地址不能为空")
    @Pattern(regexp = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]", message = "URL格式不正确")
    private String linkUrl;
    @NotBlank(message = "链接名不能为空")
    private String linkName;
    @Pattern(regexp = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]", message = "URL格式不正确")
    @NotBlank(message = "图片地址不能为空")
    private String linkImage;
    private String linkTarget;
    @NotBlank(message = "网址描述不能为空")
    private String linkDescription;
    private Boolean visible;
    private Date createTime;
    private String linkRss;
}
