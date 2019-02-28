package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysModule;

import java.util.List;
import java.util.Map;

public interface TSysModuleMapper extends BaseMapper<TSysModule> {

    List<TSysModule> getModuleByParams(Map<String, Object> params);

    List<TSysModule> getModuleList(Map<String, Object> params);

}