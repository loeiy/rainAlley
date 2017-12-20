package com.alley.rain.serviceImpl.user;

import com.alley.rain.service.UserService;
import com.alley.rain.to.user.UserTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@Transactional
@Rollback*/
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void insert() throws Exception {
        UserTO po = new UserTO();
        po.setUserName("loeiy");
        po.setPassword("123456789");
        po.setPhone("18539270301");
        userService.insert(po);
    }

    @Test
    public void updateUser() throws Exception {
        userService.updateUser(1002, "dyf", "", "");
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

    @Test
    public void getUserMapInfo() throws Exception {
        userService.getUserMapInfo(1002);
    }

    @Test
    public void getUserMapList() throws Exception {
        userService.getUserMapList();
    }
}