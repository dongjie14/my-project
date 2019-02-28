package com.easyget.service.impl;

import com.easyget.dao.TSysUserLoginRecordMapper;
import com.easyget.dao.TSysUserMapper;
import com.easyget.entity.TSysUser;
import com.easyget.entity.TSysUserLoginRecord;
import com.easyget.service.TSysUserLoginRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TSysUserLoginRecordServiceImpl extends BaseServiceImpl<TSysUserLoginRecord> implements TSysUserLoginRecordService {

    @Resource
    private TSysUserMapper sysUserMapper;
    @Resource
    private TSysUserLoginRecordMapper sysUserLoginRecordMapper;

    @Override
    public void doSave(TSysUserLoginRecord sysUserLoginRecord) {
        sysUserLoginRecordMapper.insert(sysUserLoginRecord);
        TSysUser sysUser = new TSysUser();
        sysUser.setUserId(sysUserLoginRecord.getUserId());
        sysUser.setLoginTime(new Date());
        sysUserMapper.updateByUserId(sysUser);
    }

}
