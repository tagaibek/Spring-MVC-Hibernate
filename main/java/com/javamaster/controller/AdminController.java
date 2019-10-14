package com.javamaster.controller;

import com.javamaster.model.Role;
import com.javamaster.model.User;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String user() {
        return "login";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());

        return "browse";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleList", userService.getRoles());

        return "create";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, @RequestParam("role[]") List<String> roleList) {
        for (String roleStr : roleList) {
            Role role = userService.getRoleByName(roleStr);
            user.getRoles().add(role);
        }
        userService.addUser(user);

        return "redirect:/admin/users";
    }

    @RequestMapping("/users/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);

        return "redirect:/admin/users";
    }

    @RequestMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("roleList", userService.getRoles());
        model.addAttribute("user", user);

        return "edit";
    }

    @PostMapping("/users/edit")
    public String edit(@ModelAttribute User user,@RequestParam("role[]") List<String> roleList) {
        for (String roleStr : roleList) {
            Role role = userService.getRoleByName(roleStr);
            user.getRoles().add(role);
        }
        userService.updateUser(user);

        return "redirect:/admin/users";
    }
}
