package com.easyget.service.impl;

import com.easyget.dao.*;
import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysRole;
import com.easyget.service.TSysRoleModuleService;
import com.easyget.service.TSysRoleService;
import com.easyget.utils.RandomUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TSysRoleServiceImpl extends BaseServiceImpl<TSysRole> implements TSysRoleService {

    @Resource
    private TSysUserMapper sysUserMapper;
    @Resource
    private TSysRoleMapper sysRoleMapper;
    @Resource
    private TSysModuleMapper sysModuleMapper;
    @Resource
    private TSysRoleModuleMapper sysRoleModuleMapper;
    @Resource
    private TSysUserModuleMapper sysUserModuleMapper;
    @Resource
    private TSysRoleModuleService sysRoleModuleService;


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
        List<TSysModule> sysModuleList = sysModuleMapper.getModulesByParams(params);
        String html = appendCheckboxModuleTree(sysModuleList, params).toString();
        return html;
    }

    @Override
    public void doSave(TSysRole sysRole){
        if(sysRole.getRoleId() == null || "".equals(sysRole.getRoleId())){
            sysRole.setRoleId(RandomUtil.getUuid());
            sysRole.setCreateAccount(sysRole.getUpdateAccount());
            sysRole.setCreateTime(new Date());
            sysRoleMapper.insertSelective(sysRole);
        }else{
            sysRoleMapper.updateByRoleId(sysRole);
            //获取该角色被删掉的权限
            String delModuleIds = sysRoleModuleMapper.getDelModuleIdsByRoleId(sysRole);
            if (StringUtils.isNotBlank(delModuleIds)) {
                String delUserIds = sysUserMapper.getUserIdsByRoleId(sysRole.getRoleId());
                if (StringUtils.isNotBlank(delUserIds)) {
                    sysUserModuleMapper.deleteByModuleIdsAndUserIds(delUserIds, delModuleIds);
                }
                //同步到下级角色删除该权限
                String roleChildIds = sysRoleMapper.getRoleChildIds(sysRole.getRoleId());
                if (StringUtils.isNotBlank(roleChildIds)) {
                    if (roleChildIds.indexOf(",") == 0) {
                        roleChildIds = roleChildIds.substring(1);
                    }
                    sysRoleModuleMapper.removeRoleModuleIdsAndRoleId(roleChildIds, delModuleIds);
                }
            }
        }
        if (StringUtils.isNotBlank(sysRole.getRoleModules())) {
            sysRoleModuleService.saveRoleModule(sysRole.getRoleModules().split(","), sysRole.getRoleId());
        }
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
            List<TSysModule> children = this.sysModuleMapper.getModulesByParams(params);
            if (children != null && children.size() != 0) {
                html.append(appendCheckboxModuleTree(children, params));
            } else {
            }
            html.append("</li>");
        }
        html.append("</ul>");
        return html;
    }

    public int updateByRoleId(TSysRole sysRole){
        return sysRoleMapper.updateByRoleId(sysRole);
    }

}
