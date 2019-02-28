package com.easyget.controller;

import com.easyget.constants.Constants;
import com.easyget.entity.TSysUser;
import com.easyget.service.TSysUserModuleService;
import com.easyget.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("userModule")
public class SysUserModuleController extends BaseController {

    @Resource
    private TSysUserModuleService sysUserModuleService;

    @RequestMapping("getModule")
    public void getModule(HttpServletRequest request, HttpServletResponse response){
        TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
        String userId = sysUser.getUserId();
        String html = sysUserModuleService.getUserModule(userId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", html);
        JsonUtils.toObjectJson(response, jsonObject);
    }
}
