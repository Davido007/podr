package com.travelo.routing;

import java.util.HashMap;

/**
 * Created by ddph on 02/11/2015.
 */
public class Routes {
    private static HashMap<String, String> routes;

    public static final String host = "/Travalo";
    public static final String home = "/home";
    public static final String login = "/login";
    public static final String logout = "/logout";
    public static final String register = "/register";
    public static final String myAccount = "/user";
    public static final String myTravalo = "/myTravalo";
    public static final String myProfile = "/myProfile";
    public static final String myPlaces = "/myPlaces";
    public static final String myMessages = "/myMessages";
    public static final String myFriends = "/myFriends";
    public static final String myHotels = "/myHotels";
    public static final String myFlights = "/myFlights";
    public static final String myRent = "/myRent";
    public static final String myToDO = "/myToDO";
    public static final String myMaps = "/myMaps";
    public static final String myTrips = "/myTrips";

    private static void setRoutes()
    {
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("login", host + login);
            routes.put("register", host + register);
            routes.put("logout", host + logout);
            routes.put("myAccount", host + myAccount);
            routes.put("myTravalo", host + myAccount + myTravalo);
            routes.put("myProfile", host + myAccount + myProfile);
            routes.put("myPlaces", host + myAccount + myPlaces);
            routes.put("myMessages", host + myAccount + myMessages);
            routes.put("myFriends", host + myAccount + myFriends);
            routes.put("myHotels", host + myAccount + myHotels);
            routes.put("myFlights", host + myAccount + myFlights);
            routes.put("myRent", host + myAccount + myRent);
            routes.put("myToDO", host + myAccount + myToDO);
            routes.put("myMaps", host + myAccount + myMaps);
            routes.put("myTrips", host + myAccount + myTrips);
        }
    }

    public static HashMap<String, String> getRoutes()
    {
        setRoutes();

        return routes;
    }

    public static String getRoute(String destin)
    {
        setRoutes();

        return routes.get(destin);
    }
}
