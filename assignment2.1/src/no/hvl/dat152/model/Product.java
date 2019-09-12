package no.hvl.dat152.model;

public class Product {
    private int pno;
    private String pName;
    private double priceInEuro;

    public Product(int pno, String pName, double priceInEuro) {
        this.pno = pno;
        this.pName = pName;
        this.priceInEuro = priceInEuro;
    }

    public int getPno() {
        return pno;
    }

    public String getpName() {
        return pName;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }
}
