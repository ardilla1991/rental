package by.htp.rental.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Accessory extends Equipment{

	private static final HashMap<Integer, String> CATEGORIES = new HashMap<Integer, String>(2);
	private ArrayList<Integer> category;
	
	static {
		CATEGORIES.put(1, "Bycicle");
		CATEGORIES.put(2, "Skate");
	}
	
	public Accessory(ArrayList<Integer> category, String model, double price, double weight, 
			double width, double height, PersonCategoryEnum personCategory) {
		super(model, price, weight, width, height, personCategory);
		this.category = category;
	}

	public ArrayList<Integer> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<Integer> category) {
		this.category = category;
	}
	
	public static int getCategoryId(String category) {
		Set<Map.Entry<Integer,String>> entrySet = CATEGORIES.entrySet();
		Object desiredObject = new Object();
		for (Map.Entry<Integer,String> pair : entrySet) {
		    if (desiredObject.equals(pair.getValue())) {
		        return pair.getKey();
		    }
		}
		
		return 0;
	}

}
