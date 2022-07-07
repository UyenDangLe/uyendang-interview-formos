package main.java.com.models;

import main.java.com.enums.Measure;

public class Sugar extends Item{

	/**
	 * Initial method
	 * @param number of Sugar in stock
	 */
	public Sugar(float number) {
		super("Sugar", number, Measure.g);
		this.expectedRecipe = 24;
		this.expectedForPerSize = expectedRecipe;
	}
}
