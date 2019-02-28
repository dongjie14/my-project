package com.easyget.controller;

import com.easyget.entity.TSysModule;
import com.easyget.service.TSysModuleService;
import org.springframework.stereotype.Controller;
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

}
