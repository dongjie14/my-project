package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysUser;

import java.util.Map;

public interface TSysUserMapper extends BaseMapper<TSysUser> {

    TSysUser findByAccount(Map<String, Object> params);

}