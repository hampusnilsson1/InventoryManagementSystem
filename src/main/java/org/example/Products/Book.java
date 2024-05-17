package org.example.Products;

public class Book extends IProduct {
    public Book(String itemName, int amount, int price) {
        super(itemName, amount, price);
    }

    @Override
    public void itemAdded() {
        System.out.println("Attention all bookworms! Dive into our latest arrivals of captivating stories and informative reads. Expand your literary horizons with our diverse selection of books!");
    }

    @Override
    public void refill(int amount) {
        this.setAmount(this.getAmount() + amount);
        System.out.println("More copies of a book got stocked!");
    }
}
