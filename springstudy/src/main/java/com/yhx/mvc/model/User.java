package com.yhx.mvc.model;

/**
 * Created by Administrator on 2017-05-18.
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    public User() {}
    public User(String name,String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
