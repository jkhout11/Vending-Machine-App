package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class InventoryQuantity {

    private List<Integer> itemQuant = new ArrayList<>();

    public void resetItemQuantities() {
        // Clear the itemQuant list to reset the quantities
        itemQuant.clear();


    }

    public List<Integer> getItemQuant() {
        // Call resetItemQuantities() to ensure the list is properly starting
        // Set initial amount of each item to 5, This should only reset when the application is closed and reopens

        for (int i = 0; i < 16; i++) {
            itemQuant.add(5);
        }
        return itemQuant;
    }
}
