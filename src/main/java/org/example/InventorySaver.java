package org.example;

import org.example.Products.IProduct;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class InventorySaver {
    String filePathProduct = "src/main/resources/products.csv";

    String filePathSupplier = "src/main/resources/suppliers.csv";

    public void saveProducts(ArrayList<IProduct> products) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathProduct));
            writer.write("");
            for (IProduct product : products) {
                String productCSV;
                productCSV = (product.getClass().getSimpleName() + "," + product.getItemName() + "," + product.getAmount() + "," + product.getPrice());
                writer.write(productCSV);
                writer.newLine();
                System.out.println("Saved " + productCSV);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save went wrong! " + e);
        }
    }

    public void saveSupplier(ArrayList<Supplier> suppliers) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathSupplier));
            writer.write("");
            for (Supplier supplier : suppliers) {
                StringBuilder supplierStringBuilder = new StringBuilder((supplier.getSupplier() + ","));
                int supplierSize = supplier.getNotifiedProducts().size();
                for (int i = 0; i < supplierSize; i++) {
                    supplierStringBuilder.append(supplier.getNotifiedProducts().get(i).getItemName());
                    if (i != supplierSize - 1) {
                        supplierStringBuilder.append(",");
                    }
                }
                String supplierCSV = supplierStringBuilder.toString();
                writer.write(supplierCSV);
                writer.newLine();
                System.out.println("Saved " + supplierCSV);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Save went wrong! " + e);
        }
    }
}
