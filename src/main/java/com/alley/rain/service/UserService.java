package com.alley.rain.service;

import com.alley.rain.common.QueryResult;
import com.alley.rain.common.Result;
import com.alley.rain.common.SingleResult;
import com.alley.rain.po.UserPO;

/**
 * 用户接口
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param userInfo 用户信息
     * @return res
     */
    Result insert(UserPO userInfo);

    /**
     * update user info
     *
     * @param userId   id
     * @param userName name
     * @param password pwd
     * @param phone    phone
     * @return res
     */
    Result updateUser(int userId, String userName, String password, String phone);

    /**
     * delete user
     *
     * @param userId id
     * @return res
     */
    Result deleteUser(int userId);

    /**
     * query user
     *
     * @param userId id
     * @return res
     */
    SingleResult<UserPO> getUserById(int userId);

    /**
     * query userList
     *
     * @return res
     */
    QueryResult<UserPO> getUserList();
}
