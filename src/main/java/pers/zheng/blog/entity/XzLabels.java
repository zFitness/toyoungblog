package pers.zheng.blog.entity;

import java.io.Serializable;

/**
 * (XzLabels)实体类
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
public class XzLabels implements Serializable {
    private static final long serialVersionUID = -81886925531446951L;
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


    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription;
    }

}