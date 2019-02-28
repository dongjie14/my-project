package com.easyget.service.impl;

import com.easyget.constants.ReturnCodeConstants;
import com.easyget.dao.TSysUserMapper;
import com.easyget.entity.TSysUser;
import com.easyget.service.TSysUserService;
import com.easyget.utils.MD5coding;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String, Object> saveBackUser(TSysUser sysUser) {
        return null;
    }

    @Override
    public Map<String, Object> updateUserInfo(TSysUser sysUser) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(sysUser.getOldPassword())) {
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("userId", sysUser.getUserId());
            TSysUser oldBackUser = sysUserMapper.findByAccount(params);
            if (!oldBackUser.getUserPasswd().equals(MD5coding.getInstance().code(sysUser.getOldPassword()))) {
                resultMap.put("errorCode", -1);
                resultMap.put("errorMsg", "旧密码输入错误");
                return resultMap;
            }
            String Md5 = MD5coding.getInstance().code(sysUser.getUserPasswd());//加密
            sysUser.setUserPasswd(Md5);
        } else {
            resultMap.put("errorCode", "0001");
            resultMap.put("errorMsg", "参数错误");
            return resultMap;
        }
        sysUserMapper.updateByUserId(sysUser);
        resultMap.put("errorCode", "0000");
        resultMap.put("errorMsg", "修改成功");
        return resultMap;
    }

    @Override
    public List<TSysUser> getListByRoleId(String roleId) {
        return sysUserMapper.getListByRoleId(roleId);
    }

}
