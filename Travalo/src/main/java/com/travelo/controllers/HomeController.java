package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.routing.Routes;
import com.travelo.services.UserService;
import com.travelo.services.ImageService;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage(ModelMap model) {
        if (userService.getLoggedUser() != null){
            model.addAttribute("user", userService.getLoggedUser());
//            model.addAttribute("markers", userService.getLoggedUser().getMarkers().get(0).getLatitude());
        } else {
            model.addAttribute("user", null);
        }
        model.addAttribute("status", model.get("status"));
        model.addAttribute("message", imageService.getPopularImages().get(0).getImagePath().toString());
        model.addAttribute("routes", Routes.getRoutes());
        return "main";
    }

}
