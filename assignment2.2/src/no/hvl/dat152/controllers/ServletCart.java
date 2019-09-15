package no.hvl.dat152.controllers;

import no.hvl.dat152.Models.Cart;
import no.hvl.dat152.Models.Carts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

@WebServlet(name = "ServletCart")
public class ServletCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie languageCookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("locale")).findFirst().orElse(null);
        if (languageCookie != null) {
            Config.set(request.getSession(), Config.FMT_LOCALE, languageCookie.getValue());
        } else {
            Locale locale = request.getLocale();
            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
            Cookie localeCookie = new Cookie("locale", locale.getLanguage());
            localeCookie.setMaxAge(50000);
            response.addCookie(localeCookie);
        }
        Locale locale = new Locale(languageCookie.getValue());
        ResourceBundle res = ResourceBundle.getBundle("apptext", locale);

        Cookie cartCookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("cart"))
                .findFirst()
                .orElse(null);
        if (cartCookie == null){
            request.setAttribute("emptyCart", true);
            request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
        }
        Cart cart = Carts.getCartFromMap(cartCookie.getValue());
        double multiplier = Double.parseDouble(res.getString("multiplier"));
        request.setAttribute("currency", res.getString("currencySymbol"));
        request.setAttribute("multiplier", multiplier);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
    }
}
