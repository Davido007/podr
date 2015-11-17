package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.routing.Routes;
import com.travelo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ImageService imageService;

/*    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
        model.addAttribute("user", getPrincipal());
        return "welcome";
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        /*if(model.get("user") != null){
            model.addAttribute(model.get("user"));
        }*/
        System.out.println("ssssssssssssssssss"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("userName", getPrincipal());
        model.addAttribute("status", model.get("status"));
        model.addAttribute("message", imageService.getPopularImages().get(0).getImagePath().toString());
        model.addAttribute("routes", Routes.getRoutes());
        return "main";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        }
        return userName;
    }
}
