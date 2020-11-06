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
        return linksDao.selectList(null);
    }

    public List<Link> listVisibleLinks() {
        LambdaQueryWrapper<Link> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Link::getVisible, true);
        return linksDao.selectList(wrapper);
    }

    /**
     * 设置友链可见
     *
     * @param linkId
     * @param visible
     * @return
     */
    public int setVisible(Integer linkId, boolean visible) {
        Link link = linksDao.selectById(linkId);
        link.setVisible(visible);
        return linksDao.updateById(link);
    }

    public int deleteById(Integer linkId) {
        return linksDao.deleteById(linkId);
    }


}
