package com.easyget.service.impl;

import com.easyget.dao.TSysRoleModuleMapper;
import com.easyget.entity.TSysRoleModule;
import com.easyget.service.TSysRoleModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TSysRoleModuleServiceImpl extends BaseServiceImpl<TSysRoleModule> implements TSysRoleModuleService {

    @Resource
    private TSysRoleModuleMapper sysRoleModuleMapper;

    @Override
    public String getModuleIdsByRoleId(String roleId) {
        return sysRoleModuleMapper.getModuleIdsByRoleId(roleId);
    }

    @Override
    public void saveRoleModule(String[] moduleIdArray, String roleId) {
        sysRoleModuleMapper.removeRoleModuleByRoleId(roleId);
        for (int i = 0; i < moduleIdArray.length; i++) {
            TSysRoleModule sysRoleModule = new TSysRoleModule();
            sysRoleModule.setRoleId(roleId);
            sysRoleModule.setModuleId(moduleIdArray[i]);
            sysRoleModule.setCreateTime(new Date());
            sysRoleModuleMapper.insertSelective(sysRoleModule);
        }
    }
}
