package no.hvl.dat152.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cart;

    public Cart(){
        cart = new ArrayList<>();
    }

    public void addToCart(Product p){
        cart.add(p);
    }

    public List<Product> getCart() {
        return cart;
    }
}
