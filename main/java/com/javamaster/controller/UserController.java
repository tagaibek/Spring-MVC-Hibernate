package com.javamaster.controller;

import com.javamaster.model.User;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String getUserByName(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loadUser = userService.getUserByLogin(authentication.getName());
        if (loadUser != null) {
            model.addAttribute("loadUser", loadUser);
        }
        return "user";
    }
}
