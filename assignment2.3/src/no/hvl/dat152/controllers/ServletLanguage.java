package no.hvl.dat152.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

@WebServlet(name = "ServletLanguage")
public class ServletLanguage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lang = "en";
        try {
            lang = request.getParameter("lan");
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        Cookie localeCookie = new Cookie("locale", lang);
        localeCookie.setMaxAge(50000);
        response.addCookie(localeCookie);
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }
}
