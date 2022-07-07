package main.java.com.models;

import main.java.com.enums.Measure;

public class Mango extends Item{
	/**
	 * Init method
	 * @param number is number of Mango in stock
	 */
	public Mango(float number) {
		super("Mango", number, Measure.g);
		this.expectedRecipe = 150;
		this.expectedForPerSize = (this.expectedRecipe * 140) / 100;
	}
}
