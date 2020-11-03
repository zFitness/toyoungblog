package pers.zheng.blog.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.zheng.blog.model.vo.LabelVo;
import pers.zheng.blog.model.vo.SortVo;
import pers.zheng.blog.service.LabelService;
import pers.zheng.blog.service.SortService;

import java.util.List;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/18 12:49
 * @Version 1.0
 */
@Controller
public class ArchivePageController {

    @Autowired
    private SortService sortsService;

    @Autowired
    private LabelService labelService;

    /**
     * @return
     */
    @RequestMapping("archives")
    public String getAll(Model model) {
        List<SortVo> sorts = sortsService.getAllSort();
        List<LabelVo> labels = labelService.getAllLabelVO();
        model.addAttribute("sorts", sorts);
        model.addAttribute("labels", labels);
        return "archives";
    }
}
