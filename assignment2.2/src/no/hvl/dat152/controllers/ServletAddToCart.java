package no.hvl.dat152.controllers;

import no.hvl.dat152.Models.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
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
        Cookie[] cookies = request.getCookies();
        Cookie cart = Arrays.stream(cookies).filter(cookie -> cookie.getValue().equals("cart")).findFirst()
                .orElse(new Cookie("cart", String.valueOf(UUID.randomUUID().variant())));

    }
}
