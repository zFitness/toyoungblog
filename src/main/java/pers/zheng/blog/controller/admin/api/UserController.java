package pers.zheng.blog.controller.admin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.User;

import java.util.ArrayList;
import java.util.Map;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author zheng
 * @Date 2020/10/29 10:52
 * @Version 1.0
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> map) {
        log.info(map.toString());
        String username = map.get("username");
        String password = map.get("password");

        if ("admin".equals(username) && "admin123".equals(password)) {
            return Result.success("admin-token");
        }
        return Result.failure();
    }

    @GetMapping("/info")
    public Result userInfo(@RequestParam("token") String token) {
        User user = new User();
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        user.setName("test");
        user.setIntroduction("hhhhhhhh");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        user.setRoles(roles);
        return Result.success(user);
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.success();
    }
}

