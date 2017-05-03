package by.htp.rental.entity;

public abstract class Accessory extends Equipment{

	public Accessory(double price, double weight, double width, double height, CategoryEnum category) {
		super(price, weight, width, height, category);
	}
}
