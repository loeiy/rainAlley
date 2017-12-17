package com.alley.rain.dao;

import com.alley.rain.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    int insert(UserPO userInfo);

    int updateUser(@Param("userId") int userId, @Param("userName") String userName, @Param("password") String password, @Param("phone") String phone);

    int deleteUser(int userId);

    UserPO getUserById(int userId);

    List<UserPO> getUserList();
}
