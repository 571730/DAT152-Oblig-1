package no.hvl.dat152.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cart;

    public Cart(){
        cart = new ArrayList<>();
    }

    public void addToCart(CartItem p){
        if (cart.stream().anyMatch(i -> i.getName().equals(p.getName()))){
            cart.stream().filter(x -> x.getName().equals(p.getName()))
                    .findFirst().get().addOne();
        } else
            cart.add(p);
    }

    public List<CartItem> getCart() {
        return cart;
    }

    public double getTotalCostCart(){
        return cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
