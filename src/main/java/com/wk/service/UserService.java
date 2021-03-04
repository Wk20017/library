package com.wk.service;


import com.wk.dao.UserDao;
import com.wk.model.LoginIfo;
import com.wk.model.Msg;
import com.wk.utils.MD5Utils;
import com.wk.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserDao userDao;

    public Msg login(LoginIfo loginIfo) {
        if (loginIfo.getPassword() != null){
            if (null != userDao.queryPwdByUsername(loginIfo.getUserInfo())) {
                String username = loginIfo.getUserInfo();
                String password = userDao.queryPwdByUsername(username);
                if (password != null && password.equals(MD5Utils.getPwd(loginIfo.getPassword()))) {
                    return new Msg("200", "登录成功！", "");
                } else if(null != username){
                    return new Msg("400", "密码错误！", "");
                } else {
                    return new Msg("400", "用户不存在！", "");
                }
            } else if (null != userDao.queryPwdByEmail(loginIfo.getUserInfo())){
                String email = loginIfo.getUserInfo();
                String password = userDao.queryPwdByEmail(email);
                if (password != null && password.equals(MD5Utils.getPwd(loginIfo.getPassword()))) {
                    return new Msg("200", "登录成功！", "");
                } else if(null != email){
                    return new Msg("400", "密码错误！", "");
                } else {
                    return new Msg("400", "用户不存在！", "");
                }
            } else {
                return new Msg("400", "用户不存在！", "");
            }
        } else {
            return new Msg("400", "密码不能为空！", "");
        }
    }

    public Msg signin(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();

        String q_email = userDao.queryPwdByEmail(email);
        String q_username = userDao.queryPwdByUsername(username);
        try {
            if (q_email == null && q_username == null && email != null && username != null && password != null){
                //加密
                password = MD5Utils.getPwd(user.getPassword());
                userDao.addUser(email, username, password);
                return new Msg("200", "注册成功！", "");
            } else {
                return new Msg("400", "用户已存在！", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "注册失败！", "");
        }

    }
}
