package main.java.com.models;

import main.java.com.enums.Measure;

public class Milk extends Item{
	/**
	 * Init method
	 * @param number is number of Milk in stock
	 */
	public Milk(float inStock) {
		super("Milk", inStock, Measure.ml);
		this.expectedRecipe = 60;
		this.expectedForPerSize = expectedRecipe;
	}
}
