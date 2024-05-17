package org.example.Creators;

import java.util.HashMap;

public class FactorySelector {
    private HashMap<String, IProductFactory> factoryMap = new HashMap<>();

    public FactorySelector() {
        factoryMap.put("beauty", new BeautyFactory());
        factoryMap.put("book", new BookFactory());
        factoryMap.put("clothing", new ClothingFactory());
        factoryMap.put("electronic", new ElectronicFactory());
    }

    public IProductFactory selectFactory(String input) {
        return factoryMap.get(input.toLowerCase());
    }

    public HashMap<String, IProductFactory> getFactoryMap() {
        return factoryMap;
    }
}
