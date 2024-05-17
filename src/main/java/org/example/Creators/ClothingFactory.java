package org.example.Creators;

import org.example.Products.Clothing;
import org.example.Products.IProduct;

public class ClothingFactory extends IProductFactory {

    @Override
    protected IProduct newProduct(String itemName, int amount, int price) {
        return new Clothing(itemName, amount, price);
    }
}
