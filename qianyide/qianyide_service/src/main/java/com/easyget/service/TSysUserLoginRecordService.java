package com.easyget.service;

import com.easyget.entity.TSysUserLoginRecord;

public interface TSysUserLoginRecordService extends BaseService<TSysUserLoginRecord> {
    void doSave(TSysUserLoginRecord sysUserLoginRecord);
}
