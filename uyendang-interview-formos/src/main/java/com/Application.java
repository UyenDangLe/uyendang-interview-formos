package main.java.com;

import java.io.InputStream;
import java.util.Scanner;

import main.java.com.enums.Type;
import main.java.com.models.Inventory;

/**
 * @author UyenDang
 *
 */
public class Application {
	
	public static void main(String[] args) {
		
		Inventory inventory = new Inventory();
		inventory.initInventory();
        int input = -1;
        while (input != 0) {// check invalid input value from user
        	startProgram();
        	input = scanInput();
	        switch(input) {
		        case 0:
		            break;
		        case 1:
		        	inventory.viewItems();
		        	break;
		        case 2:	
		        	sellSmoothies(inventory);
		        	break;
		        case 3:	
		        	checkFourMoreSmothies(0, inventory);
		        	break;
		        case 4:
		        	System.out.println("\n---------------------------------------------------------------------------------");
		        	System.out.println("Coming soon!");
		        	break;
		        default:
		            System.out.println("Please choose again!");
	        } 
        }
	}

	/**
	 * This method run first and output menu of program
	 */
	public static void startProgram() {
		System.out.println("\n=================================================================================");
		System.out.println("WELLCOME TO SMOOTHIE STORE MANAGE SOFTWARE");
		System.out.println("1. List Status Of Ingredients In Inventory");
		System.out.println("2. Sell Smoothies");
		System.out.println("3. Check Ingredients To Make 4 More Smoothies");
		System.out.println("4. View Report");
		System.out.println("0. Exit");
		System.out.println("Please choose: ");
	}
	
	/**
	 * scan input value from user
	 * @return number that user input else -1 is incorrect format input
	 */
	private static int scanInput() {
	 	InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        try {
            return Integer.parseInt(scanner.next());
        } catch (Exception ignore) {
        }
        return -1;
	}
	
	/**
	 * sellSmoothies method check conditions and output a message to the vendor if ingredients are enough to sell and else
	 * @param inventory
	 */
	private static void sellSmoothies(Inventory inventory) {
		inventory.viewMenu();
		int input = scanInput();		
		input = validateInputSmoothie(input, false);
		System.out.println("Please input total you want: ");
		int total = scanInput();
		total = validateInputSmoothie(total, true);
		if(total > 0) {// check number of smoothie will be sell	
			Type type = (input > 0 && input < 4) ? Type.NORMAL : Type.MIX;
			boolean isAvailable = inventory.isAvailableSmoothie(input, total, type);
			if(!isAvailable) {//smoothie is not enough to sell
				System.out.println("WARNING: Ingredients are not enough to sale.");
				inventory.checkIngredientsBelowNumber(input, total, type);
			}else {
				System.out.println("INFO: Ingredients are enough to sale.");
				inventory.updateNumberOfItems(type, input, total);					
				inventory.viewItems();
			}
			if(total == 4) {// check ingredients for 4 size
				checkFourMoreSmothies(input, inventory);
			}
		}
	}
	
	/**
	 * check input value valid or not
	 * @param input is value user input
	 * @param totalFlag is true when the input value is the total size that will sell and else
	 * @return
	 */
	private static int validateInputSmoothie(int input, boolean totalFlag) {		
		while((input < 0 && totalFlag) || (!totalFlag && (input > 3 || input <= 0))){
			System.out.println(totalFlag ? "Please input total you want: " : "Please choose your smoothie: ");
			input = scanInput();
		}	
		return input;
	}
	
	/**
	 * check 4 size
	 * @param input is input value from user
	 * @param inventory is inventory of store
	 */
	private static void checkFourMoreSmothies(int input, Inventory inventory) {
		inventory.checkIngredientsBelowNumber(input, 4, Type.NORMAL);
	}
}