package by.htp.rental.entity;

final public class Bycicle extends MainEquipment{
	
	private int countSpeedMode;

	public Bycicle() {
		super();
	}
	
	public Bycicle(double price, double weight, double width, double height, CategoryEnum category, int countSpeedMode) {
		super(price, weight, width, height, category);
		this.countSpeedMode = countSpeedMode;
	}

	public int getCountSpeedMode() {
		return countSpeedMode;
	}

	public void setCountSpeedMode(int countSpeedMode) {
		this.countSpeedMode = countSpeedMode;
	}
}
