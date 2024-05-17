package org.example;

import org.example.Creators.FactorySelector;
import org.example.Products.IProduct;
import org.example.Creators.IProductFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class InventoryLoader {

    FactorySelector factorySelector = new FactorySelector();
    ItemAdder itemAdder;
    String filePathProduct = "src/main/resources/products.csv";
    String filePathSupplier = "src/main/resources/suppliers.csv";

    public ArrayList<IProduct> loadProducts() {
        ArrayList<IProduct> products = new ArrayList<>();
        itemAdder = new ItemAdder(products);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePathProduct));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] productParts = line.split(",");

                IProductFactory creator = factorySelector.selectFactory(productParts[0]);
                String itemName = productParts[1];
                int itemAmount = Integer.parseInt(productParts[2]);
                int itemPrice = Integer.parseInt(productParts[3]);

                itemAdder.createProduct(creator, itemName, itemAmount, itemPrice, false);
            }
            return products;
        } catch (Exception e) {
            System.out.println("Failed to load!");
            return products;
        }
    }

    public ArrayList<Supplier> loadSuppliers(ArrayList<IProduct> products) {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePathSupplier));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] supplierParts = line.split(",");

                String supplierName = supplierParts[0];

                ArrayList<IProduct> productsForSupplier = matchProductNamesToProducts(products, supplierParts);

                suppliers.add(new Supplier(supplierName, productsForSupplier));
            }
            return suppliers;
        } catch (Exception e) {
            System.out.println("Failed to load!");
            return suppliers;
        }
    }

    private ArrayList<IProduct> matchProductNamesToProducts(ArrayList<IProduct> products, String[] supplierParts) {
        ArrayList<IProduct> productsForSupplier = new ArrayList<>();
        for (int i = 1; i < supplierParts.length; i++) {
            for (IProduct product : products) {
                if (supplierParts[i].equalsIgnoreCase(product.getItemName())) {
                    productsForSupplier.add(product);
                }
            }
        }
        return productsForSupplier;
    }
}
