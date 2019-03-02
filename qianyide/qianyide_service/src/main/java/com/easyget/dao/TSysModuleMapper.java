package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysModule;

import java.util.List;
import java.util.Map;

public interface TSysModuleMapper extends BaseMapper<TSysModule> {

    List<TSysModule> getUserModuleByParams(Map<String, Object> params);

    List<TSysModule> getModulesByParams(Map<String, Object> params);

    TSysModule getModuleByParams(Map<String, Object> params);

    List<Map<String, Object>> getModuleTreeList();

    int updateByModuleId(TSysModule sysModule);
}