package com.easyget.dao;

import com.easyget.configuration.BaseMapper;
import com.easyget.entity.TSysReturnCode;

public interface TSysReturnCodeMapper extends BaseMapper<TSysReturnCode> {

    TSysReturnCode getByCode(String returnCode);

}