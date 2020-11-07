package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.LinksDao;
import pers.zheng.blog.exception.admin.LinkNotFoundException;
import pers.zheng.blog.model.dto.LinkDTO;
import pers.zheng.blog.model.entity.Link;

import java.util.Date;
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

    public IPage<Link> listLinks(Integer current, Integer size) {
        Page<Link> pageConf = new Page<>(current, size);
        return linksDao.selectPage(pageConf, null);
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


    public int insert(LinkDTO linkDTO) {
        Link link = new Link();
        BeanUtils.copyProperties(linkDTO, link);
        link.setVisible(true);
        link.setCreateTime(new Date());
        return linksDao.insert(link);
    }

    public int update(LinkDTO linkDTO) {
        Link link = linksDao.selectById(linkDTO.getLinkId());
        if (link == null) {
            throw new LinkNotFoundException("链接不存在");
        }
        BeanUtils.copyProperties(linkDTO, link);
        return linksDao.updateById(link);
    }
}
