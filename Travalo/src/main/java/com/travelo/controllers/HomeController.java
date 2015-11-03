package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.routing.Routes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello LAM");
        model.addAttribute("routes", Routes.getRoutes());
        return "main";
    }
}
