package by.htp.rental.builder;

import by.htp.rental.entity.Bycicle;

public class BycicleBuilder {
	
	public static void setProperties(Bycicle equipment, EquipmentTagName text, String s) {
		
		switch (text) {
			case TERM_OF_SERVICE:
				equipment.setTermOfService(Integer.parseInt(s));
				break;
			case COUNT_SPEED_MODE:
				equipment.setCountSpeedMode(Integer.parseInt(s));
				break;
		}
	}
}
