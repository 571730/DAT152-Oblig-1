package no.hvl.dat152.controllers;

import no.hvl.dat152.Models.Cart;
import no.hvl.dat152.Models.CartItem;
import no.hvl.dat152.Models.Carts;
import no.hvl.dat152.Models.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@WebServlet(name = "ServletAddToCart")
public class ServletAddToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        if (product == null) {
            response.sendRedirect(request.getHeader("referer"));
        }
        Cookie cartCookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("cart"))
                .findFirst()
                .orElse(new Cookie("cart", String.valueOf(new Random().nextInt(10000))));
        cartCookie.setMaxAge(50000);
        response.addCookie(cartCookie);
        Cart cart = Carts.getCartFromMap(cartCookie.getValue());
        cart.addToCart(new CartItem(Products.getProduct(product)));
        response.sendRedirect("products?added=" + product);
    }
}
