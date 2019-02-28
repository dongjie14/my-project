package com.easyget.service;

import com.easyget.entity.TSysModule;

import java.util.List;
import java.util.Map;

public interface TSysModuleService extends BaseService<TSysModule> {
    List<TSysModule> getModuleByParams(Map<String, Object> params);
    List<TSysModule> getModuleList();
}
