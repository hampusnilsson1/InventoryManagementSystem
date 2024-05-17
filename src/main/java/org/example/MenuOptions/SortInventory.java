package org.example.MenuOptions;

import org.example.GetInput;
import org.example.Products.IProduct;
import org.example.Sorts.MergeSort;
import org.example.Sorts.QuickSort;
import org.example.Sorts.ISort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SortInventory implements ICommand {
    private ArrayList<IProduct> products;

    private HashMap<String, ISort> sortMethods = new HashMap<>();

    public SortInventory(ArrayList<IProduct> products) {
        this.products = products;
        sortMethods.put("1", new MergeSort());
        sortMethods.put("2", new QuickSort());
    }


    @Override
    public void execute() {
        System.out.println("How would u like to sort the items?");
        System.out.println("By: ");
        System.out.println("1. Name");
        System.out.println("2. Amount");
        System.out.println("3. Price");
        String menuInput = GetInput.getStringInput();
        Function<IProduct, Comparable> key;

        switch (menuInput) {
            case "1":
                key = IProduct::getItemName;
                break;
            case "2":
                key = IProduct::getAmount;
                break;
            case "3":
                key = IProduct::getPrice;
                break;
            default:
                System.out.println("That was not an option!");
                return;
        }

        System.out.println("Which sorting algorithm would u like to use?");
        for (Map.Entry<String, ISort> sortMethod : sortMethods.entrySet()) {
            System.out.println(sortMethod.getKey() + ". " + sortMethod.getValue().toString());
        }
        System.out.println("SKRIV UT DEM HÄR MED HASHMAP");
        String algorithmInput = GetInput.getStringInput();
        if (sortMethods.containsKey(algorithmInput)) {
            sortMethods.get(algorithmInput).sort(products, key);
        }

        System.out.println("Sorting done. Returning to menu!");


    }

    @Override
    public String toString() {
        return "Sort Inventory";
    }
}
