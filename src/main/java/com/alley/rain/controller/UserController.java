package com.alley.rain.controller;

import com.alley.rain.po.UserPO;
import org.springframework.web.bind.annotation.*;

/**
 * Spring Boot内部使用Spring MVC作为它的Web组件，所以可以通过注解的方式快速开发接口类
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public UserPO getUserInfo(@PathVariable("id") int id){
        return null;
    }

    @PutMapping("/{id}")
    public UserPO updateUserInfo(
            @PathVariable("id")
                    int id,
            @RequestBody
                    UserPO newUser) {
        // TODO
        return null;
    }
}
