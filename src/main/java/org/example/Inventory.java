package org.example;

import org.example.Products.IProduct;

import java.util.ArrayList;

public class Inventory {
    private static Inventory instance = new Inventory();

    public static Inventory getInstance() {
        return instance;
    }

    public ArrayList<IProduct> products;

    public ArrayList<Supplier> suppliers;

    private Inventory() {
        InventoryLoader inventoryLoader = new InventoryLoader();
        products = inventoryLoader.loadProducts();
        suppliers = inventoryLoader.loadSuppliers(products);
    }

    public void run() {
        Menu menu = new Menu(products, suppliers);
        String choice = "";
        while (!choice.equals("0")) {
            menu.display();
            choice = GetInput.getStringInput();
            menu.executeCommand(choice);

            appSleep(2);
        }
    }

    void appSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {

        }
    }

}
