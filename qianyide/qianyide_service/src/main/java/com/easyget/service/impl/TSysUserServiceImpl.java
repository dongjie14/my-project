package com.easyget.service.impl;

import com.easyget.constants.ReturnCodeConstants;
import com.easyget.dao.TSysUserMapper;
import com.easyget.entity.TSysUser;
import com.easyget.service.TSysUserService;
import com.easyget.utils.MD5coding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class TSysUserServiceImpl extends BaseServiceImpl<TSysUser> implements TSysUserService {

    private static Logger logger = LoggerFactory.getLogger(TSysUserServiceImpl.class);

    @Resource
    private TSysUserMapper sysUserMapper;

    @Override
    public Map<String, Object> checkLogin(HashMap<String, Object> params) {

        logger.info("BackLoginService check start ,param:" + params);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        TSysUser sysUser = sysUserMapper.findByAccount(params);
        if (null == sysUser) {
            return sysReturnCodeService.getReturnMsg(ReturnCodeConstants.USER_NOT_FIND);
        } else if (1 != sysUser.getUserSts()){
            return sysReturnCodeService.getReturnMsg(ReturnCodeConstants.USER_NOT_FIND);
        }

        if (!sysUser.getUserPasswd().equals(MD5coding.getInstance().code(String.valueOf(params.get("userPassword"))))) {
            return sysReturnCodeService.getReturnMsg(ReturnCodeConstants.PASSWORD_ERR);
        }
        resultMap.put("sysUser", sysUser);
        return resultMap;
    }
}
