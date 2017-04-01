package by.htp.rental.entity;

public class Skate extends MainEquipment{
	
	public int size;
	
	public Skate(double price, double weight, double width, double heigh, String type, int size) {
		super(price, weight, width, heigh, type);
		this.size = size;
	}
}
