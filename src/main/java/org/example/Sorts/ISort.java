package org.example.Sorts;

import org.example.Products.IProduct;

import java.util.ArrayList;
import java.util.function.Function;

public interface ISort {
    void sort(ArrayList<IProduct> products, Function<IProduct, Comparable> getKey);

    String toString();
}
