package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysRole;
import com.easyget.entity.TSysRoleModule;

public interface TSysRoleModuleMapper extends BaseMapper<TSysRoleModule> {

    String getModuleIdsByRoleId(String roleId);

    String getDelModuleIdsByRoleId(TSysRole sysRole);

    int removeRoleModuleIdsAndRoleId(String roleChildIds,String delModuleIds);

    int removeRoleModuleByRoleId(String roleId);
}