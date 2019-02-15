package com.easyget;

import org.mybatis.generator.api.ShellRunner;

/**
 * Created by dong_jie on 2018-07-21.
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        args = new String[] { "-configfile", "E:\\my-project\\qianyide\\qianyide_common\\src\\test\\resources\\generator-config.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
