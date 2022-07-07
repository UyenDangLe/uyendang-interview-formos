package main.java.com.models;

/**
 * Report is the report on the amount of smoothies sold 
 * @author UyenDang
 *
 */
public class Report {
	
	private String smoothieName;
	private int number;
	private int price;
	
	public String getSmoothieName() {
		return smoothieName;
	}
	public void setSmoothieName(String smoothieName) {
		this.smoothieName = smoothieName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
