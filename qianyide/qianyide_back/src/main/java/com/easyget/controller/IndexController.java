package com.easyget.controller;

import com.easyget.entity.TSysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping
public class IndexController extends BaseController {

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response, Model model) {
        logger.info("IndexController index");
        TSysUser user = loginAdminUser(request);
        model.addAttribute("sysUser", user);
        return "v2/index";
    }

}
