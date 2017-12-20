package com.alley.rain.service.impl;

import com.alley.rain.common.QueryResult;
import com.alley.rain.common.Result;
import com.alley.rain.common.SingleResult;
import com.alley.rain.dao.UserDao;
import com.alley.rain.dto.user.UserDTO;
import com.alley.rain.enums.ActionCodeEnum;
import com.alley.rain.po.UserPO;
import com.alley.rain.service.UserService;
import com.alley.rain.to.user.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Result insert(UserTO userInfo) {
        UserPO userPO = new UserDTO(userInfo).genPO();
        if (userDao.insert(userPO) > 0) {
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
    public SingleResult<UserTO> getUserById(int userId) {
        SingleResult<UserTO> res = new SingleResult<>();
        UserPO userInfo = userDao.getUserById(userId);
        if (userInfo != null) {
            res.setResult(new UserDTO(userInfo).generateByName(UserTO.class));
            res.setCode(ActionCodeEnum.ActionSuccessed);
            return res;
        }
        res.setCode(ActionCodeEnum.UserNotExist);
        return res;
    }

    @Override
    public QueryResult<UserTO> getUserList() {
        QueryResult<UserTO> res = new QueryResult<>();
        List<UserPO> poList = userDao.getUserList();
        List<UserTO> resList = new ArrayList<>();
        poList.forEach(t -> resList.add(new UserDTO(t).generateByName(UserTO.class)));
        res.setCode(ActionCodeEnum.ActionSuccessed);
        res.setResults(resList);
        return res;
    }

    @Override
    public SingleResult<Map<String, String>> getUserMapInfo(int userId) {
        SingleResult<Map<String, String>> res = new SingleResult<>();
        //namePhoneMap结果为{"userPhone","18539270301"},{"userName","dyf"}
        Map<String, Object> namePhoneMap = userDao.getUserMapInfo(userId);
        Map<String, String> resultMap = new HashMap<>();
        String name = null;
        String phone = null;
        //下述代码不能用Lambda表达式操作，否则会报Variable used in lambda expression should be final or effectively final
        //可以在Stream中使用外部变量，但是却不能进行赋值操作
        for (Map.Entry<String, Object> entry : namePhoneMap.entrySet()) {
            //获取namePhoneMap中的所有key对应的value
            if ("userName".equals(entry.getKey())) {
                name = (String) entry.getValue();
            } else if ("userPhone".equals(entry.getKey())) {
                phone = (String) entry.getValue();
            }
        }
        //单独将name和phone分别作为key和value放进map
        resultMap.put(name, phone);
        res.setResult(resultMap);
        res.setCode(ActionCodeEnum.ActionSuccessed);
        return res;
    }

    @Override
    public SingleResult<Map<String, String>> getUserMapList() {
        SingleResult<Map<String, String>> res = new SingleResult<>();
        List<Map<String, Object>> namePhoneMapList = userDao.getUserMapList();
        Map<String, String> resultMap = new HashMap<>();
        namePhoneMapList.forEach(t -> {
            String userName = null;
            String userPhone = null;
            for (Map.Entry<String, Object> entry : t.entrySet()) {
                if ("name".equals(entry.getKey())) {
                    userName = (String) entry.getValue();
                } else if ("phone".equals(entry.getKey())) {
                    userPhone = (String) entry.getValue();
                }
            }
            resultMap.put(userName, userPhone);
        });
        res.setResult(resultMap);
        return res;
    }
}
