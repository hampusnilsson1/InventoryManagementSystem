package org.example.Products;

public class Beauty extends IProduct {

    public Beauty(String itemName, int amount, int price) {
        super(itemName, amount, price);
    }

    @Override
    public void itemAdded() {
        System.out.println("Beauty enthusiasts, get ready to glow! Indulge in our latest beauty arrivals and unlock your true radiance. From skincare essentials to makeup must-haves, elevate your beauty routine with our luxurious products!");
    }

    @Override
    public void refill(int amount) {
        this.setAmount(this.getAmount() + amount);
        System.out.println("A beauty product got restocked!");
    }
}
