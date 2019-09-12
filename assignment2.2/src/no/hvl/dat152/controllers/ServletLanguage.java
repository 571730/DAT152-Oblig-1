package no.hvl.dat152.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        HttpSession session = request.getSession(true);
        session.setAttribute("language", lang);
        response.sendRedirect(request.getContextPath() + "/");
    }
}
