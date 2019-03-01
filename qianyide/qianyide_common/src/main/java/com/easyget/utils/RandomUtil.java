package com.easyget.utils;

import java.util.UUID;

public class RandomUtil {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
