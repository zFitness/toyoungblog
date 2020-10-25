package pers.zheng.blog.controller.content;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.misc.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.entity.Option;
import pers.zheng.blog.service.ArticlesService;
import pers.zheng.blog.service.OptionService;
import pers.zheng.blog.vo.ArticleContentVo;

import java.util.Arrays;

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

        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[]{TablesExtension.create()}));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(aboutOption.getOptionValue());
        String aboutHtml = renderer.render(document);
        model.addAttribute("aboutHtml", aboutHtml);
        return "about";
    }
}
