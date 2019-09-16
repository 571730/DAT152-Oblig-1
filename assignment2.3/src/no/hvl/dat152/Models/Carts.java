package no.hvl.dat152.Models;

import java.util.HashMap;

public class Carts {
    private static HashMap<String, Cart> cartMap = new HashMap<>();

    public static void addCartToMap(String key, Cart value){
        cartMap.put(key, value);
    }

    public static Cart getCartFromMap(String key){
        if (!cartMap.containsKey(key)){
            cartMap.put(key, new Cart());
        }
        return cartMap.get(key);
    }
}
