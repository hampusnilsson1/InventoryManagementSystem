package org.example.Products;

public class Electronic extends IProduct {
    public Electronic(String itemName, int amount, int price) {
        super(itemName, amount, price);
    }

    @Override
    public void itemAdded() {
        System.out.println("New electronic items have been added to the inventory. Stay ahead with the latest in technology!");
    }

    @Override
    public void refill(int amount) {
        this.setAmount(this.getAmount() + amount);
        System.out.println("An electronic got restocked!");
    }
}
