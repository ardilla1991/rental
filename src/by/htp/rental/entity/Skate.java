package by.htp.rental.entity;

final public class Skate extends MainEquipment{
	
	public int size;
	
	public Skate() {
		
	}
	
	public Skate(double price, double weight, double width, double heigh, CategoryEnum category, int size) {
		super(price, weight, width, heigh, category);
		this.size = size;
	}
}
