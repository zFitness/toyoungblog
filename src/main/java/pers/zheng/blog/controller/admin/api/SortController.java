package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.service.SortService;

/**
 * @ClassName LabelController
 * @Description TODO
 * @Author zheng
 * @Date 2020/11/1 19:29
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/api/admin/sorts")
public class SortController {
    @Autowired
    private SortService sortService;

    @GetMapping("")
    public Result getAll() {
        return Result.success(sortService.listSortVOs());
    }
}
