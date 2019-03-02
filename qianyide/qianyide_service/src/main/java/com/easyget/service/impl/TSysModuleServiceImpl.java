package com.easyget.service.impl;

import com.easyget.dao.TSysModuleMapper;
import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysRole;
import com.easyget.entity.TSysRoleModule;
import com.easyget.entity.TSysUserModule;
import com.easyget.service.TSysModuleService;
import com.easyget.utils.RandomUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysModuleServiceImpl extends BaseServiceImpl<TSysModule> implements TSysModuleService {

    @Resource
    private TSysModuleMapper sysModuleMapper;

    @Override
    public List<TSysModule> getUserModuleByParams(Map<String, Object> params) {
        return sysModuleMapper.getUserModuleByParams(params);
    }

    @Override
    public TSysModule getModuleByParams(Map<String, Object> params) {
        return sysModuleMapper.getModuleByParams(params);
    }

    @Override
    public List<Map<String, Object>> getModuleTreeList() {
        return sysModuleMapper.getModuleTreeList();
    }

    @Override
    public List<TSysModule> getModulesByParams(Map<String, Object> params) {
        return sysModuleMapper.getModulesByParams(params);
    }

    @Override
    public List<TSysModule> getModuleList() {
        Map<String, Object> params = new HashMap<>();
        params.put("superModuleId", TSysModule.SUPER);
        List<TSysModule> sysModules = sysModuleMapper.getModulesByParams(params);
        addChildren(sysModules);
        return sysModules;
    }

    private void addChildren(List<TSysModule> sysModuleList) {
        Map<String, Object> params = new HashMap<>();
        for (TSysModule sysModule : sysModuleList) {
            params.put("superModuleId", sysModule.getModuleId());
            List<TSysModule> children = this.sysModuleMapper.getModulesByParams(params);
            if (children != null && children.size() != 0) {
                sysModule.setChildren(children);
                addChildren(children);
            }
        }
    }

    @Override
    public String saveModule(TSysModule sysModule) {
        if (sysModule.getModuleId() == null || "".equals(sysModule.getModuleId())){
            sysModule.setModuleId(RandomUtil.getUuid());
            sysModule.setCreateTime(new Date());
            sysModule.setCreateAccount(sysModule.getUpdateAccount());
            sysModuleMapper.insertSelective(sysModule);
        } else {
            sysModuleMapper.updateByModuleId(sysModule);
        }
        return sysModule.getModuleId();
    }

    @Override
    public int updateByModuleId(TSysModule sysModule) {
        return sysModuleMapper.updateByModuleId(sysModule);
    }
}
