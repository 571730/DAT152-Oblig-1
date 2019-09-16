package no.hvl.dat152.Models;

public class CartItem  extends Product{
    private int quantity;

    public CartItem(String name, double price, String description) {
        super(name, price, description);
        quantity = 1;
    }

    public CartItem(Product p){
        super(p.getName(), p.getPrice(), p.getDescription());
        quantity = 1;
    }

    public double getTotalPrice() {
        return super.getPrice() * this.quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addOne(){
        this.quantity++;
    }
}
