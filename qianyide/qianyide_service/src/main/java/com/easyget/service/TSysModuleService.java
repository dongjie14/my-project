package com.easyget.service;

import com.easyget.entity.TSysModule;

import java.util.List;
import java.util.Map;

public interface TSysModuleService extends BaseService<TSysModule> {

    List<TSysModule> getUserModuleByParams(Map<String, Object> params);

    List<TSysModule> getModulesByParams(Map<String, Object> params);

    TSysModule getModuleByParams(Map<String, Object> params);

    List<TSysModule> getModuleList();

    List<Map<String, Object>> getModuleTreeList();

    String saveModule(TSysModule sysModule);

    int updateByModuleId(TSysModule sysModule);
}
