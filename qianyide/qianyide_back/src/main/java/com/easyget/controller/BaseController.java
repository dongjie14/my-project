package com.easyget.controller;

import com.easyget.constants.Constants;
import com.easyget.entity.TSysUser;
import com.easyget.entity.TUserInfo;
import com.easyget.utils.IpUtil;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseController {
    public static Logger logger = LoggerFactory.getLogger(BaseController.class);
    public static final String MESSAGE = "message";

    @Resource
    private ImageCaptchaService captchaService;

    /**
     * 得到 session
     * @param request
     * @return
     */
    protected HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    /**
     * 得到session中的admin user对象
     * @param request
     * @return
     */
    public TSysUser loginUser(HttpServletRequest request) {
        if (request == null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
        TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
        return sysUser;
    }

    /**
     * 得到session中的admin user对象
     */
    public TSysUser loginAdminUser(HttpServletRequest request) {
        if (request == null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
        TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
        return sysUser;
    }

    /**
     * 得到session中的borrowUser对象
     * @param request
     * @return
     */
    public TUserInfo loginFrontUser(HttpServletRequest request) {
        if (request == null) {
            request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
        }
        TUserInfo userInfo = (TUserInfo) request.getSession().getAttribute(Constants.QIANYIDE_FRONT_USER);
        return userInfo;
    }

    /**
     * 验证码
     * @param request
     * @param response
     * @return
     */
    public boolean validateSubmit(HttpServletRequest request, HttpServletResponse response) {
        try {
            return captchaService.validateResponseForID(request.getSession(false).getId(), request.getParameter("captcha").toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获得request中的参数
     * @param request
     * @return string object类型的map
     */
    public HashMap<String, Object> getParametersO(HttpServletRequest request) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (request == null) {
            request = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getRequest();
        }
        Map req = request.getParameterMap();
        if ((req != null) && (!req.isEmpty())) {
            Map<String, Object> p = new HashMap<String, Object>();
            Collection keys = req.keySet();
            for (Iterator i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                Object value = req.get(key);
                Object v = null;
                if ((value.getClass().isArray())
                        && (((Object[]) value).length > 0)) {
                    if (((Object[]) value).length > 1) {
                        v = ((Object[]) value);
                    } else {
                        v = ((Object[]) value)[0];
                    }
                } else {
                    v = value;
                }
                if ((v != null) && ((v instanceof String)) && !"\"\"".equals(v)) {
                    String s = ((String) v).trim();
                    if (s.length() > 0) {
                        p.put(key, s);
                    }
                }
            }
            hashMap.putAll(p);
        }
        return hashMap;
    }

    /**
     * 获得request中的参数
     * @param request
     * @return string string类型的map
     */
    public Map<String, String> getParameters(HttpServletRequest request) {
        if (request == null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
        Map<String, String> p = new HashMap<String, String>();
        Map req = request.getParameterMap();
        if ((req != null) && (!req.isEmpty())) {

            Collection keys = req.keySet();
            for (Iterator i = keys.iterator(); i.hasNext(); ) {
                String key = (String) i.next();
                Object value = req.get(key);
                Object v = null;
                if ((value.getClass().isArray())
                        && (((Object[]) value).length > 0)) {
                    v = ((Object[]) value)[0];
                } else {
                    v = value;
                }
                if ((v != null) && ((v instanceof String)) && !"\"\"".equals(v)) {
                    String s = (String) v;
                    if (s.length() > 0) {
                        p.put(key, s);
                    }
                }
            }
            return p;
        }
        return p;
    }

    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        return IpUtil.getRemortIP(request);
    }

}
