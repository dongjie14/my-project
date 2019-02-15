package com.easyget.entity;

import javax.persistence.Id;
import java.sql.Timestamp;

public class TUserInfo {

    @Id
    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String addr;

    private Timestamp tmSmp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Timestamp getTmSmp() {
        return tmSmp;
    }

    public void setTmSmp(Timestamp tmSmp) {
        this.tmSmp = tmSmp;
    }
}
