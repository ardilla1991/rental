package by.htp.rental.entity;

public class Bycicle extends MainEquipment{
	
	private String type; // for child or for adult 
	
	public Bycicle(String name, double price, double weight, double width, double height, String type) {
		super(name, price, weight, width, height);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
