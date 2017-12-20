package com.alley.rain.dao;

import com.alley.rain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    int insert(UserPO userInfo);

    int updateUser(@Param("userId") int userId, @Param("userName") String userName, @Param("password") String password, @Param("phone") String phone);

    int deleteUser(int userId);

    UserPO getUserById(int userId);

    List<UserPO> getUserList();

    /**
     * 单个Map可以直接返回Map<String, Object>
     *
     * @param userId id
     * @return map
     */
    Map<String, Object> getUserMapInfo(int userId);

    /**
     * 多条数据必须返回List<Map<String, Object>>
     *
     * @return list
     */
    List<Map<String, Object>> getUserMapList();
}
