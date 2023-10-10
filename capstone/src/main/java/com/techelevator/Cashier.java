package com.techelevator;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.techelevator.TransactionLog;

public class Cashier {
    private InventoryScanner invScan = new InventoryScanner();
    private InventorySplitter invSplit = new InventorySplitter();
    private InventoryQuantity invQuant = new InventoryQuantity();
    private Double balance = 0.00;
    private final Scanner userInput = new Scanner(System.in);
    private final TransactionLog logTrans = new TransactionLog();
    private int checkIndex = -1; // Member variable to store the selected item index

    DecimalFormat cents = new DecimalFormat("#.00"); // This should round the balance and change variables to always have two digits after the decimal

    public void run() {
        invQuant.resetItemQuantities();
        List<Integer> itemQuantities = invQuant.getItemQuant();
        List<String> arrayItems = invScan.getItems();
        invSplit.splitItems(arrayItems);

        System.out.println("\nCurrent Money Provided: $" + cents.format(balance));
        int purchaseChoice = 0;
        while (purchaseChoice != 3) {
            System.out.println("\n(1) Feed Money\n(2) Select Product\n(3) Finish Transaction\n");
//            purchaseChoice = userInput.nextInt();
//            userInput.nextLine();

            while (true) {
                if (userInput.hasNextInt()) {
                    purchaseChoice = userInput.nextInt();
                    break;
                } else {
                    System.out.print("Invalid input. Please enter an integer: \n");
                    userInput.nextLine();
                }
            }


            switch (purchaseChoice) {
                case 1:
                    addMoney();
                    break;
                case 2:
                    selectProduct(itemQuantities);
                    break;
                case 3:
                    finishTransaction();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    int checkInput;
    private void addMoney() {
        System.out.println("\nPlease enter single bills into money slot\n\nThis machine only accepts $1s, $5s, $10s, and $20s\n");

        checkInput = userInput.nextInt();

        while (checkInput != 1 && checkInput != 5 && checkInput != 10 && checkInput != 20) {
            System.out.println("\nPlease try again.\n\nThis machine only accepts $1s, $5s, $10s, and $20s\n");
            checkInput = userInput.nextInt();
        }

        String toBalance = checkInput + ".00";
        balance += Double.parseDouble(toBalance);

        System.out.println("\nYour Current Balance is $" + cents.format(balance));
    }

    protected List<Integer> selectProduct(List<Integer> itemQuantities) {
        System.out.println("The following items are available\n");
        for (int i = 0; i < 16; i++)
        {
            if (itemQuantities.get(i) > 0) {
                System.out.println("Code: |" + invSplit.slotCode.get(i) + "|  " + invSplit.itemName.get(i) + " ($" + cents.format(invSplit.price.get(i)) + ") " + "Quantity: " + itemQuantities.get(i));
            } else
            {
                System.out.println("Sorry! We are all out of stock of " + invSplit.itemName.get(i) + " " + invSplit.itemType.get(i));
            }
        }
        String userCode;
        checkIndex = -1;
        while (checkIndex < 0) {
            System.out.println("\nPlease enter the code for the item you wish to purchase\n");
            userInput.nextLine();
            userCode = userInput.nextLine().toUpperCase();
            //userCode = userCode; // Convert user input to uppercase
            int balanceCheck = invSplit.slotCode.indexOf(userCode);

            for (int i = 0; i < invSplit.slotCode.size(); i++)
            {
                if (invSplit.slotCode.get(i).equalsIgnoreCase(userCode))
                { // Case-insensitive comparison
                    checkIndex = i;
                    if (balance < invSplit.price.get(balanceCheck))
                    {
                        System.out.println("\nYou must add more money to your balance!!!!\n\n");
                        this.addMoney();
                        break;
                    }
                    if (itemQuantities.get(checkIndex) < 1)
                    {
                        System.out.println("\nSorry! We are all out of stock of " + invSplit.itemName.get(checkIndex) + " " + invSplit.itemType.get(checkIndex) + "\nPlease Try Again\n\n");

                        break;
                    }
                    else
                    {
                        balance -= invSplit.price.get(checkIndex);
                        int takeAwayOne = itemQuantities.get(checkIndex) - 1;
                        itemQuantities.set(checkIndex, takeAwayOne);

                        System.out.println("\n\nYou have just purchased 1 " + invSplit.itemName.get(checkIndex) + "\n\n");
                        logTrans.writeLog(invSplit.itemName.get(checkIndex), invSplit.price.get(checkIndex), balance);
                    }
                    if (invSplit.itemType.get(checkIndex).equals("Chip"))
                    {
                        System.out.println("Crunch Crunch, Yum!\n\n");
                    }
                    if (invSplit.itemType.get(checkIndex).equals("Candy"))
                    {
                        System.out.println("Munch Munch, Yum!\n\n");
                    }
                    if (invSplit.itemType.get(checkIndex).equals("Drink"))
                    {
                        System.out.println("Glug Glug, Yum!\n\n");
                    }
                    if (invSplit.itemType.get(checkIndex).equals("Gum"))
                    {
                        System.out.println("Chew Chew, Yum!\n\n");
                    }

                    System.out.println("Your remaining balance is: $" + cents.format(balance));

                    break;

                }
            }

            if (checkIndex == -1)
            {
                System.out.println("Invalid item code. Please try again.");
            }

        }



        /*
        balance -= invSplit.price.get(checkIndex);
        int takeAwayOne = itemQuantities.get(checkIndex) - 1;
        itemQuantities.set(checkIndex, takeAwayOne);

        System.out.println("You have just purchased 1 " + invSplit.itemName.get(checkIndex) + "\n\n");
        logTrans.writeLog(invSplit.itemName.get(checkIndex), invSplit.price.get(checkIndex), balance);
        */

        return itemQuantities;

    }


    private void finishTransaction()
    {

        System.out.println("Your change is $" + cents.format(balance) + "\n");

        double change = balance; // Calculate change without subtracting the price

        int quarters = (int) (change / 0.25);
        change %= 0.25;

        int dimes = (int) (change / 0.10);
        change %= 0.10;

        int nickels = (int) (change / 0.05);

        balance = 0.00;

        System.out.println("\nYour change is: ");
        System.out.println(quarters + " quarters");
        System.out.println(dimes + " dimes");
        System.out.println(nickels + " nickels");

        //this writes a log of the change given then exits the program
        logTrans.writeEndTrans(quarters, dimes, nickels, change);
        System.out.println("\nThank you for using Vendor Bot 3000(TM)!\n");

        /*List<Integer> remainingQuantity = quantityAfterTrans;
        return remainingQuantity;*/
    }

}