package com.easyget.controller;

import com.easyget.constants.Constants;
import com.easyget.entity.TSysUser;
import com.easyget.entity.TSysUserLoginRecord;
import com.easyget.entity.TSysUserModule;
import com.easyget.service.TSysUserLoginRecordService;
import com.easyget.service.TSysUserModuleService;
import com.easyget.service.TSysUserService;
import com.easyget.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class SysUserController extends BaseController {

    public static final String PROCESS_URL = "processUrl";
    public static final String RETURN_URL = "returnUrl";
    @Resource
    private TSysUserLoginRecordService sysUserLoginRecordService;
    @Resource
    private TSysUserService sysUserService;
    @Resource
    private TSysUserModuleService sysUserModuleService;

    /**
     * 进入登录页面
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            String processUrl = request.getParameter(PROCESS_URL);
            String returnUrl = request.getParameter(RETURN_URL);
            String message = request.getParameter(MESSAGE);
            TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
            if (sysUser != null) {
                String view = getView(processUrl, returnUrl);
                if (view != null) {
                    return view;
                } else {
                    return "redirect:/index";
                }
            }
            if (!StringUtils.isBlank(processUrl)) {
                model.addAttribute(PROCESS_URL, processUrl);
            }
            if (!StringUtils.isBlank(returnUrl)) {
                model.addAttribute(RETURN_URL, returnUrl);
            }
            if (!StringUtils.isBlank(message)) {
                model.addAttribute(MESSAGE, message);
            }
        } catch (Exception e) {
            logger.error("back login error ", e);
        }
        return "login";
    }


    /**
     * 点击登录按钮提交
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @PostMapping("/loginSubmit")
    public String submit(HttpServletRequest request, HttpServletResponse response, Model model) {
        HashMap<String, Object> params = this.getParametersO(request);
        String errMsg = null;
        TSysUser sysUser = null;
        try {
            if (validateSubmit(request, response)) {
                Map<String, Object> checkRsMap = sysUserService.checkLogin(params);
                errMsg = null == checkRsMap.get(Constants.RETURN_INFO) ? "" : (String) checkRsMap.get(Constants.RETURN_INFO);
                sysUser = null == checkRsMap.get("sysUser") ? null : (TSysUser) checkRsMap.get("sysUser");
            } else {
                errMsg = "验证码错误";
            }
        } catch (Exception e) {
            errMsg = "服务器异常，稍后重试！";
        }
        if (StringUtils.isNotBlank(errMsg)) {
            model.addAttribute(MESSAGE, errMsg);
            return "login";
        } else {
            //记录登陆日志
            TSysUserLoginRecord sysUserLoginRecord = new TSysUserLoginRecord();
            sysUserLoginRecord.setLoginIp(this.getIpAddr(request));
            sysUserLoginRecord.setUserId(sysUser.getUserId());
            sysUserLoginRecordService.doSave(sysUserLoginRecord);
            request.getSession(true).setAttribute(Constants.QIANYIDE_SYS_USER, sysUser);
            return "redirect:/index";
        }
    }

    /**
     * 退出
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        request.getSession().removeAttribute(Constants.QIANYIDE_SYS_USER);
        return "redirect:login";
    }

    @RequestMapping(value = "/gotoLogin")
    public String gotoLogin(HttpServletRequest request,
                            HttpServletResponse response, Model model) {
        if (loginFrontUser(request) != null) {
            return "redirect:/zb/index";
        } else {
            String returnUrl = request.getParameter("returnUrl");
            if (StringUtils.isBlank(returnUrl)) {
                returnUrl = request.getContextPath() + "/userManage/index";
            }
            model.addAttribute("returnUrl", returnUrl);
            return "login";
        }
    }

    @RequestMapping(value = "/backUserAdd", method = RequestMethod.GET)
    public String backUserAdd(HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
            if (null == sysUser) {
                gotoLogin(request, response, model);
            }
        } catch (Exception e) {
            logger.error("back login error ", e);
        }
        return "sys/back-user-add";
    }

    @RequestMapping("/saveBackUser")
    public void saveBackUser(HttpServletRequest request, HttpServletResponse response, TSysUser sysUser) {
        Map result = sysUserService.saveBackUser(sysUser);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 200);
        jsonObject.put("msg", result.get(Constants.RETURN_INFO));
        JsonUtils.toObjectJson(response, jsonObject);
    }

    /**
     * 修改个人信息
     *
     * @param request
     * @param sysUser
     * @return
     */
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public Map<String, Object> updateUserInfo(HttpServletRequest request, TSysUser sysUser) {
        Map<String, Object> resultMap = sysUserService.updateUserInfo(sysUser);
        TSysUser sessionBackUser = loginAdminUser(request);
        if (sessionBackUser != null) {
            request.getSession(true).setAttribute(Constants.QIANYIDE_SYS_USER, sessionBackUser);
        }
        return resultMap;
    }

    /**
     * 获得地址
     *
     * @param processUrl
     * @param returnUrl
     * @return
     */
    private String getView(String processUrl, String returnUrl) {
        if (!StringUtils.isBlank(processUrl)) {
            StringBuilder sb = new StringBuilder("redirect:");
            sb.append(processUrl);
            if (!StringUtils.isBlank(returnUrl)) {
                sb.append("?").append(RETURN_URL).append("=").append(returnUrl);
            }
            return sb.toString();
        } else if (!StringUtils.isBlank(returnUrl)) {
            StringBuilder sb = new StringBuilder("redirect:");
            sb.append(returnUrl);

            return sb.toString();
        } else {
            return null;
        }
    }
}
