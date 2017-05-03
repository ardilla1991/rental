package by.htp.rental.entity;

final public class Skate extends MainEquipment{

	public int size;
	
	public Skate() {
		
	}
	
	public Skate(String model, double price, double weight, double width, 
			double heigh, PersonCategoryEnum category, int termOfService, int size) {
		super(model, price, weight, width, heigh, category, termOfService);
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Skate[" + super.toString() + "size=" + size + "]";
	}

}
