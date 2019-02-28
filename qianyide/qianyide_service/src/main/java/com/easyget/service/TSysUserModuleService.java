package com.easyget.service;

import com.easyget.entity.TSysUserModule;

import java.util.List;

public interface TSysUserModuleService extends BaseService<TSysUserModule> {
    List<TSysUserModule> getModuleByUserId(String userId);

    String getUserModule(String userId);
}
