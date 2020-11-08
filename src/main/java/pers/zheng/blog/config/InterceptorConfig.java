package pers.zheng.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.zheng.blog.interceptor.AuthenticationInterceptor;

/**
 * @author zheng
 * @description TODO
 * @date 2020/11/7
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将我们上一步定义的实现了HandlerInceptor接口的拦截器
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/api/admin/**");
    }
}
