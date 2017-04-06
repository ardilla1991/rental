package by.htp.rental.entity;

import java.util.Date;

public abstract class Equipment {
	
	private int id;
	private double price;
	private double weight;
	private double width;
	private double height;
	private CategoryEq category; // for child or for adult 
	private Date lastRentDate;
	private int lastRentPeriod;

	public Equipment(int id, double price, double weight, double width, double height, CategoryEq category) {
		this.id = id;
		this.price = price;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getLastRentPeriod() {
		return lastRentPeriod;
	}

	public void setLastRentPeriod(int lastRentPeriod) {
		this.lastRentPeriod = lastRentPeriod;
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

	@Override
	public String toString() {
		return "Equipment [price=" + price + ", weight=" + weight + ", width=" + width + ", height=" + height
				+ ", category=" + category + "]\n";
	}
	
	public Date getLastRentDate() {
		return lastRentDate;
	}

	public void setLastRentDate(Date lastRentDate) {
		this.lastRentDate = lastRentDate;
	}
}
