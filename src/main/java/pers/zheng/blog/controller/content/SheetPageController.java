package pers.zheng.blog.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.model.entity.Option;
import pers.zheng.blog.model.entity.Sheet;
import pers.zheng.blog.model.util.MarkdownEntity;
import pers.zheng.blog.service.OptionService;
import pers.zheng.blog.service.SheetService;
import pers.zheng.blog.util.MarkDown2HtmlWrapper;

/**
 * @ClassName AboutController
 * @Description 自定义页面
 * @Author zheng
 * @Date 2020/10/18 14:35
 * @Version 1.0
 */
@Controller
public class SheetPageController {
    @Autowired
    private SheetService sheetService;

    @GetMapping("/sheet/{sheetSlug}")
    public String sheet(Model model,
                        @PathVariable String sheetSlug) {
        Sheet sheet = sheetService.getSheetBySlug(sheetSlug, "publish");
        MarkdownEntity markdownEntity = MarkDown2HtmlWrapper.ofContent(sheet.getSheetContent());
        sheet.setSheetContent(markdownEntity.toString());
        model.addAttribute("sheet", sheet);
        return "sheet";
    }
}
