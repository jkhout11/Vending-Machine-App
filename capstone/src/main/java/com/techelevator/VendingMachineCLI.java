package com.techelevator;

import com.techelevator.view.Menu;

import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private int counter = 0;
	private Menu menu;
	private InventoryScanner invScan = new InventoryScanner();
	private InventorySplitter invSplit = new InventorySplitter();
	private InventoryQuantity invQuant = new InventoryQuantity();
	private Cashier cashier = new Cashier();


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		System.out.println("Welcome To Vendor Bot 3000 (TM)\n\n ____________________________________________\n" +
				"|############################################|\n" +
				"|#|                           |##############|\n" +
				"|#|  =====  ..--''`  |~~``|   |##|````````|##|\n" +
				"|#|  |   |  \\     |  :    |   |##| Exact  |##|\n" +
				"|#|  |___|   /___ |  | ___|   |##| Change |##|\n" +
				"|#|  /=__\\  ./.__\\   |/,__\\   |##| Only   |##|\n" +
				"|#|  \\__//   \\__//    \\__//   |##|________|##|\n" +
				"|#|===========================|##############|\n" +
				"|#|```````````````````````````|##############|\n" +
				"|#| =.._      +++     //////  |##############|\n" +
				"|#| \\/  \\     | |     \\    \\  |#|`````````|##|\n" +
				"|#|  \\___\\    |_|     /___ /  |#| _______ |##|\n" +
				"|#|  / __\\\\  /|_|\\   // __\\   |#| |1|2|3| |##|\n" +
				"|#|  \\__//-  \\|_//   -\\__//   |#| |4|5|6| |##|\n" +
				"|#|===========================|#| |7|8|9| |##|\n" +
				"|#|```````````````````````````|#| ``````` |##|\n" +
				"|#| ..--    ______   .--._.   |#|[=======]|##|\n" +
				"|#| \\   \\   |    |   |    |   |#|  _   _  |##|\n" +
				"|#|  \\___\\  : ___:   | ___|   |#| ||| ( ) |##|\n" +
				"|#|  / __\\  |/ __\\   // __\\   |#| |||  `  |##|\n" +
				"|#|  \\__//   \\__//  /_\\__//   |#|  ~      |##|\n" +
				"|#|===========================|#|_________|##|\n" +
				"|#|```````````````````````````|##############|\n" +
				"|############################################|\n" +
				"|#|||||||||||||||||||||||||||||####```````###|\n" +
				"|#||||||||||||PUSH|||||||||||||####\\|||||/###|\n" +
				"|############################################|\n" +
				"\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////////\n" +
				" |______________________________|VB3000|___|\n\n\nPlease select from the options below.");

		//invQuant.resetItemQuantities();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				counter++;
				cashier.run();

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for choosing VendorBot 3000\n __     __             _              ____        _     _____  ___   ___   ___                      \n" +
						" \\ \\   / /__ _ __   __| | ___  _ __  | __ )  ___ | |_  |___ / / _ \\ / _ \\ / _ \\                     \n" +
						"  \\ \\ / / _ \\ '_ \\ / _` |/ _ \\| '__| |  _ \\ / _ \\| __|   |_ \\| | | | | | | | | |                    \n" +
						"   \\ V /  __/ | | | (_| | (_) | |    | |_) | (_) | |_   ___) | |_| | |_| | |_| |                    \n" +
						"  _ \\_/ \\___|_| |_|\\__,_|\\___/|_|    |____/ \\___/ \\__| |____/ \\___/ \\___/ \\___/  _                  \n" +
						" | |__  _   _     / \\   _ __ | |_ ___  _ __ (_) ___   | \\ | | __ _ ______ _ _ __(_) ___             \n" +
						" | '_ \\| | | |   / _ \\ | '_ \\| __/ _ \\| '_ \\| |/ _ \\  |  \\| |/ _` |_  / _` | '__| |/ _ \\            \n" +
						" | |_) | |_| |  / ___ \\| | | | || (_) | | | | | (_) | | |\\  | (_| |/ / (_| | |  | | (_) |           \n" +
						" |_.__/ \\__, | /_/   \\_\\_| |_|\\__\\___/|_| |_|_|\\___/  |_| \\_|\\__,_/___\\__,_|_|  |_|\\___/            \n" +
						"   ___  |___/  _                        _  ___                 _                              _     \n" +
						"  ( _ )       | | ___ _ __ _ __ _   _  | |/ / |__   ___  _   _| |_ ___  __ ___   ____ _ _ __ | |__  \n" +
						"  / _ \\/\\  _  | |/ _ \\ '__| '__| | | | | ' /| '_ \\ / _ \\| | | | __/ __|/ _` \\ \\ / / _` | '_ \\| '_ \\ \n" +
						" | (_>  < | |_| |  __/ |  | |  | |_| | | . \\| | | | (_) | |_| | |_\\__ \\ (_| |\\ V / (_| | | | | | | |\n" +
						"  \\___/\\/  \\___/ \\___|_|  |_|   \\__, | |_|\\_\\_| |_|\\___/ \\__,_|\\__|___/\\__,_| \\_/ \\__,_|_| |_|_| |_|\n" +
						"                                |___/     \n\n");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void displayItems() {
		List<String> arrayItems = invScan.getItems();
		invSplit.splitItems(arrayItems);
		System.out.println("\n\nThe following items are available\n");


		List<Integer> itemQuantities = invQuant.getItemQuant();

		for (int i = 0; i < 16; i++)
		{
			if (itemQuantities.get(i) > 0)
			{
				System.out.println(itemQuantities.get(i) + "ct. of " + invSplit.itemName.get(i) + " for $" + invSplit.price.get(i));
			} else
			{
				System.out.println("Sorry! We are all out of stock of " + invSplit.itemName.get(i));
			}
			counter++;
		}

		}
	}

