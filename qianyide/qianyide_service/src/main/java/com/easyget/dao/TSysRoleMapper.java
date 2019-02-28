package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysRole;

import java.util.List;
import java.util.Map;

public interface TSysRoleMapper extends BaseMapper<TSysRole> {

    List<TSysRole> getRoleByParams(Map<String, Object> params);

    TSysRole selectByRoleId(String roleId);

    String getRoleChildIds(String roleId);

    List<Map<String, Object>> getRoleTreeList(Map params);
}