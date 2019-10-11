package com.javamaster.controller;

/*@Controller
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getUserByName(@ModelAttribute User user, Model model) {
        User loadUser = (User)userService.loadUserByUsername(user.getName());
        if (loadUser !=null){
            model.addAttribute(loadUser);
        }
        return "user";
    }
}*/
