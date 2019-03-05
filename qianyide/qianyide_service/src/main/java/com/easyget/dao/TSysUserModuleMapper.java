package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysUserModule;

import java.util.List;
import java.util.Map;

public interface TSysUserModuleMapper extends BaseMapper<TSysUserModule> {
    List<TSysUserModule> getModuleByUserId(String userId);

    int deleteByModuleIdsAndUserIds(String delUserIds,String delModuleIds);

    String getModuleIdsByUserId(String userId);
}