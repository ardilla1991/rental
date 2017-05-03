package by.htp.rental.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Accessory extends Equipment{

	private static final HashMap<Integer, String> CATEGORIES = new HashMap<Integer, String>(2);
	private ArrayList<Integer> category = new ArrayList<Integer>();
	
	static {
		CATEGORIES.put(1, "bycicle");
		CATEGORIES.put(2, "skate");
	}
	
	public Accessory() {
		
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
		for (Map.Entry<Integer,String> pair : entrySet) {
		    if (category.toLowerCase().equals(pair.getValue())) {
		        return pair.getKey();
		    }
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " category=" + category + ", ";
	}

}
