package com.alley.rain.to.user;

import java.io.Serializable;

/**
 * 前端用TO类
 */
public class UserTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userId;//用户ID
    private String userName;//用户名
    private String password;//密码
    private String phone;//用户手机

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
