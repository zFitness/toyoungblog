package pers.zheng.blog.controller.admin.api;

import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.zheng.blog.annotation.TokenRequired;
import pers.zheng.blog.model.dto.result.Result;
import pers.zheng.blog.model.entity.User;
import pers.zheng.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
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
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @TokenRequired(required = false)
    @PostMapping("/api/admin/user/login")
    public Result login(@RequestBody Map<String, String> map) {
        log.info(map.toString());
        String username = map.get("username");
        String password = map.get("password");
        String token = userService.login(username, password);
        return Result.success(token);
    }

    @GetMapping("/api/admin/user/info")
    public Result userInfo(HttpServletRequest request) {
        String token = request.getHeader("X-token");
        int userId = JWT.decode(token).getClaim("userId").asInt();
        User user = userService.findUserById(userId);
        user.setIntroduction("hhhhhhhh");
        ArrayList<String> roles = new ArrayList<>();
        roles.add("admin");
        user.setRoles(roles);
        return Result.success(user);
    }

    @TokenRequired(required = false)
    @PostMapping("/api/admin/user/logout")
    public Result logout() {
        return Result.success();
    }
}

