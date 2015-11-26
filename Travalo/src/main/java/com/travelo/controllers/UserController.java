package com.travelo.controllers;

/**
 * Created by ddph on 03/11/2015.
 */

import com.travelo.entities.MarkerEntity;
import com.travelo.entities.UserEntity;
import com.travelo.routing.Routes;
import com.travelo.services.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String myAccount(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myAccount";
    }

    /*    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
        @ResponseBody
        public boolean checkEmail(@ModelAttribute(value = "email") String email) {
            return userService.isEmailUnique(email);
        }*/
    @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
    @ResponseBody
    public String changePassword(@ModelAttribute(value = "oldPassword") String oldPassword, @ModelAttribute(value = "newPassword") String newPassword, ModelMap model) {
        /*model.addAttribute("message",userService.changeCurrentUserPassword(userService.getLoggedUser(), oldPassword, newPassword));
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        */
        return userService.changeCurrentUserPassword(userService.getLoggedUser(), oldPassword, newPassword);
    }

    @RequestMapping(value = "/myTravalo", method = RequestMethod.GET)
//    @ResponseBody
    public String myTravalo(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myTravalo";
    }


    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfile(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("markers", userService.getLoggedUser().getMarkers());
        model.addAttribute("routes", Routes.getRoutes());
        return "myProfile";
    }

    @RequestMapping(value = "/myPlaces", method = RequestMethod.GET)
    public String myPlaces(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myPlaces";
    }

    @RequestMapping(value = "/myMessages", method = RequestMethod.GET)
    public String myMessages(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myMessages";
    }

    @RequestMapping(value = "/myFriends", method = RequestMethod.GET)
    public String myFriends(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myFriends";
    }

    @RequestMapping(value = "/myHotels", method = RequestMethod.GET)
    public String myHotels(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myHotels";
    }

    @RequestMapping(value = "/myFlights", method = RequestMethod.GET)
    public String myFlights(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myFlights";
    }

    @RequestMapping(value = "/myRent", method = RequestMethod.GET)
    public String myRent(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myRent";
    }

    @RequestMapping(value = "/myToDO", method = RequestMethod.GET)
    public String myToDO(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myToDO";
    }

    @RequestMapping(value = "/myMaps", method = RequestMethod.GET)
    public String myMaps(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myMaps";
    }

    @RequestMapping(value = "/myTrips", method = RequestMethod.GET)
    public String myTrips(ModelMap model) {
        model.addAttribute("user", userService.getLoggedUser());
        model.addAttribute("routes", Routes.getRoutes());
        return "myTrips";
    }

    @RequestMapping(value = "/userMarkers", method = RequestMethod.GET)
    @ResponseBody
    public List getAllUserMarkers(@ModelAttribute(value = "login") String login) {
        if (userService.getLoggedUser().getLogin().equals(login)) {
            return userService.getUserMarkers(login);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/addMarker", method = RequestMethod.POST)
    @ResponseBody
    public boolean addMarker(@ModelAttribute(value = "title") String title, @ModelAttribute(value = "note") String note, @ModelAttribute(value = "latitude") double latitude, @ModelAttribute(value = "longitude") double longitude, BindingResult result, RedirectAttributes attr, ModelMap model) {
            userService.addMarker(title, note, latitude, longitude);
            attr.addFlashAttribute("status", HttpStatus.OK);
        return true;
    }
}
