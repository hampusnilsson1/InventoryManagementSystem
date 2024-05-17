package org.example.Creators;

import org.example.Products.Book;
import org.example.Products.IProduct;

public class BookFactory extends IProductFactory {
    @Override
    protected IProduct newProduct(String itemName, int amount, int price) {
        return new Book(itemName, amount, price);
    }
}
