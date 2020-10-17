package pers.zheng.blog.entity;

import java.io.Serializable;

/**
 * (XzSorts)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
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


    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortAlias() {
        return sortAlias;
    }

    public void setSortAlias(String sortAlias) {
        this.sortAlias = sortAlias;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public Integer getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(Integer parentSortId) {
        this.parentSortId = parentSortId;
    }

}