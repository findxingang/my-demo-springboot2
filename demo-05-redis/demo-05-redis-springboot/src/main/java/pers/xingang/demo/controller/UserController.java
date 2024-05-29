package pers.xingang.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.xingang.demo.domain.User;
import pers.xingang.demo.service.UserService;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author xingang
 * @since 2024/05/29 11:26
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/save")
    public void saveUser() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("LocalDateTime.now(): " + now);
        userService.saveUser(new User(1L, "xingang", 18, now));
    }

    @RequestMapping("/get")
    public void getUser() {
        User user = userService.getUser(1L);
        System.out.println(user);
    }
}
