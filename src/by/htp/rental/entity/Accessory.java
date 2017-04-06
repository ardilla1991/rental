package by.htp.rental.entity;

public abstract class Accessory extends Equipment{

	public Accessory(int id, double price, double weight, double width, double height, CategoryEq category) {
		super(id, price, weight, width, height, category);
	}
}
