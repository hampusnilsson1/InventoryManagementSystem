package org.example.MenuOptions;

import org.example.Products.IProduct;

import java.util.ArrayList;

public class DisplayInventory implements ICommand {
    ArrayList<IProduct> products;

    public DisplayInventory(ArrayList<IProduct> products) {
        this.products = products;
    }

    @Override
    public void execute() {
        System.out.println("\u001B[31m---Product Inventory---\u001B[0m");
        for (IProduct product : products) {
            String className = product.getClass().getSimpleName();
            System.out.println(className + ": " + product.getItemName() + ", " + product.getAmount() + " items left, " + product.getPrice() + "$ each.");
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Display Inventory";
    }
}