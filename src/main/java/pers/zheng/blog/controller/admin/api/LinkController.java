package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.LinkDTO;
import pers.zheng.blog.model.dto.result.ResponseCode;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.Link;
import pers.zheng.blog.service.LinkService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/6
 */
@Slf4j
@CrossOrigin
@RestController()
@RequestMapping("/api/admin/links")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping("")
    public Result list(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
                       @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {
        return Result.success(linkService.listLinks(current, size));
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody LinkDTO link) {
        log.info(link.toString());
        //还需要校验数据是否合法
        int i = linkService.insert(link);
        return Result.success();
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody LinkDTO link) {
        log.info(link.toString());
        //还需要校验数据是否合法
        int i = linkService.update(link);
        return Result.success();
    }

    @PostMapping("visible")
    public Result setVisible(@RequestParam("linkId") Integer linkId,
                             @RequestParam("visible") boolean visible) {
        int i = linkService.setVisible(linkId, visible);
        return Result.success();
    }

    @PostMapping("delete")
    public Result delete(@RequestParam("linkId") Integer linkId) {
        int i = linkService.deleteById(linkId);
        if (i != 0) {
            return Result.success();
        } else {
            return Result.failure(ResponseCode.LINK_NOT_FOUND);
        }
    }
}
