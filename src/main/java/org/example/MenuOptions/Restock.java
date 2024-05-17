package org.example.MenuOptions;

import org.example.GetInput;
import org.example.Supplier;
import org.example.Products.IProduct;

import java.util.ArrayList;

public class Restock implements ICommand {

    private ArrayList<IProduct> products;
    private ArrayList<Supplier> suppliers;

    public Restock(ArrayList<IProduct> products, ArrayList<Supplier> suppliers) {
        this.products = products;
        this.suppliers = suppliers;
    }

    @Override
    public void execute() {
        if (suppliers.isEmpty()) {
            System.out.println("No current suppliers, would u like to add one?");
            if (!GetInput.getYes()) {
                return;
            }
            addNewSupplier();
        }
        else {
            System.out.println("Would u like to \"Restock\" or \"Add\" new supplier?");
            String input = GetInput.getStringInput().toLowerCase();
            switch (input) {
                case "restock":
                    deliverFromSupplier();
                    break;
                case "add":
                    addNewSupplier();
            }
        }
        System.out.println("Restock done. Returning to menu!");
    }

    private void deliverFromSupplier() {
        System.out.println("Which supplier would u like to order restock from?");
        for (Supplier supplier : suppliers) {
            System.out.print(supplier.getSupplier() + ", ");
        }
        System.out.println();
        String inputSupplierName = GetInput.getStringInput().toLowerCase();
        for (Supplier supplier : suppliers) {
            String supplierName = supplier.getSupplier().toLowerCase();
            if (supplierName.equals(inputSupplierName)) {
                System.out.println("How much of each would u like to refill?");
                int refillAmount = GetInput.getIntInput();
                supplier.refillStock(refillAmount);
                return;
            }
        }
        System.out.println("Supplier not found!");
    }

    private void addNewSupplier() {
        System.out.println("What is the name of the supplier?");
        String supplierName = GetInput.getStringInput();
        for (Supplier supplier : suppliers) {
            if (supplierName.toLowerCase().equals(supplier.getSupplier().toLowerCase())) {
                System.out.println("Supplier already exists!");
                return;
            }
        }
        ArrayList<IProduct> productsForSupplier = new ArrayList<>();
        while (true) {
            System.out.println("What product would u want the supplier to deliver?");
            printAllAvailableProducts(productsForSupplier);
            String productInput = GetInput.getStringInput().toLowerCase();

            addProductToSupplier(productInput, productsForSupplier);

            System.out.println("Would u like to add more products to " + supplierName + "?");
            if (!GetInput.getYes()) {
                break;
            }
        }

        if (!supplierName.equals("") && productsForSupplier.size() != 0) {
            suppliers.add(new Supplier(supplierName, productsForSupplier));
            System.out.println("Supplier added!");
        }
    }

    private void addProductToSupplier(String productInput, ArrayList<IProduct> productsForSupplier) {
        for (IProduct product : products) {
            if (product.getItemName().toLowerCase().equals(productInput.toLowerCase())) {
                for (IProduct productAdded : productsForSupplier) {
                    if (productAdded.getItemName().toLowerCase().equals(productInput)) {
                        System.out.println("You already added that one.");
                        return;
                    }
                }
                productsForSupplier.add(product);
                System.out.println(product.getItemName() + " added to supplier");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    private void printAllAvailableProducts(ArrayList<IProduct> productsForSupplier) {
        for (IProduct product : products) {
            boolean found = false;
            for (IProduct supplierProduct : productsForSupplier) {
                if (product.getItemName().toLowerCase().equals(supplierProduct.getItemName().toLowerCase())) {
                    found = true;
                }
            }
            if (!found) {
                System.out.print(product.getItemName() + ", ");
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Restock Inventory";
    }
}
