package pers.zheng.blog.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zheng.blog.model.dto.DashboardDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.service.OptionService;

import java.util.Map;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/8
 */
@RequestMapping("/api/admin")
@RestController
public class DashboardController {
    @Autowired
    private OptionService optionService;

    @GetMapping("dashboard")
    public Result index() {
        DashboardDTO dashboard = optionService.getDashboard();
        return Result.success(dashboard);
    }
}
