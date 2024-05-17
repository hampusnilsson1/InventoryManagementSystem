package org.example.Creators;

import org.example.Products.IProduct;

public abstract class IProductFactory {
    public IProduct getProduct(String itemName, int amount, int price) {
        IProduct product = newProduct(itemName, amount, price);
        return product;
    }

    protected abstract IProduct newProduct(String itemName, int amount, int price);
}
