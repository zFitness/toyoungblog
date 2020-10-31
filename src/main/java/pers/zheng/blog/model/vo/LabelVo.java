package pers.zheng.blog.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName SortVo
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/31 18:14
 * @Version 1.0
 */
@Data
public class LabelVo {
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
    /**
     * 标签对应的文章数量
     */
    private Integer articleCount;
}
