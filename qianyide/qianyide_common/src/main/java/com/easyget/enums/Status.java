package com.easyget.enums;

/**
 * 定义返回状态
 */
public enum Status {

    /**
     * 成功
     */
    SUCCESS("200", "操作成功"),
    /**
     * 失败
     */
    FAIL("-1", "操作失败"),
    /**
     * 系统错误
     */
    ERROR("500", "系统繁忙,请稍后再试");
    /**
     * 名称
     */
    private final String name;

    /**
     * 值
     */
    private final String value;

    Status(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 获取名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取值
     *
     * @return
     */
    public String getValue() {
        return value;
    }
}
