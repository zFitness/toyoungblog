package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.LinksDao;
import pers.zheng.blog.model.entity.Link;

import java.util.List;

/**
 * @ClassName LinkService
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 20:14
 * @Version 1.0
 */
@Service
public class LinkService {
    @Autowired
    private LinksDao linksDao;

    public List<Link> listLinks() {
        LambdaQueryWrapper<Link> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Link::getLinkVisible, 1);
        return linksDao.selectList(wrapper);
    }
}
