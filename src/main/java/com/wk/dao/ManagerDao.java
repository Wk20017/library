package com.wk.dao;

import org.apache.ibatis.annotations.Param;

public interface ManagerDao {
    String queryPwdByManagername(@Param("managername") String managername);
}
