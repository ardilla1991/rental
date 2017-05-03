package by.htp.rental.builder;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.Skate;

public class EquipmentsManager {
	
	public static Equipment createEquipment(String name) {
		switch ( name ) {
			case "bycicle":
				return new Bycicle();
			case "skate":
				return new Skate();
			case "helmet":
				return new Helmet();
		}
		
		return null;
	}
	
	public static Equipment setObjectProperties(Equipment equipment, EquipmentTagName text, String s) {
		if ( equipment instanceof Bycicle ) {
			Bycicle bycicle = (Bycicle) equipment;
			BycicleBuilder.setProperties(bycicle, text, s);
		} else if ( equipment instanceof Skate ) {
			Skate skate = (Skate) equipment;
			SkateBuilder.setProperties(skate, text, s);
		} else if ( equipment instanceof Helmet ) {
			Helmet helmet = (Helmet) equipment;
			HelmetBuilder.setProperties(helmet, text, s);
		}
		
		return equipment;
	}
}
