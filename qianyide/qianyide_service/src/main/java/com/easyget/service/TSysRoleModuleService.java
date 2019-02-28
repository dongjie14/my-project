package com.easyget.service;

import com.easyget.entity.TSysRoleModule;

public interface TSysRoleModuleService extends BaseService<TSysRoleModule> {
    String getModuleIdsByRoleId(String roleId);
}
