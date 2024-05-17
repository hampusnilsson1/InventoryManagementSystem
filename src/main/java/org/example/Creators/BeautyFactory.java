package org.example.Creators;

import org.example.Products.Beauty;
import org.example.Products.IProduct;

public class BeautyFactory extends IProductFactory {
    @Override
    protected IProduct newProduct(String itemName, int amount, int price) {
        return new Beauty(itemName, amount, price);
    }
}

