package no.hvl.dat152.controllers;

import no.hvl.dat152.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cookie languageCookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("locale")).findFirst().orElse(null);
        if (languageCookie != null){
            Config.set(request.getSession(), Config.FMT_LOCALE, languageCookie.getValue());
        } else {
           Locale locale = request.getLocale();
           Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
           Cookie localeCookie = new Cookie("locale", locale.getLanguage());
           localeCookie.setMaxAge(50000);
           response.addCookie(localeCookie);
        }
        session.setAttribute("date", Utils.getDate());
        request.getRequestDispatcher("WEB-INF/index.jsp")
                .forward(request, response);
    }
}
