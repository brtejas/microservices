package com.user.controllers;


import com.user.VO.ResponseVO;
import com.user.models.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }

    @GetMapping("/{userid}")
    public ResponseVO getUser(@PathVariable("userid")Long id){

        return userService.getUser(id);
    }
}
