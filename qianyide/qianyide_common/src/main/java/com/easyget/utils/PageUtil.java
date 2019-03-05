package com.easyget.utils;

import com.easyget.constants.Constants;
import com.github.pagehelper.PageHelper;

import java.util.Map;

public class PageUtil {

    public static void startPage(Map params){
        int currentPage = Constants.INITIAL_CURRENT_PAGE;
        int pageSize = Constants.INITIAL_PAGE_SIZE;
        if (params.get(Constants.CURRENT_PAGE) != null && !"".equals(params.get(Constants.CURRENT_PAGE))) {
            currentPage = getInteger(params.get(Constants.CURRENT_PAGE) + "");
        }
        if (params.get(Constants.PAGE_SIZE) != null && !"".equals(params.get(Constants.PAGE_SIZE))) {
            pageSize = getInteger(params.get(Constants.PAGE_SIZE) + "");
        }
        PageHelper.startPage(currentPage, pageSize);
    }

    private static Integer getInteger(Object obj) {
        Integer o = 0;
        if (obj != null && !"".equals(obj)) {
            try {
                o = Integer.parseInt(obj.toString());
            } catch (Exception e) {
            }
        }
        return o;
    }
}
