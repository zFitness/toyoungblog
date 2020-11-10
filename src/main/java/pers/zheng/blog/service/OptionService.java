package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.OptionDao;
import pers.zheng.blog.model.dto.DashboardDTO;
import pers.zheng.blog.model.entity.Option;

import java.util.Map;

/**
 * @ClassName OptionService
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 22:20
 * @Version 1.0
 */
@Service
public class OptionService {
    @Autowired
    private OptionDao optionDao;


    public Option getOptionByName(String about) {
        LambdaQueryWrapper<Option> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Option::getOptionName, about);
        return optionDao.selectOne(wrapper);
    }

    public DashboardDTO getDashboard() {
        return null;
    }


}
