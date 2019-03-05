package com.easyget.service;

import com.easyget.entity.TSysUserLoginRecord;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface TSysUserLoginRecordService extends BaseService<TSysUserLoginRecord> {
    void doSave(TSysUserLoginRecord sysUserLoginRecord);

    PageInfo<TSysUserLoginRecord> getPageList(Map<String, Object> params);
}
