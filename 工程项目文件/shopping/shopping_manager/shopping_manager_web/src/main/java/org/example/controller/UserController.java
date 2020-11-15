package org.example.controller;

import org.example.pojo.User;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/user/{userid}")
    @ResponseBody
    public User getUserById(@PathVariable Integer userid)
    {
        User user = userService.getUserById(userid);
        return user;
    }
}
