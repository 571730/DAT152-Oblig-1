package no.hvl.dat152.controllers;

import no.hvl.dat152.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String language = null;
        try {
            language = session.getAttribute("language").toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Locale locale = language != null ? new Locale(language) : new Locale("en");
        ResourceBundle res = ResourceBundle.getBundle("apptext", locale);
        session.setAttribute("haveLook", res.getString("frontPageInfo"));
        session.setAttribute("products", res.getString("products"));
        session.setAttribute("date", Utils.getDate());
        request.getRequestDispatcher("WEB-INF/index.jsp")
                .forward(request, response);
    }
}
