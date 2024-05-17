package org.example.Sorts;

import org.example.Products.IProduct;

import java.util.ArrayList;
import java.util.function.Function;

public class QuickSort implements ISort {
    @Override
    public void sort(ArrayList<IProduct> products, Function<IProduct, Comparable> getKey) {
        quickSort(products, 0, products.size() - 1, getKey);
    }

    private void quickSort(ArrayList<IProduct> products, int left, int right, Function<IProduct, Comparable> getKey) {
        if (left < right) {
            int pivotIndex = partition(products, left, right, getKey);// SKA MER SKRIVAS

            quickSort(products, left, pivotIndex - 1, getKey);
            quickSort(products, pivotIndex + 1, right, getKey);
        }
    }

    private int partition(ArrayList<IProduct> products, int left, int right, Function<IProduct, Comparable> getKey) {
        IProduct pivotProject = products.get(right);

        int i = (left - 1);

        for (int j = left; j <= right - 1; j++) {
            if (getKey.apply(products.get(j)).compareTo(getKey.apply(pivotProject)) < 0) {
                i++;
                swap(products, i, j);
            }
        }
        swap(products, i + 1, right);
        return i + 1;
    }

    private void swap(ArrayList<IProduct> products, int i, int j) {
        IProduct tempProduct = products.get(i);
        products.set(i, products.get(j));
        products.set(j, tempProduct);
    }


    @Override
    public String toString() {
        return "Quick Sort";
    }
}
