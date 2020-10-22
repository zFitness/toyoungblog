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
import pers.zheng.blog.service.ArticlesService;
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
public class AboutController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping("/about")
    public String index(Model model) {
        ArticleContentVo articleContentVO = articlesService.getArticleById(1L);

        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(new Extension[]{TablesExtension.create()}));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        Node document = parser.parse(articleContentVO.getArticleContent());
        articleContentVO.setArticleContentHTML(renderer.render(document));
        model.addAttribute("article", articleContentVO);
        return "about";
    }
}
