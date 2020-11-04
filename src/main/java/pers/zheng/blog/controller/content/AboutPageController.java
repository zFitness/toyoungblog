package pers.zheng.blog.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.model.entity.Option;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.service.OptionService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;

/**
 * @ClassName AboutController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/18 14:35
 * @Version 1.0
 */
@Controller
public class AboutPageController {
    @Autowired
    private OptionService optionService;

    @RequestMapping("/about")
    public String index(Model model) {

        Option aboutOption = optionService.getOptionByName("about");

        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(aboutOption.getOptionValue());
        String aboutHtml = markdownEntity.toString();
        model.addAttribute("aboutHtml", aboutHtml);
        return "about";
    }
}
