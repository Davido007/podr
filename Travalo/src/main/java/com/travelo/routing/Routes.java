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

    private static void setRoutes()
    {
        if(routes == null)
        {
            routes = new HashMap<String, String>();

            routes.put("host", host);
            routes.put("home", host + home);
            routes.put("login", host + login);
            routes.put("register", host + register);
            //routes.put("sair", host + sair);
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
