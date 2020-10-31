package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.LabelsDao;
import pers.zheng.blog.model.entity.Label;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Service
public class LabelService {
    @Autowired
    private LabelsDao labelsDao;

    public Label getLabelByName(String labelName) {
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Label::getLabelName, labelName);
        Label label = labelsDao.selectOne(queryWrapper);
        return label;
    }
}