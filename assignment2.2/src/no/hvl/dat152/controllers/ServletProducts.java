package no.hvl.dat152.controllers;

import no.hvl.dat152.Models.Cart;
import no.hvl.dat152.Models.Carts;
import no.hvl.dat152.Models.Product;
import no.hvl.dat152.Models.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

@WebServlet(name = "ServletProducts")
public class ServletProducts extends HttpServlet {
    public void init() {
        Products.addProduct(new Product("Black Coffee Cup", 5.76, "descriptionBlackCoffee"));
        Products.addProduct(new Product("White Coffee Cup", 8.96, "descriptionWhiteCoffee"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemAdded = request.getParameter("added");
        if (itemAdded != null){
            request.setAttribute("itemAdded", itemAdded);
        }
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
        double multiplier = Double.parseDouble(res.getString("multiplier"));
        request.setAttribute("currency", res.getString("currencySymbol"));
        request.setAttribute("products", Products.getProducts());
        request.setAttribute("multiplier", multiplier);
        request.getRequestDispatcher("WEB-INF/products.jsp")
                .forward(request, response);
    }
}
