package by.htp.rental.entity;

import java.util.Date;

public abstract class Equipment {
	
	private double price;
	private double weight;
	private double width;
	private double height;
	private boolean spare; // is spare for rental (true or false)
	private CategoryEq category; // for child or for adult 
	private Date lastRentDate;
	private int lastRentPeriod;

	public int getLastRentPeriod() {
		return lastRentPeriod;
	}

	public void setLastRentPeriod(int lastRentPeriod) {
		this.lastRentPeriod = lastRentPeriod;
	}

	public Equipment(double price, double weight, double width, double height, CategoryEq category) {
		this.price = price;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.category = category;
		setSpare(true);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean getSpare() {
		return spare;
	}

	@Override
	public String toString() {
		return "Equipment [price=" + price + ", weight=" + weight + ", width=" + width + ", height=" + height
				+ ", spare=" + spare + ", category=" + category + "]\n";
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}
	
	public Date getLastRentDate() {
		return lastRentDate;
	}

	public void setLastRentDate(Date lastRentDate) {
		this.lastRentDate = lastRentDate;
	}
}
