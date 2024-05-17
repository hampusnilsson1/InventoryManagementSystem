package org.example.Products;

public abstract class IProduct {

    private String itemName;
    private int amount;
    private int price;

    public IProduct(String itemName, int amount, int price) {
        this.itemName = itemName;
        this.amount = amount;
        this.price = price;
    }

    public abstract void itemAdded();

    public abstract void refill(int amount);

    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
