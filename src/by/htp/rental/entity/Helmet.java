package by.htp.rental.entity;

public class Helmet extends Accessory{
	
	private String material;
	private int size;
	
	public Helmet(String name, double price, double weight, double width, double height, String material, int size) {
		super(name, price, weight, width, height);
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
