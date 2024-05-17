package org.example.Products;

public class Clothing extends IProduct {
    public Clothing(String itemName, int amount, int price) {
        super(itemName, amount, price);
    }

    @Override
    public void itemAdded() {
        System.out.println("Exciting news! Fresh styles and trendy clothing items have just arrived in our inventory. Elevate your wardrobe with our latest collection!");
    }

    @Override
    public void refill(int amount) {
        this.setAmount(this.getAmount() + amount);
        System.out.println("A clothing got restocked!");
    }
}
