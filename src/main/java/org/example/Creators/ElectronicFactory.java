package org.example.Creators;

import org.example.Products.Electronic;
import org.example.Products.IProduct;

public class ElectronicFactory extends IProductFactory {
    @Override
    protected IProduct newProduct(String itemName, int amount, int price) {
        return new Electronic(itemName, amount, price);
    }
}
