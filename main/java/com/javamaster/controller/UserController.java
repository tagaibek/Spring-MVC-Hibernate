package com.javamaster.controller;

import com.javamaster.model.User;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());

        return "browse"; // browse
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());

        return "create";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);

        return "redirect:/users";
    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "edit";
    }

    @PostMapping("/users/edit")
    public String edit(@ModelAttribute User user) {
        userService.updateUser(user);

        return "redirect:/users";
    }

    @RequestMapping("/users/view/{id}")
    public String userData(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "view";
    }
}
