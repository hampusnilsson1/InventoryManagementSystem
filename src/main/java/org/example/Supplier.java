package org.example;

import org.example.Products.IProduct;

import java.util.ArrayList;

public class Supplier {
    private String supplier;

    ArrayList<IProduct> notifiedProducts;

    public Supplier(String supplierName, ArrayList<IProduct> notifiedProducts) {
        this.notifiedProducts = notifiedProducts;
        supplier = supplierName;
    }


    private void refillAllProducts(int amount) {
        for (IProduct product : notifiedProducts) {
            product.refill(amount);
        }
    }

    public void refillStock(int amount) {
        System.out.println(supplier + "s delivery arrived.");
        refillAllProducts(amount);
    }

    public String getSupplier() {
        return supplier;
    }

    public ArrayList<IProduct> getNotifiedProducts() {
        return notifiedProducts;
    }
}
