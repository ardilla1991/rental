package by.htp.rental.entity;

import java.util.Date;

public class RentalManager {
	
	private RentStation rentStation;
	private RentUnit rentUnit;
	private static final int NUM_ALLOW_EQUIPMENT = 3;

	public RentalManager(RentStation rentStation) {
		this.rentStation = rentStation;
		this.rentUnit  = new RentUnit();
	}
	
	public boolean rent(Person person, Equipment equipment, int period) {
		if ( isEquipmentSpare(equipment) && !isExceededNumberOfEquipmentForUser(person) ){
			equipment.setLastRentDate(new Date());
			equipment.setLastRentPeriod(period);
			rentUnit.addEquipment(person, equipment);
			equipment.setSpare(false);
			return true;
		}
		return false;
	}
	
	private boolean isEquipmentSpare(Equipment equipment) {

		return equipment.getSpare();
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Person person) {
		if ( rentUnit.getEquipmentsOfPerson(person).length == NUM_ALLOW_EQUIPMENT ) {
			return true;
		}
		
		return false;
	}
	
}
