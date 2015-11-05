package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.routing.Routes;
import com.travelo.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", imageService.getAllImages().get(0).getImagePath().toString());
        model.addAttribute("routes", Routes.getRoutes());
        return "main";
    }
}
