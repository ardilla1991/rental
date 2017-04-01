package by.htp.rental.entity;

public class Skate extends MainEquipment{
	
	public int size;
	
	public Skate(String name, double price, double weight, double width, double heigh, int size) {
		super(name, price, weight, width, heigh);
		this.size = size;
	}
}
