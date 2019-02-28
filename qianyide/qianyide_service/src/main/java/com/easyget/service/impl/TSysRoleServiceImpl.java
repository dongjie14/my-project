package com.easyget.service.impl;

import com.easyget.dao.TSysModuleMapper;
import com.easyget.dao.TSysRoleMapper;
import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysRole;
import com.easyget.service.TSysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSysRoleServiceImpl extends BaseServiceImpl<TSysRole> implements TSysRoleService {

    @Resource
    private TSysRoleMapper sysRoleMapper;
    @Resource
    private TSysModuleMapper sysModuleMapper;

    @Override
    public List<TSysRole> getRoleList() {
        Map<String, Object> params = new HashMap<>();
        params.put("superRoleId", TSysRole.SUPER);
        List<TSysRole> sysRoles = sysRoleMapper.getRoleByParams(params);
        addChildren(sysRoles);
        return sysRoles;
    }

    private void addChildren(List<TSysRole> sysRoleList) {
        for (TSysRole sysRole : sysRoleList) {
            Map<String, Object> params = new HashMap<>();
            params.put("superRoleId", sysRole.getRoleId());
            List<TSysRole> children = sysRoleMapper.getRoleByParams(params);
            if (children != null && children.size() != 0) {
                sysRole.setChildren(children);
                addChildren(children);
            }
        }
    }

    @Override
    public TSysRole selectByRoleId(String roleId) {
        return sysRoleMapper.selectByRoleId(roleId);
    }

    @Override
    public List<Map<String, Object>> getRoleTreeList(String roleIds) {
        String newRoleIds = "";
        String[] roleIdList = roleIds.split(",");
        for (String roleId : roleIdList) {
            newRoleIds += sysRoleMapper.getRoleChildIds(roleId);
        }
        if (newRoleIds.indexOf(",") == 0) {
            newRoleIds = newRoleIds.substring(1);
        }
        Map<String, Object> params = new HashMap<>();
        params.put("roleIds", "(" + newRoleIds + ")");
        return sysRoleMapper.getRoleTreeList(params);
    }

    @Override
    public String getCheckboxModuleTree(Map params) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("enable", TSysModule.ENABLE_STATUS_USABLE );
        params.put("superModuleId", TSysModule.SUPER);
        List<TSysModule> sysModuleList = sysModuleMapper.getModuleByParams(params);
        String html = appendCheckboxModuleTree(sysModuleList, params).toString();
        return html;
    }

    @Override
    public int doSave(TSysRole sysRole){
        if(sysRole.getRoleId() == null){
            sysRole.setCreateAccount(sysRole.getUpdateAccount());
            sysRole.setCreateTime(new Date());
            sysRole.setEnable(1);
        }else{

        }
        return 0;
    }

    private StringBuffer appendCheckboxModuleTree(List<TSysModule> sysModuleList, Map params){
        StringBuffer html = new StringBuffer();
        html.append("<ul>");
        for (TSysModule sysModule : sysModuleList){
            html.append("<li>");
            html.append("<span><input type=\"checkbox\" pid=\"" + sysModule.getSuperModuleId() +
                    "\" menus=\"" + sysModule.getModuleType() + "\"  class=\"chp_" + sysModule.getModuleId() +
                    " chn_" + sysModule.getSuperModuleId() + "\" style=\"margin-top:-1px\" value='" +
                    sysModule.getModuleId() + "'/> <c>" + sysModule.getModuleName() + "</c></span> ");
            params.put("superModuleId", sysModule.getModuleId());
            List<TSysModule> children = this.sysModuleMapper.getModuleByParams(params);
            if (children != null && children.size() != 0) {
                html.append(appendCheckboxModuleTree(children, params));
            } else {
            }
            html.append("</li>");
        }
        html.append("</ul>");
        return html;
    }

}
