package com.techelevator;

//it manages the inventory of VM-800. methods includes inventory, get a product by slot code, stock products, check availability of product.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryScanner {

    private final String filename = "vendingmachine.csv";

   /* private String[] parts;*/
    public List <String> getItems() {
        String fileName = filename;
        List <String> txtFile = new ArrayList<>();
        String[] txtLine = new String[0];
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            // Split and process each line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                txtLine = line.split("\\|");
                txtFile.add(txtLine[0]);
                txtFile.add(txtLine[1]);
                txtFile.add(txtLine[2]);
                txtFile.add(txtLine[3]);


                /*for (String part : txtLine) {
                    System.out.println(part);
                }*/
            }
            scanner.close();

        } catch (FileNotFoundException ex) {
            System.out.println("You Got An Error!!" + ex.getMessage());
        }
        /*return inventory;*/

        return txtFile;
    }
    }
