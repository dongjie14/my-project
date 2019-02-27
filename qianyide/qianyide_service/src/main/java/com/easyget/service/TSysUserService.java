package com.easyget.service;

import com.easyget.entity.TSysUser;

import java.util.HashMap;
import java.util.Map;

public interface TSysUserService extends BaseSerivce<TSysUser> {

    Map<String, Object> checkLogin(HashMap<String, Object> params);

}
