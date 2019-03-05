package com.easyget.service.impl;

import com.easyget.dao.TSysUserLoginRecordMapper;
import com.easyget.dao.TSysUserMapper;
import com.easyget.entity.TSysUser;
import com.easyget.entity.TSysUserLoginRecord;
import com.easyget.service.TSysUserLoginRecordService;
import com.easyget.utils.PageUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public PageInfo<TSysUserLoginRecord> getPageList(Map<String, Object> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        PageUtil.startPage(params);
        PageInfo<TSysUserLoginRecord> pageInfo = new PageInfo<>(sysUserLoginRecordMapper.getPageList(params));
        return pageInfo;
    }
}
