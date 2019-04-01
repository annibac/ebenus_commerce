package com.cours.ebenus.maven.ebenus.front.office.web.utils;

import com.cours.ebenus.maven.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.maven.ebenus.service.ServiceFacade;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Utils {
    public static String getCookie(Cookie[] cookies, String cookieName) {
        if (cookies == null) return null;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public static void deleteCookie(HttpServletResponse response, String cookieName){
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static Utilisateur getUserLogged(String userCookie){
        if (userCookie == null) return null;
        String[] userArr = userCookie.split("@@", 0);

        if (userArr.length != 2) return null;

        Utilisateur userLogged = ServiceFacade.getInstance().getUtilisateurDao().authenticate(userArr[0], userArr[1]);
        if (userLogged == null) return null;

        return userLogged;
    }
}
