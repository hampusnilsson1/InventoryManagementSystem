package org.example.MenuOptions;

import org.example.Creators.FactorySelector;
import org.example.Products.IProduct;
import org.example.Creators.IProductFactory;
import org.example.GetInput;
import org.example.ItemAdder;

import java.util.ArrayList;

public class AddItem implements ICommand {
    private ArrayList<IProduct> products;
    private FactorySelector factorySelector = new FactorySelector();
    private ItemAdder itemAdder;

    public AddItem(ArrayList<IProduct> products) {
        this.products = products;
        itemAdder = new ItemAdder(products);
    }

    @Override
    public void execute() {
        System.out.println("What type of item are u adding?");
        for (String option : factorySelector.getFactoryMap().keySet()) {
            System.out.print(option + ", ");
        }
        System.out.println();

        String itemType = GetInput.getStringInput().toLowerCase();
        IProductFactory creator = factorySelector.selectFactory(itemType);

        if (creator == null) {
            System.out.println("Could not add " + itemType + " to the system.");
            return;
        }

        System.out.println("What " + itemType + " are u adding?");
        String itemName = GetInput.getStringInput();

        System.out.println("How many " + itemName + "s are u adding?");
        int itemAmount = GetInput.getIntInput();

        for (IProduct product : products) {
            if (productExistsChange(product, itemName, itemAmount)) {
                return;
            }
        }

        System.out.println("What does one " + itemName + " cost?");
        int itemPrice = GetInput.getIntInput();

        itemAdder.createProduct(creator, itemName, itemAmount, itemPrice, true);
        System.out.println("Adding done. Returning to menu!");
    }

    private boolean productExistsChange(IProduct product, String itemName, int itemAmount) {
        if (product.getItemName().equalsIgnoreCase(itemName)) {
            System.out.println(itemName + " already exist in the inventory, adding amount.");
            product.setAmount(product.getAmount() + itemAmount);
            System.out.println("Would u like to change the " + product.getPrice() + " price?");
            boolean changePrice = GetInput.getYes();
            if (changePrice) {
                System.out.println("What should the new price be?");
                int newPrice = GetInput.getIntInput();
                product.setPrice(newPrice);
                System.out.println("Price changed!");
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Add Item";
    }
}
