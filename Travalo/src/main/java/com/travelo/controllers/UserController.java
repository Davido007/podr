package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */
import com.travelo.entities.UserEntity;
import com.travelo.routing.Routes;
import com.travelo.services.ImageService;
import com.travelo.services.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
        model.addAttribute("pictures", imageService.getPopularImages());
        return "register";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model)
    {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("usersList", userService.getAllUsers());
        model.addAttribute("routes", Routes.getRoutes());
        model.addAttribute("picuters", imageService.getPopularImages().get(0).getImagePath().toString());
        return "register";
    }
    @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkLogin(@ModelAttribute(value="login") String login)
    {
        return userService.isLoginUnique(login);
    }
    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkEmail(@ModelAttribute(value="email") String email)
    {
        return userService.isEmailUnique(email);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String  addUser(@ModelAttribute(value="user") UserEntity user, BindingResult result, RedirectAttributes attr, ModelMap model)
    {
        try{
            userService.addUser(user);
            attr.addFlashAttribute("status", HttpStatus.OK);
        }catch (ConstraintViolationException cve){
            attr.addFlashAttribute("org.springframework.validation.BindingResult.user", result);
            attr.addFlashAttribute("status", HttpStatus.BAD_REQUEST);
            System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"+result.hasErrors());
        }
        //userService.addUser(user);

        //return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        return "redirect:/home";
    }
/*    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
    {
        employeeManager.deleteEmployee(employeeId);
        return "redirect:/";
    }*/
}
