package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.parseInt(userInput);
			if (selectedOption >= 1 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			} /*else if (selectedOption == 0) {
				choice = MAIN_MENU_OPTION_EXIT; // This is the "Exit" option Edit: Antonio noticed that the menu test requires option 0 to re display menu items. it seems that since the 'MAIN_MENU_OPTION_EXIT' string within vendingmachineCLI file is at index 2 (selected option 3) it already works with the code inputted within that class
			}*/
		} catch (NumberFormatException e) {
			// sat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println("(" + optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Choose an option below\n\n>>>");
		out.flush();
	}
}