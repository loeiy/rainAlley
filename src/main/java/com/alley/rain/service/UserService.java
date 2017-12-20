package com.alley.rain.service;

import com.alley.rain.common.QueryResult;
import com.alley.rain.common.Result;
import com.alley.rain.common.SingleResult;
import com.alley.rain.to.user.UserTO;

import java.util.Map;

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
    Result insert(UserTO userInfo);

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
    SingleResult<UserTO> getUserById(int userId);

    /**
     * query userList
     *
     * @return res
     */
    QueryResult<UserTO> getUserList();

    /**
     * test return single Map:key-userName,value-phone
     *
     * @param userId userid
     * @return res
     */
    SingleResult<Map<String, String>> getUserMapInfo(int userId);

    /**
     * test return list<Map>
     * (实际应用中可存放关联配置map信息,1-将用户的用户名和手机视作用户的配置信息，获取所有用户的配置Map;2-一个学生有多门成绩，查询该学生N门功课的各科成绩汇总成一个Map)
     *
     * @return res
     */
    SingleResult<Map<String, String>> getUserMapList();
}
