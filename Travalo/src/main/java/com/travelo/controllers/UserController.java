package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */
import com.travelo.entities.UserEntity;
import com.travelo.routing.Routes;
import com.travelo.services.ImageService;
import com.travelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/register")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("routes", Routes.getRoutes());
        model.addAttribute("pictures", imageService.getAllImages());
        return "register";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model)
    {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("routes", Routes.getRoutes());
        model.addAttribute("picuters", imageService.getAllImages().get(0).getImagePath().toString());
        return "register";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value="user") UserEntity user, BindingResult result)
    {
        userService.addUser(user);
        return "redirect:/";
    }
/*    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
    {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:/";
    }*/
}
