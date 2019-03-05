package com.easyget.service.impl;

import com.easyget.dao.TSysModuleMapper;
import com.easyget.dao.TSysUserModuleMapper;
import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysUserModule;
import com.easyget.service.TSysUserModuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysUserModuleServiceImpl extends BaseServiceImpl<TSysUserModule> implements TSysUserModuleService {

    @Resource
    private TSysUserModuleMapper sysUserModuleMapper;
    @Resource
    private TSysModuleMapper sysModuleMapper;

    @Override
    public List<TSysUserModule> getModuleByUserId(String userId) {
        return sysUserModuleMapper.getModuleByUserId(userId);
    }

    @Override
    public String getUserModule(String userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("moduleType", TSysModule.MODULE_TYPE_MENU);
        params.put("enable", TSysModule.ENABLE_STATUS_USABLE);
        params.put("superModuleId", TSysModule.SUPER);
        List<TSysModule> sysModuleList = sysModuleMapper.getUserModuleByParams(params);
        String html = appendChildren(sysModuleList, params).toString();
        return html;
    }

    private StringBuffer appendChildren(List<TSysModule> sysModuleList, Map<String, Object> params) {
        StringBuffer html = new StringBuffer();
        for (TSysModule sysModule : sysModuleList) {
            params.put("superModuleId", sysModule.getModuleId());
            List<TSysModule> children = sysModuleMapper.getModulesByParams(params);
            if (children != null && children.size() != 0) {
                html.append("<li class=\"xn-openable\">");
                html.append(" <a href=\"#\"><span class=\"fa " + "" + "\"></span> <span class=\"xn-text\">" + sysModule.getModuleName() + "</span></a>");
                html.append("<ul>");
                html.append(appendChildren(children, params).toString());
                html.append("</ul>");
                html.append("</li>");
            } else {
                html.append("<li>");
                html.append("<a href=\"" + sysModule.getModuleUrl() + "\" target='external-frame'\n\" ><span class=\"fa " + "" + "\"></span> " + sysModule.getModuleName() + "</a>");
                html.append("</li>");
            }
        }
        return html;
    }

    @Override
    public String getModuleIdsByUserId(String userId) {
        return sysUserModuleMapper.getModuleIdsByUserId(userId);
    }
}
