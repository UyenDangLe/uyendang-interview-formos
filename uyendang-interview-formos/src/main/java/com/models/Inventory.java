package main.java.com.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import main.java.com.enums.Type;

/**
 * Inventory contains ingredients of store
 * @author UyenDang
 *
 */
public class Inventory {
	
	private List<Item> items = new ArrayList<>();// items are ingredients of store in inventory
	private String[] ingredients = {"Banana", "Mango", "Strawberry", "Banana & Mango", "Mango & Strawberry", "Strawberry & Banana"};//Smoothies list of store
	
	/**
	 * Initial method
	 */
	public void initInventory() {
		items = new ArrayList<>();
		items.add(new Banana(getRandomNumber()));
		items.add(new Mango(getRandomNumber()));
		items.add(new Strawberry(getRandomNumber()));
		items.add(new Milk(getRandomNumber()));
		items.add(new Sugar(getRandomNumber()));
		items.add(new Ice(getRandomNumber()));
	}
	
	/**
	 * show all information items in inventory
	 */
	public void viewItems() {
		if(items.isEmpty()) {
			System.out.println("Stock is empty. Please refill inventory.");
		}else {
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("Items of the store as below:");
			items.forEach(item ->item.viewItem());
		}
	}
	
	/**
	 * Show all smoothies of store
	 */
	public void viewMenu() {
		System.out.println("\n---------------------------------------------------------------------------------");
		if(items.isEmpty()) {
			System.out.println("Sorry, out of stock.");
		}else {
			System.out.println("1. Banana Smoothie");
			System.out.println("2. Mango Smoothie");
			System.out.println("3. Strawberry Smoothie");
			System.out.println("0. Exit");			
			System.out.println("Please choose your smoothie: ");
		}		
	}
	
	/**
	 * check all ingredients are enough or not
	 * @param typeSmoothie
	 * @param total
	 * @param type
	 * @return true if ingredients is enough else false
	 */
	public boolean isAvailableSmoothie(int typeSmoothie, int total, Type type) {
		String nameSmoothie = ingredients[typeSmoothie-1];
		List<String> names = Type.MIX.equals(type) ? Arrays.stream(nameSmoothie.split("&")).collect(Collectors.toList()) : Arrays.asList(nameSmoothie);		
		for(String name : names) {
			for(Item item : items) {
				if(name.trim().equals(item.getName()) || "Milk".equals(item.getName()) || "Ice".equals(item.getName()) || "Sugar".equals(item.getName())) {
					if(!item.isAvailable(total, type)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * update number of items in inventory
	 * @param type
	 * @param typeSmoothie
	 * @param total
	 */
	public void updateNumberOfItems(Type type, int typeSmoothie, int total) {		 
		 String nameSmoothie = ingredients [typeSmoothie-1];
		 for (Item item : this.items) {
			if(nameSmoothie.equals(item.getName()) || "Milk".equals(item.getName()) || "Ice".equals(item.getName()) || "Sugar".equals(item.getName())) {
				item.updateNumber(total, type);
			}
	    }		
	}
	
	/**
	 * checking whether ingredients are enough number expected or not
	 * @param indexName
	 * @param total
	 * @param type
	 */
	public void checkIngredientsBelowNumber(int indexName, int total, Type type) {
		System.out.println("\n---------------------------------------------------------------------------------");		
		if(indexName > 0) {// only check one smoothie type
			String nameSmoothie = ingredients [indexName-1];
			for (Item item : this.items) {
				if(nameSmoothie.trim().equals(item.getName()) || "Milk".equals(item.getName()) || "Ice".equals(item.getName()) || "Sugar".equals(item.getName()) && !item.isAvailable(total, type)) {					
					float numberMissing = item.number - (item.expectedForPerSize * total);
					if(numberMissing < 0) {
						System.out.format("\nWARNING:" + item.getName() + " is not enough to sell " + total + " size. Current number: %.3f" 
								+ item.measure + " & miss: %.3f" + item.measure + "%n", item.number, Math.abs(numberMissing));
					}							
				}
		    }
		}else {// check all items in inventory
			for (Item item : this.items) {
				if(!item.isAvailable(total, type)) {
					float numberMissing = (item.expectedForPerSize * total) - item.number;
					System.out.format("\nWARNING:" + item.getName() + " is not enough to sell " + total + " size. Current number: %.3f" 
					+ item.measure + " & miss: %.3f" + item.measure + "%n", item.number, numberMissing);
				}
		    }
		}
	}
	
	/**
	 * get items in inventory
	 * @return list of item in inventory
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	/**
	 * set value to list items in inventory
	 * @param items are ingredients
	 */
	public void setItems(List<Item> items) {
		this.items.clear();
        if (items != null) {
            this.items.addAll(items);
        }
	}
	
	/**
	 * get random integer number
	 * @return integer number
	 */
	private int getRandomNumber() {
		int min = 24, max = 1000;
	    return (int) ((Math.random() * (max - min)) + min);
	}
}
