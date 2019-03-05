package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysUserLoginRecord;

import java.util.List;
import java.util.Map;

public interface TSysUserLoginRecordMapper extends BaseMapper<TSysUserLoginRecord> {
    List<TSysUserLoginRecord> getPageList(Map<String, Object> params);
}