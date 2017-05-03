package by.htp.rental.builder;

import java.util.ArrayList;

import by.htp.rental.entity.Accessory;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.MaterialEnum;

public class HelmetBuilder {

	public static void setProperties(Helmet equipment, EquipmentTagName text, String s) {
		switch (text) {
			case CATEGORY:
				ArrayList<Integer> categories = equipment.getCategory();
				int categoryId = Accessory.getCategoryId(s);
				if ( categoryId > 0 ) {
					categories.add(new Integer(categoryId));
					equipment.setCategory(categories);
				}
				break;
			case MATERIAL:
				equipment.setMaterial(MaterialEnum.valueOf(s.toUpperCase()));
				break;
			case SIZE:
				equipment.setSize(Integer.parseInt(s));
				break;
		}
	}
}
