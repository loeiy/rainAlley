package com.alley.rain.dto.user;

import com.alley.rain.common.BaseTransitionModel;
import com.alley.rain.po.UserPO;
import com.alley.rain.to.user.UserTO;

/**
 * 后端内部用dto类
 */
public class UserDTO extends BaseTransitionModel {

    private Integer userId;//用户ID
    private String userName;//用户名
    private String password;//密码
    private String phone;//用户手机

    public UserDTO() {

    }

    public UserDTO(UserPO po) {
        this.constructByName(po);
    }

    /**
     * 新增、修改
     *
     * @param to userInfo
     */
    public UserDTO(UserTO to) {
        this.constructByName(to);
    }

    public UserPO genPO() {
        UserPO po = this.generateByName(UserPO.class);
        po.setPassword("80" + this.password);
        return po;
    }

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
