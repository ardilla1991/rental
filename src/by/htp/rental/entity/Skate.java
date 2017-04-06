package by.htp.rental.entity;

final public class Skate extends MainEquipment{
	
	public int size;
	
	public Skate(int id, double price, double weight, double width, double heigh, CategoryEq category, int size) {
		super(id, price, weight, width, heigh, category);
		this.size = size;
	}
}
