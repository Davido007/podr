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
@RequestMapping(value = "/Access_Denied")
public class AccessDeniedController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        if (userService.getLoggedUser() != null){
            model.addAttribute("user", userService.getLoggedUser());
        } else {
            model.addAttribute("user", null);
        }
        return "accessDenied";
    }
}
