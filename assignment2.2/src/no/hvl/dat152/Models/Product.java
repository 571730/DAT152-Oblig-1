package no.hvl.dat152.Models;

import java.util.ResourceBundle;

public class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }


    public double getPriceInLocal(ResourceBundle res) {
        String multiplier = res.getString("multiplier");
        return price * Double.parseDouble(multiplier);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(ResourceBundle res) {
        return res.getString(this.description);
    }
}
