package com.easyget.service.impl;

import com.easyget.dao.TSysRoleModuleMapper;
import com.easyget.entity.TSysRoleModule;
import com.easyget.service.TSysRoleModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TSysRoleModuleServiceImpl extends BaseServiceImpl<TSysRoleModule> implements TSysRoleModuleService {

    @Resource
    private TSysRoleModuleMapper sysRoleModuleMapper;

    @Override
    public String getModuleIdsByRoleId(String roleId) {
        return sysRoleModuleMapper.getModuleIdsByRoleId(roleId);
    }
}
