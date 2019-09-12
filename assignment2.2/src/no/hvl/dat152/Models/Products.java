package no.hvl.dat152.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Products {
    private static List<Product> products = new ArrayList<>();

    public static void addProduct(Product p){
        products.add(p);
    }

    public static List<Product> getProducts(ResourceBundle res){
        return products.stream()
                .map(p -> new Product(p.getName(), p.getPriceInLocal(res), p.getDescription(res)))
                .collect(Collectors.toList());
    }
}
