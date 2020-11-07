package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.LabelDTO;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.Label;
import pers.zheng.blog.service.LabelService;

import javax.validation.Valid;
import java.util.List;

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
@RequestMapping("/api/admin/labels")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @GetMapping("")
    public Result getAll() {
        return Result.success(labelService.getAllLabel());
    }

    /**
     * 根据姓名添加标签
     *
     * @param labelName
     * @return
     */
    @PostMapping("/addByName")
    public Result addByName(@RequestParam(value = "labelName", required = true) String labelName) {
        Label label = labelService.addByName(labelName);
        return Result.success(label);
    }


    @PostMapping("update")
    public Result update(@Valid @RequestBody LabelDTO labelDTO) {
        int i = labelService.update(labelDTO);
        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam(value = "labelId", required = true) Integer labelId) {
        int i = labelService.delete(labelId);
        return Result.success();
    }
}
