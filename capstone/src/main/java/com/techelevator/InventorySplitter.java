package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class InventorySplitter

{

    protected List <String> slotCode = new ArrayList<>();
    protected List <String> itemName = new ArrayList<>();
    protected List <Double> price = new ArrayList<>();
    protected List <String> itemType = new ArrayList<>();

    public void splitItems(List<String> listItems)
    {

        for (int i = 0; i < listItems.size(); i++)
        {
            if (i%4==0)
            {
                slotCode.add(listItems.get(i));
            }
            if ((i-1)%4==0)
            {
                itemName.add(listItems.get(i));
            }
            if ((i-2)%4==0)
            {
                price.add(Double.parseDouble(listItems.get(i)));
            }
            if ((i-3)%4==0)
            {
                itemType.add(listItems.get(i));

            }
        }

    }

}
