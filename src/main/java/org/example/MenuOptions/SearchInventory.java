package org.example.MenuOptions;

import org.example.GetInput;
import org.example.Products.IProduct;
import org.example.Sorts.MergeSort;

import java.util.ArrayList;

public class SearchInventory implements ICommand {
    ArrayList<IProduct> products;

    public SearchInventory(ArrayList<IProduct> products) {
        this.products = products;
    }

    @Override
    public void execute() {
        MergeSort sort = new MergeSort();
        sort.mergeSort(products, 0, products.size() - 1, IProduct::getItemName);
        System.out.println("What item are u looking for? CASE SENSETIVE!");
        String itemNameSearch = GetInput.getStringInput();
        int result = search(itemNameSearch, products);
        if (result == -1)
            System.out.println("Not found!");
        else {
            System.out.println("Found " + itemNameSearch + " at index " + result);
            System.out.println(products.get(result).getItemName());
        }
    }

    @Override
    public String toString() {
        return "Search Inventory";
    }

    private int search(String itemName, ArrayList<IProduct> products) {
        int left = 0;
        int right = products.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products.get(mid).getItemName().compareTo(itemName) == 0) {
                return mid;
            }
            else if (products.get(mid).getItemName().compareTo(itemName) < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
