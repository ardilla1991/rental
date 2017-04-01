package by.htp.rental.entity;

public class Helmet extends Accessory{
	
	private String material;
	private int size;
	
	public Helmet(double price, double weight, double width, double height, String type, String material, int size) {
		super(price, weight, width, height, type);
		this.material = material;
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
