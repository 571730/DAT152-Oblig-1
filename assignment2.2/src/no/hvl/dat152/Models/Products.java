package no.hvl.dat152.Models;

import java.util.ArrayList;
import java.util.List;

public class Products {
    private static List<Product> products = new ArrayList<>();

    public static void addProduct(Product p){
        products.add(p);
    }

    public static List<Product> getProducts(){
        return products;
    }
}
