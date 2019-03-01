package com.easyget.service;

import com.easyget.entity.TSysRole;

import java.util.List;
import java.util.Map;

public interface TSysRoleService extends BaseService<TSysRole> {

    List<TSysRole> getRoleList();

    TSysRole selectByRoleId(String roleId);

    List<Map<String, Object>> getRoleTreeList(String superRoleId);

    String getCheckboxModuleTree(Map params);

    void doSave(TSysRole sysRole);

    int updateByRoleId(TSysRole sysRole);
}
