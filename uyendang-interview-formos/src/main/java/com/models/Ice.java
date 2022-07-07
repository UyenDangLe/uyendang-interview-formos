package main.java.com.models;

import main.java.com.enums.Measure;

/**
 * Ice class
 * @author UyenDang
 *
 */
public class Ice extends Item{

	/**
	 * Initial method
	 * @param number of Ice in stock
	 */
	public Ice(float number) {
		super("Ice", number, Measure.ml);
		this.expectedRecipe = 90;
		this.expectedForPerSize = expectedRecipe;
	}

}
