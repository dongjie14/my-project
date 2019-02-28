package com.easyget.service;

import com.easyget.entity.TSysReturnCode;

import java.util.Map;

public interface TSysReturnCodeService extends BaseService<TSysReturnCode> {

    public Map getReturnMsg(String returnCode);

}
