package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.XzLabelsDao;
import pers.zheng.blog.entity.XzLabels;

import java.util.List;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Service
public class XzLabelsService {
    @Autowired
    private XzLabelsDao labelsDao;

    public XzLabels getLabelByName(String labelName) {
        LambdaQueryWrapper<XzLabels> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(XzLabels::getLabelName, labelName);
        XzLabels label = labelsDao.selectOne(queryWrapper);
        return label;
    }
}