package pers.zheng.blog.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pers.zheng.blog.service.SeoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/16
 */
@Controller
public class MainController {
    @Autowired
    private SeoService seoService;

    @GetMapping("/favicon.ico")
    public void favicon(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://img.zmblog.wang/blogfavicon.ico");
    }

    @GetMapping(value = "robots.txt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String robots(Model model) {
        model.addAttribute("name", "哈复活复活");
        return "other/robots.txt";
    }

    @GetMapping("/sitemap.xml")
    public void createSiteMapXml(HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_XML_VALUE);
        Writer writer = response.getWriter();
        writer.append(seoService.createSiteMapXmlContent());
    }
}
