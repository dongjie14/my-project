package com.easyget.service.impl;

import com.easyget.dao.TSysModuleMapper;
import com.easyget.entity.TSysModule;
import com.easyget.service.TSysModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysModuleServiceImpl extends BaseServiceImpl<TSysModule> implements TSysModuleService {

    @Resource
    private TSysModuleMapper sysModuleMapper;

    @Override
    public List<TSysModule> getModuleByParams(Map<String, Object> params) {
        return sysModuleMapper.getModuleByParams(params);
    }

    @Override
    public List<TSysModule> getModuleList() {
        Map<String, Object> params = new HashMap<>();
        params.put("superModuleId", TSysModule.SUPER);
        List<TSysModule> sysModules = sysModuleMapper.getModuleList(params);
        addChildren(sysModules);
        return sysModules;
    }

    private void addChildren(List<TSysModule> sysModuleList) {
        Map<String, Object> params = new HashMap<>();
        for (TSysModule sysModule : sysModuleList) {
            params.put("superModuleId", sysModule.getModuleId());
            List<TSysModule> children = this.sysModuleMapper.getModuleList(params);
            if (children != null && children.size() != 0) {
                sysModule.setChildren(children);
                addChildren(children);
            }
        }
    }

}
