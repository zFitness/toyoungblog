package pers.zheng.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (XzSorts)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Data
public class XzSorts implements Serializable {
    private static final long serialVersionUID = -88853805527558525L;
    /**
     * 分类id
     */
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


}