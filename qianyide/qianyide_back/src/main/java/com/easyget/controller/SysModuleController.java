package com.easyget.controller;

import com.easyget.entity.TSysModule;
import com.easyget.entity.TSysRole;
import com.easyget.entity.TSysUser;
import com.easyget.enums.Status;
import com.easyget.service.TSysModuleService;
import com.easyget.utils.JsonUtils;
import net.sf.json.JSONObject;
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
@RequestMapping("sysModule")
public class SysModuleController extends BaseController {

    @Resource
    private TSysModuleService sysModuleService;

    @RequestMapping("/moduleList")
    public String moduleList(HttpServletRequest request) {
        return "v2/sysModule/sysModuleList";
    }

    @RequestMapping("/getModuleData")
    @ResponseBody
    public Map<String, Object> getModuleData(HttpServletRequest request, HttpServletResponse response) {
        List<TSysModule> sysModuleList = sysModuleService.getModuleList();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", sysModuleList);
        return resultMap;
    }

    @RequestMapping("/to-save")
    public String toSave(HttpServletRequest request, HttpServletResponse response, Model model) {
        Map<String, Object> params = new HashMap<>();
        String moduleId = request.getParameter("moduleId");
        params.put("moduleId", moduleId);
        TSysModule sysModule;
        if(moduleId == null || "".equals(moduleId)){
            sysModule = new TSysModule();
        }else{
            sysModule = sysModuleService.getModuleByParams(params);
            if (sysModule == null) {
                sysModule = new TSysModule();
            }
        }
        List<Map<String, Object>> sysModuleList = sysModuleService.getModuleTreeList();
        model.addAttribute("sysModuleList", sysModuleList);
        model.addAttribute("sysModule", sysModule);
        return "v2/sysModule/sysModuleSave";
    }

    @RequestMapping("/save")
    public void saveModule(HttpServletRequest request, HttpServletResponse response, TSysModule sysModule) {
        TSysUser sysUser = loginAdminUser(request);
        sysModule.setUpdateAccount(sysUser.getUserAccount());
        sysModuleService.saveModule(sysModule);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", "保存成功");
        jsonObject.put("moduleId", sysModule.getModuleId());
        JsonUtils.toObjectJson(response, jsonObject);
    }

    /**
     * 去预览系统用户页面
     *
     * @return
     */
    @GetMapping("to-Preview")
    public String toPreview(HttpServletRequest request, HttpServletResponse response, Model model) {
        String moduleId = request.getParameter("moduleId");
        Map<String, Object> params = new HashMap();
        params.put("moduleId", moduleId);
        TSysModule sysModule = sysModuleService.getModuleByParams(params);
        List<Map<String, Object>> sysModuleList = sysModuleService.getModuleTreeList();
        model.addAttribute("sysModuleList", sysModuleList);
        model.addAttribute("sysModule", sysModule);
        return "v2/sysModule/sysModulePreview";
    }

    /**
     * 删除
     *
     * @return
     */
    @PostMapping("del")
    @ResponseBody
    public Map del(HttpServletRequest request, String moduleId) {
        Map<String, String> rspMap = new HashMap<>();
        rspMap.put("code", Status.FAIL.getName());
        rspMap.put("message", Status.FAIL.getValue());
        TSysUser sysUser = loginAdminUser(request);
        TSysModule sysModule = new TSysModule();
        sysModule.setModuleId(moduleId);
        sysModule.setEnable(0);
        sysModule.setUpdateAccount(sysUser.getUserAccount());
        int result = sysModuleService.updateByModuleId(sysModule);
        rspMap.put("code", Status.SUCCESS.getName());
        if (result > 0) {
            rspMap.put("message", "删除成功!");
        } else {
            rspMap.put("message", "删除失败!");
        }
        return rspMap;
    }
}
