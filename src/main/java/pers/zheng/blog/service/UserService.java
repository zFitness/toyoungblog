package pers.zheng.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zheng.blog.dao.UserDao;
import pers.zheng.blog.exception.admin.LoginException;
import pers.zheng.blog.model.entity.User;
import pers.zheng.blog.model.util.JwtUtil;


/**
 * (XzUsers)表服务接口
 *
 * @author makejava
 * @since 2020-10-11 23:23:04
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String login(String name, String password) {
        String token = null;

        //查看用户是否存在
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUsername, name);
        User user = userDao.selectOne(wrapper);
        if (user == null) {
            throw new LoginException("用户名错误");
        } else {
            if (!user.getPassword().equals(password)) {
                throw new LoginException("密码错误");
            } else {
                token = JwtUtil.sign(user.getUsername(), user.getUserId(), user.getPassword());
            }
        }

        return token;
    }

    public User findUserById(int userId) {
        return userDao.selectById(userId);
    }
}