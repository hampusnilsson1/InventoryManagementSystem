package org.example.Sorts;

import org.example.Products.IProduct;

import java.util.ArrayList;
import java.util.function.Function;

public class MergeSort implements ISort {
    @Override
    public void sort(ArrayList<IProduct> products, Function<IProduct, Comparable> getKey) {
        mergeSort(products, 0, products.size() - 1, getKey);
    }

    public void mergeSort(ArrayList<IProduct> list, int left, int right, Function<IProduct, Comparable> getKey) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid, getKey);
            mergeSort(list, mid + 1, right, getKey);
            merge(list, left, mid, right, getKey);
        }
    }

    private void merge(ArrayList<IProduct> list, int left, int mid, int right, Function<IProduct, Comparable> getKey) {
        int arraySize1 = mid - left + 1;
        int arraySize2 = right - mid;

        ArrayList<IProduct> leftArray = new ArrayList<>();
        ArrayList<IProduct> rightArray = new ArrayList<>();

        for (int i = 0; i < arraySize1; i++) {
            leftArray.add(list.get(left + i));
        }
        for (int i = 0; i < arraySize2; i++) {
            rightArray.add(list.get(mid + 1 + i));
        }

        int i = 0;
        int j = 0;

        int currentIndex = left;
        while (i < arraySize1 && j < arraySize2) {
            Comparable leftKey = getKey.apply(leftArray.get(i));
            Comparable rightKey = getKey.apply(rightArray.get(j));
            if (leftKey.compareTo(rightKey) <= 0) {
                list.set(currentIndex, leftArray.get(i));
                i++;
            }
            else {
                list.set(currentIndex, rightArray.get(j));
                j++;
            }
            currentIndex++;
        }
        //Does the rest of the side
        while (i < arraySize1) {
            list.set(currentIndex, leftArray.get(i));
            i++;
            currentIndex++;
        }
        while (j < arraySize2) {
            list.set(currentIndex, rightArray.get(j));
            j++;
            currentIndex++;
        }
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
