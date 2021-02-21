package com.wk.service;

import com.wk.dao.ManagerDao;
import com.wk.model.Msg;
import com.wk.vo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired(required = false)
    private ManagerDao managerDao;

    public Msg login(Manager manager) {
        if (manager.getPassword() != null) {
            String managername = manager.getManagername();
            String password = managerDao.queryPwdByManagername(managername);
            if (password != null && password.equals(manager.getPassword())) {
                return new Msg("200", "right", "");
            } else {
                return new Msg("400", "wrong", "");
            }
        } else {
            return new Msg("400", "密码不能为空！", "");
        }
    }
}
