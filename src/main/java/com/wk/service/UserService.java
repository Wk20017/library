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
        String pwd = loginIfo.getPassword();
        if (pwd != null) {
            String userInfo = loginIfo.getUserInfo();
            if (null != userInfo) {
                if (userInfo.contains("@")) {
                    System.out.println("email");
                    String pwdByEmail = userDao.queryPwdByEmail(userInfo);
                    if (null != pwdByEmail) {
                        if (pwdByEmail.equals(MD5Utils.getPwd(pwd))) {
                            return new Msg("200", "登录成功！", "");
                        } else {
                            return new Msg("400", "密码错误！", "");
                        }
                    } else {
                        return new Msg("400", "用户不存在！", "");
                    }
                } else {
                    System.out.println("name");
                    String pwdByName = userDao.queryPwdByUsername(userInfo);
                    if (null != pwdByName) {
                        if (pwdByName.equals(MD5Utils.getPwd(pwd))) {
                            return new Msg("200", "登录成功！", "");
                        } else {
                            return new Msg("400", "密码错误！", "");
                        }
                    } else {
                        return new Msg("400", "用户不存在！", "");
                    }
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
            if (q_email == null && q_username == null && email != null && username != null && password != null) {
                if (!username.contains("@")) {
                    //加密
                    password = MD5Utils.getPwd(user.getPassword());
                    userDao.addUser(email, username, password);
                    return new Msg("200", "注册成功！", "");
                } else {
                    return new Msg("400", "用户名不能含有@！", "");
                }
            } else {
                return new Msg("400", "用户已存在！", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "注册失败！", "");
        }

    }
}
