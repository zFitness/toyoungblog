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
public class SortVO {
    /**
     * 分类id
     */
    @TableId(type = IdType.AUTO)
    private Integer sortId;
    /**
     * 分类名称
     */
    private String sortName;
    /**
     * 分类别名
     */
    private String sortAlias;
    /**
     * 分类描述
     */
    private String sortDescription;
    /**
     * 父分类ID
     */
    private Integer parentSortId;
    /**
     * 分类的文章数量
     */
    private Integer count;
}
