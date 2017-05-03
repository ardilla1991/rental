package by.htp.rental.entity;

import java.util.ArrayList;

final public class Helmet extends Accessory{
	
	private MaterialEnum material;
	private int size;
	
	public Helmet(ArrayList<Integer> category, String model, double price, double weight, double width, double height, PersonCategoryEnum personCategory, MaterialEnum material, int size) {
		super(category, model, price, weight, width, height, personCategory);
		this.material = material;
		this.size = size;
	}

	/*public MaterialType getMaterial() {
		return material;
	}

	public void setMaterial(MaterialType material) {
		this.material = material;
	}*/

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Helmet [material=" + material + ", size=" + size + "]";
	}
	
	

}
