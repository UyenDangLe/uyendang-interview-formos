package main.java.com.models;

import main.java.com.enums.Measure;

/**
 * Banana class
 * @author UyenDang
 *
 */
public class Banana extends Item{
	
	/**
	 * Initial method
	 * @param number of Banana in stock
	 */
	public Banana(float number) {
		super("Banana", number, Measure.g);
		this.expectedRecipe = 150; 
		this.expectedForPerSize = (this.expectedRecipe * 120) / 100;		
	}
}
