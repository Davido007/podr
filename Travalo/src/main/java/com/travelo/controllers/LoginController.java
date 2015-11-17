package com.travelo.controllers;

import com.travelo.entities.LoginParams;
import com.travelo.entities.UserEntity;
import com.travelo.routing.Routes;
import com.travelo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ddph on 03/11/2015.
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    UserEntity userEntity;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        model.addAttribute("routes", Routes.getRoutes());
        return "login";
    }
/*
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String  loginUser(@ModelAttribute(value="loginParams") LoginParams loginParams, BindingResult result, RedirectAttributes attr, ModelMap model){
        model.addAttribute("user", getPrincipal());
        model.addAttribute("routes", Routes.getRoutes());
        userEntity = loginService.login(loginParams);
        if(userEntity == null){
            return "redirect:/login";
        } else {
            model.addAttribute("user",userEntity);
            return "main";
        }
    }*/
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

/*    @RequestMapping(value="/logouts", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.addAttribute("user",null);
        return "main";
    }*/



}
