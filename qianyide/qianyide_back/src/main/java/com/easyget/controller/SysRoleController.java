package com.easyget.controller;

import com.easyget.entity.TSysRole;
import com.easyget.entity.TSysUser;
import com.easyget.enums.Status;
import com.easyget.service.TSysRoleModuleService;
import com.easyget.service.TSysRoleService;
import com.easyget.service.TSysUserService;
import com.easyget.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sysRole")
public class SysRoleController extends BaseController {

    @Resource
    private TSysRoleService sysRoleService;
    @Resource
    private TSysRoleModuleService sysRoleModuleService;
    @Resource
    private TSysUserService sysUserService;

    @RequestMapping("/roleList")
    public String moduleList(HttpServletRequest request) {
        return "v2/sysRole/sysRoleList";
    }

    @RequestMapping("/getRoleData")
    @ResponseBody
    public Map<String, Object> getRoleData(HttpServletRequest request, HttpServletResponse response) {
        List<TSysRole> sysRoleList = sysRoleService.getRoleList();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", sysRoleList);
        return resultMap;
    }

    /**
     * 去预览系统用户页面
     *
     * @return
     */
    @GetMapping("to-Preview")
    public String toPreview(HttpServletRequest request, HttpServletResponse response, Model model) {
        String roleId = request.getParameter("roleId");
        TSysRole sysRole = sysRoleService.selectByRoleId(roleId) ;
        String roleModules = sysRoleModuleService.getModuleIdsByRoleId(roleId);
        sysRole.setRoleModules(roleModules);
        List<TSysUser> backUserList = sysUserService.getListByRoleId(roleId);
        model.addAttribute("backUserList", backUserList);
        List<Map<String, Object>> roleList = sysRoleService.getRoleTreeList(TSysRole.SUPER);//所有角色
        model.addAttribute("roleList", roleList);
        model.addAttribute("sysRole", sysRole);
        return "v2/sysRole/sysRolePreview";
    }

    @RequestMapping("/getModule")
    public void getModule(HttpServletRequest request, HttpServletResponse response, String roleId) {
        Map map = null;
        if (StringUtils.isNotBlank(roleId) && !roleId.equals(TSysRole.SUPER)) {
            map = new HashMap();
            map.put("roleId", roleId);
        }
        String html = this.sysRoleService.getCheckboxModuleTree(map);
        request.setAttribute("checkboxModuleTree", html);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", html);
        JsonUtils.toObjectJson(response, jsonObject);
    }

    @RequestMapping("/to-save")
    public String toSave(HttpServletRequest request, HttpServletResponse response, Model model) {
        String roleId = request.getParameter("roleId");
        TSysRole sysRole = sysRoleService.selectByRoleId(roleId);
        if (sysRole == null) {
            sysRole = new TSysRole();
        } else {
            String roleModules = sysRoleModuleService.getModuleIdsByRoleId(roleId);
            sysRole.setRoleModules(roleModules);
            List<TSysUser> backUserList = sysUserService.getListByRoleId(roleId);
            model.addAttribute("backUserList", backUserList);
        }
        List<Map<String, Object>> roleList = sysRoleService.getRoleTreeList(TSysRole.SUPER);
        model.addAttribute("roleList", roleList);
        model.addAttribute("sysRole", sysRole);
        return "v2/sysRole/sysRoleSave";
    }

    @RequestMapping("/save")
    public void saveRole(HttpServletRequest request, HttpServletResponse response, TSysRole sysRole) {
        TSysUser user = loginAdminUser(request);
        sysRole.setUpdateAccount(user.getUserAccount());
        if(sysRole.getSuperRoleId() == null || "".equals(sysRole.getSuperRoleId())){
            sysRole.setSuperRoleId(TSysRole.SUPER);
        }
        sysRoleService.doSave(sysRole);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "保存成功");
        jsonObject.put("roleId", sysRole.getRoleId());
        JsonUtils.toObjectJson(response, jsonObject);
    }

    /**
     * 删除
     *
     * @return
     */
    @PostMapping("del")
    @ResponseBody
    public Map del(HttpServletRequest request, String roleId) {
        Map<String, String> rspMap = new HashMap<>();
        rspMap.put("code", Status.FAIL.getName());
        rspMap.put("message", Status.FAIL.getValue());
        TSysUser sysUser = loginAdminUser(request);
        TSysRole sysRole = new TSysRole();
        sysRole.setRoleId(roleId);
        sysRole.setEnable(0);
        sysRole.setUpdateAccount(sysUser.getUserAccount());
        int result = sysRoleService.updateByRoleId(sysRole);
        rspMap.put("code", Status.SUCCESS.getName());
        if (result > 0) {
            rspMap.put("message", "删除成功!");
        } else {
            rspMap.put("message", "删除失败!");
        }
        return rspMap;
    }
}
