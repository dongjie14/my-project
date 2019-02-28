package com.easyget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HomeController extends BaseController {

    @RequestMapping(value = "/home")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
//        HomeInfo homeInfo = homeService.getAllCount();
        model.addAttribute("homeInfo", "");
        return "v2/home";
    }

}
