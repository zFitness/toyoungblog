package pers.zheng.blog.controller.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.model.entity.Link;
import pers.zheng.blog.service.LinkService;

import java.util.List;

/**
 * @ClassName LinksController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/22 20:12
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/links")
public class LinksPageController {
    @Autowired
    private LinkService linkService;


    @RequestMapping("")
    public String listLinks(Model model) {
        List<Link> links = linkService.listVisibleLinks();
        log.info(links.toString());
        model.addAttribute("links", links);
        return "friend-links";
    }
}
