package com.easyget.service;

import com.easyget.entity.TSysUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TSysUserService extends BaseService<TSysUser> {

    Map<String, Object> checkLogin(HashMap<String, Object> params);

    Map<String, Object> saveBackUser(TSysUser sysUser);

    Map<String, Object> updateUserInfo(TSysUser sysUser);

    List<TSysUser> getListByRoleId(String roleId);
}
