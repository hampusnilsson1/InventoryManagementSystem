package org.example.MenuOptions;

import org.example.GetInput;
import org.example.Products.IProduct;
import org.example.Supplier;

import java.util.ArrayList;

public class RemoveItem implements ICommand {
    private ArrayList<IProduct> products;
    ArrayList<Supplier> suppliers;

    public RemoveItem(ArrayList<IProduct> products, ArrayList<Supplier> suppliers) {
        this.products = products;
        this.suppliers = suppliers;
    }

    @Override
    public void execute() {
        if (products.size() != 0) {
            ICommand displayInv = new DisplayInventory(products);
            displayInv.execute();
            System.out.println("Which product would u like to remove from the Inventory?");
            String productNameInput = GetInput.getStringInput().toLowerCase();
            for (IProduct product : products) {
                if (product.getItemName().toLowerCase().equals(productNameInput)) {
                    removeSupplyProduct(productNameInput);
                    products.remove(product);
                    System.out.println(product.getItemName() + " was removed!");
                    return;
                }
            }
            System.out.println("Product not found!");
        }
    }

    private void removeSupplyProduct(String productToDelete) {
        suppliers.forEach(supplier ->
                supplier.getNotifiedProducts().removeIf(
                        supplyProduct -> supplyProduct.getItemName().equalsIgnoreCase(productToDelete)
                )
        );
    }

    @Override
    public String toString() {
        return "Remove Item";
    }
}