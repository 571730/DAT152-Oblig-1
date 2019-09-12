package no.hvl.dat152.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> cart;

    public Cart() {
        this.cart = new ArrayList<>();
    }

    public void addToCart(Product p) {
        this.cart.add(p);
    }

    public void removeFromCart(Product p) {
        this.cart.remove(p);
    }

    public ArrayList<Product> getCart(){
        return this.cart;
    }
}
