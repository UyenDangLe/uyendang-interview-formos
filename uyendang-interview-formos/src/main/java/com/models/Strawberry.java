package main.java.com.models;

import main.java.com.enums.Measure;

public class Strawberry extends Item{
	/**
	 * Initial method
	 * @param number of Strawberry in stock
	 */
	public Strawberry(float number) {
		super("Strawberry", number, Measure.g);
		this.expectedRecipe = 150;
		this.expectedForPerSize = (this.expectedRecipe * 100) / 100;
	}
}
