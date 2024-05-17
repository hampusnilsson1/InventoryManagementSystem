package org.example;

import org.example.MenuOptions.*;
import org.example.Products.IProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final HashMap<String, ICommand> options = new HashMap<>();
    private ArrayList<IProduct> products;
    private ArrayList<Supplier> suppliers;

    public Menu(ArrayList<IProduct> products, ArrayList<Supplier> suppliers) {
        this.products = products;
        this.suppliers = suppliers;
        options.put("1", new AddItem(products));
        options.put("2", new RemoveItem(products, suppliers));
        options.put("3", new DisplayInventory(products));
        options.put("4", new SortInventory(products));
        options.put("5", new SearchInventory(products));
        options.put("6", new Restock(products, suppliers));
    }

    public void display() {
        System.out.println("\u001B[31m=== Inventory Management System ===\u001B[0m");
        for (Map.Entry<String, ICommand> option : options.entrySet()) {
            System.out.println(option.getKey() + ". " + option.getValue().toString());
        }
        System.out.println("0. Save and Exit");
    }

    public void executeCommand(String choiceInput) {
        if (options.containsKey(choiceInput)) {
            options.get(choiceInput).execute();
        }
        else if (choiceInput.equals("0")) {
            InventorySaver inventorySaver = new InventorySaver();
            inventorySaver.saveProducts(products);
            inventorySaver.saveSupplier(suppliers);
            System.out.println("Closing!");
        }
        else {
            System.out.println("That was not an option.");
        }
    }
}
