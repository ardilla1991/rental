package by.htp.rental.entity;

public abstract class MainEquipment extends Equipment{
	
	public MainEquipment() {
		super();
	}
	
	public MainEquipment(double price, double weight, double width, double height, CategoryEnum category) {
		super(price, weight, width, height, category);
	}
}
