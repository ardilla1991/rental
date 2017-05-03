package by.htp.rental.entity;

final public class Bycicle extends MainEquipment{
	
	private int countSpeedMode;

	public Bycicle() {
		super();
	}
	
	public Bycicle(String model, double price, double weight, double width, double height, 
			PersonCategoryEnum category, int termOfService, int countSpeedMode) {
		super(model, price, weight, width, height, category, termOfService);
		this.countSpeedMode = countSpeedMode;
	}

	public int getCountSpeedMode() {
		return countSpeedMode;
	}

	public void setCountSpeedMode(int countSpeedMode) {
		this.countSpeedMode = countSpeedMode;
	}

	@Override
	public String toString() {
		return "Bycicle[" + super.toString() + "countSpeedMode=" + countSpeedMode + "]";
	}
}
