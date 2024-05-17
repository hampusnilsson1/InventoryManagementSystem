package org.example;

import org.example.Products.IProduct;
import org.example.Creators.IProductFactory;

import java.util.ArrayList;

public class ItemAdder {
    private ArrayList<IProduct> products;

    public ItemAdder(ArrayList<IProduct> products) {
        this.products = products;
    }

    public void createProduct(IProductFactory creator, String itemName, int amount, int price, boolean showMessage) {
        IProduct product = creator.getProduct(itemName, amount, price);
        if (showMessage)
            product.itemAdded();
        products.add(product);
    }
}
