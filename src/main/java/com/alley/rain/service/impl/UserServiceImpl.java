package com.alley.rain.service.impl;

import com.alley.rain.common.QueryResult;
import com.alley.rain.common.Result;
import com.alley.rain.common.SingleResult;
import com.alley.rain.dao.UserDao;
import com.alley.rain.enums.ActionCodeEnum;
import com.alley.rain.po.UserPO;
import com.alley.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Result insert(UserPO userInfo) {
        if (userDao.insert(userInfo) > 0) {
            return new Result(true, ActionCodeEnum.ActionSuccessed);
        }
        return new Result(false, ActionCodeEnum.ActionFailed);
    }

    @Override
    public Result updateUser(int userId, String userName, String password, String phone) {
        Result res = new Result();
        if (userDao.updateUser(userId, userName, password, phone) > 0) {
            res.setCode(ActionCodeEnum.ActionSuccessed);
        }
        return res;
    }

    @Override
    public Result deleteUser(int userId) {
        Result res = new Result();
        if (userDao.deleteUser(userId) > 0) {
            res.setCode(ActionCodeEnum.ActionSuccessed);
        }
        return res;
    }

    @Override
    public SingleResult<UserPO> getUserById(int userId) {
        SingleResult<UserPO> res = new SingleResult<>();
        UserPO userInfo = userDao.getUserById(userId);
        if (userInfo != null) {
            res.setResult(userInfo);
            res.setCode(ActionCodeEnum.ActionSuccessed);
            return res;
        }
        res.setCode(ActionCodeEnum.UserNotExist);
        return res;
    }

    @Override
    public QueryResult<UserPO> getUserList() {
        QueryResult<UserPO> res = new QueryResult<>();
        List<UserPO> poList = userDao.getUserList();
        res.setCode(ActionCodeEnum.ActionSuccessed);
        res.setResults(poList);
        return res;
    }
}
