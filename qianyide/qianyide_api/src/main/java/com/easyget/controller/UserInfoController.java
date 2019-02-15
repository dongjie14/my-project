package com.easyget.controller;

import com.easyget.entity.TUserInfo;
import com.easyget.enums.ApiErrorCodeEnum;
import com.easyget.service.TUserInfoService;
import com.easyget.view.result.ResponseData;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends BaseController {

    @Autowired
    private TUserInfoService userInfoService;

    @ApiOperation(value = "用户查询", httpMethod = "GET", protocols = "HTTP 1.0/2.0")
    @ApiImplicitParams(value = {})
    @GetMapping("/selectAll")
    public ResponseData selectAll(HttpServletRequest request, HttpServletResponse response){
        List<TUserInfo> userInfo = userInfoService.selectAll();
        return new ResponseData(ApiErrorCodeEnum.SUCCESS, userInfo);
    }

}
