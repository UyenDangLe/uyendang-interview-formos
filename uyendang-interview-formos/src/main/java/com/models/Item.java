package main.java.com.models;

import main.java.com.enums.Measure;
import main.java.com.enums.Type;

/**
 * Item is an ingredient in smoothie
 * @author UyenDang 
 *  
 */
public abstract class Item {
	
	public String name;
	public float number;
	public int expectedRecipe; // expected number of item for per size based on recipe
	public float expectedForPerSize;// expected number of item for per size	depend on type
	public Measure measure;
	
	/**
	 * Initial method
	 * @param name is name of ingredient that will be initiated
	 * @param number is quantity of object in stock 
	 * @param measure is unit of object
	 */
	public Item(String name, float number, Measure measure) {
		this.name = name;
		this.number = number;
		this.measure = measure;
	}
	
	/**
	 * View information of item
	 */
	public void viewItem() {
		System.out.format("\t\t\t\tName: %s, in-stock: %.3f%s%n", name, number, measure);
	}
	
	/**
	 * This method is used to check quantity is enough to make smoothie 
	 * @param total
	 * @param type
	 * @return
	 */
	public boolean isAvailable(int total, Type type) {
		//check type smoothie
		if(Type.NORMAL.equals(type)) {
			return number >= (expectedForPerSize * total);
		}else {//MIX
			return number >= ((expectedForPerSize/2)* total);
		}
	}
	
	/**
	 * get name of item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * update number of item in stock
	 * @param total
	 * @param type
	 */
	public void updateNumber(int total, Type type) {
		if(Type.NORMAL.equals(type)) {
			this.number = number - (expectedForPerSize * total);
		}else {//MIX
			this.number = number - ((expectedForPerSize/2)* total);
		}
	}
	
	/**
	 * set number of item in stock
	 * @param number
	 */
	public void setNumber(float number) {
		this.number = number;
	}
}
