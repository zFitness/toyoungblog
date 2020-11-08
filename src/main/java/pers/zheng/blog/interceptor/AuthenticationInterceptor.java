package pers.zheng.blog.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pers.zheng.blog.annotation.TokenRequired;
import pers.zheng.blog.exception.admin.TokenException;
import pers.zheng.blog.model.entity.User;
import pers.zheng.blog.model.util.JwtUtil;
import pers.zheng.blog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从http请求头中获取 token
        String token = request.getHeader("X-token");
        //
        //检查有没有需要用户权限的注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired userLoginToken = method.getAnnotation(TokenRequired.class);
            if (!userLoginToken.required()) {
                return true;
            }
        }
        //执行认证
        if (token == null) {
            throw new TokenException("token不存在");
        }
        //获取token的用户id
        int userId;
        try {
            //字符串类型需要转为int
            userId = JWT.decode(token).getClaim("userId").asInt();
        } catch (JWTDecodeException e) {
            throw new TokenException("token格式错误");
        }

        User user = userService.findUserById(userId);
        if (user == null) {
            throw new TokenException("用户不存在");
        }

        if (!JwtUtil.verity(token, user.getPassword())) {
            throw new TokenException("令牌无效");
        }

        return true;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
