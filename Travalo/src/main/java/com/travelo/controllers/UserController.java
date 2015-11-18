package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.routing.Routes;
import com.travelo.entities.UserEntity;
import org.springframework.ui.ModelMap;
import com.travelo.services.UserService;
import com.travelo.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    UserEntity userEntity;

    @RequestMapping(method = RequestMethod.GET)
    public String myAccount(ModelMap model) {
        userEntity = userService.getLoggedUser();

        model.addAttribute("message", imageService.getPopularImages().get(0).getImagePath().toString());
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("routes", Routes.getRoutes());
        model.addAttribute("pictures", imageService.getPopularImages());
        return "register";
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkLogin(@ModelAttribute(value = "login") String login) {
        return userService.isLoginUnique(login);
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkEmail(@ModelAttribute(value = "email") String email) {
        return userService.isEmailUnique(email);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user") UserEntity user, BindingResult result, RedirectAttributes attr, ModelMap model) {
        try {
            userService.addUser(user);
            attr.addFlashAttribute("status", HttpStatus.OK);
        } catch (ConstraintViolationException cve) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            attr.addFlashAttribute("status", HttpStatus.BAD_REQUEST);
        }
        return "redirect:/home";
    }
}
