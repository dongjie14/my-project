package com.easyget.service.impl;

import com.easyget.constants.Constants;
import com.easyget.dao.TSysReturnCodeMapper;
import com.easyget.entity.TSysReturnCode;
import com.easyget.service.TSysReturnCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class TSysReturnCodeServiceImpl extends BaseServiceImpl<TSysReturnCode> implements TSysReturnCodeService {

    private static Logger logger = LoggerFactory.getLogger(TSysReturnCodeServiceImpl.class);

    @Resource
    private TSysReturnCodeMapper sysReturnCodeMapper;

    /**
     * 获取返回消息
     * @param returnCode
     * @return
     */
    @Override
    public Map getReturnMsg(String returnCode) {
        TSysReturnCode sysReturnCode = sysReturnCodeMapper.getByCode(returnCode);
        Map returnMap = new HashMap<>();
        if(sysReturnCode == null){
            returnMap.put(Constants.RETURN_CODE, TSysReturnCode.defaultType.ERROR.getReturnCode());
            returnMap.put(Constants.RETURN_INFO, TSysReturnCode.defaultType.ERROR.getReturnInfo());
            returnMap.put(Constants.RETURN_TYPE, TSysReturnCode.defaultType.ERROR.getReturnType());
        }else {
            returnMap.put(Constants.RETURN_CODE, sysReturnCode.getReturnCode());
            returnMap.put(Constants.RETURN_INFO, sysReturnCode.getReturnInfo());
            returnMap.put(Constants.RETURN_TYPE, sysReturnCode.getReturnType().toString());
        }
        return returnMap;
    }
}
