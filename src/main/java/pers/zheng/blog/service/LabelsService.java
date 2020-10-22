package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.LabelsDao;
import pers.zheng.blog.entity.Labels;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Service
public class LabelsService {
    @Autowired
    private LabelsDao labelsDao;

    public Labels getLabelByName(String labelName) {
        LambdaQueryWrapper<Labels> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Labels::getLabelName, labelName);
        Labels label = labelsDao.selectOne(queryWrapper);
        return label;
    }
}