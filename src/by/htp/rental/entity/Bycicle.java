package by.htp.rental.entity;

public class Bycicle extends MainEquipment{
	
	private int countSpeedMode;

	public Bycicle(double price, double weight, double width, double height, String type, int countSpeedMode) {
		super(price, weight, width, height, type);
		this.countSpeedMode = countSpeedMode;
	}

	public int getCountSpeedMode() {
		return countSpeedMode;
	}

	public void setCountSpeedMode(int countSpeedMode) {
		this.countSpeedMode = countSpeedMode;
	}
}
