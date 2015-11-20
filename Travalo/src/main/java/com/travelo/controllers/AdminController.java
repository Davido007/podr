package com.travelo.controllers;

import org.springframework.ui.ModelMap;
import com.travelo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ddph on 17/11/2015.
 */
@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {

        if (userService.getLoggedUser() != null) {
            model.addAttribute("user", userService.getLoggedUser().getLogin());
        } else {
            model.addAttribute("user", null);
        }
        return "admin";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        if (userService.getLoggedUser() != null) {
            model.addAttribute("user", userService.getLoggedUser());
        } else {
            model.addAttribute("user", null);
        }
        return "dba";
    }
}
