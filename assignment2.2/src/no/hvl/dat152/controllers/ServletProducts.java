package no.hvl.dat152.controllers;

import no.hvl.dat152.Models.Product;
import no.hvl.dat152.Models.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(name = "ServletProducts")
public class ServletProducts extends HttpServlet {
    public void init(){
        Products.addProduct(new Product("Black Coffee Cup", 5.76, "descriptionBlackCoffee"));
        Products.addProduct(new Product("White Coffee Cup", 8.96, "descriptionWhiteCoffee"));
    }

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
        session.setAttribute("home", res.getString("home"));
        session.setAttribute("products", Products.getProducts(res));
        request.getRequestDispatcher("WEB-INF/products.jsp")
                .forward(request, response);
    }
}
