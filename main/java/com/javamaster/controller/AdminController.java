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
/*@PreAuthorize("hasAuthority('ADMIN')")*/
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());

        return "browse"; // browse
    }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        // todo change embedded tomcat
        // todo create Dao for Role
        // todo set here an attribute for roles
        // todo iterate roles in the create.jsp form
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

        return "redirect:/users";
    }

    @RequestMapping("/admin/users/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("/admin/users/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "edit";
    }

    @PostMapping("/admin/users/edit")
    public String edit(@ModelAttribute User user) {
        userService.updateUser(user);

        return "redirect:/users";
    }

    @RequestMapping("/admin/users/view/{id}")
    public String userData(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));

        return "view";
    }
}
