package com.alley.rain.serviceImpl.user;

import com.alley.rain.po.UserPO;
import com.alley.rain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@Transactional
@Rollback*/
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void insert() throws Exception {
        UserPO po = new UserPO();
        po.setUserName("loeiy");
        po.setPassword("123456789");
        po.setPhone("18539270301");
        userService.insert(po);
    }

    @Test
    public void updateUser() throws Exception {
        userService.updateUser(1002,"dyf","","");
    }

    @Test
    public void deleteUser() throws Exception {
        userService.deleteUser(1003);
    }

    @Test
    public void getUserById() throws Exception {
        userService.getUserById(1002);
    }

    @Test
    public void getUserList() throws Exception {
        userService.getUserList();
    }

}