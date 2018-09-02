package com.alley.rain.po;

import java.io.Serializable;

/**
 * 主类
 *
 * @author John
 */
public class User implements Serializable {
    private String name;
    private String pass;

    public User() {

    }

    public User(String name, String pass) {

        this.name = name;//帐号
        this.pass = pass;//密码
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
