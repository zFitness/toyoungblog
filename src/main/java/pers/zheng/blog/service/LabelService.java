package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.LabelDao;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.model.vo.LabelVo;

import java.util.List;

/**
 * (XzLabels)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:03
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    public Label getLabelByName(String labelName) {
        LambdaQueryWrapper<Label> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Label::getLabelName, labelName);
        return labelDao.selectOne(queryWrapper);
    }

    public List<LabelVo> getAllLabelVO() {
        return labelDao.getAllLabelVO();
    }

    public Label addByName(String labelName) {
        Label label = new Label();
        label.setLabelName(labelName);
        int count = labelDao.insert(label);
        return label;
    }

    public List<Label> getAllLabel() {
        return labelDao.selectList(null);
    }
}