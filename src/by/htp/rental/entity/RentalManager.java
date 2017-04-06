package by.htp.rental.entity;

import java.util.Arrays;
import java.util.Date;

public class RentalManager {
	
	private RentStation rentStation;
	private OrderDB orderDB;
	private static final int NUM_ALLOW_EQUIPMENT = 3;

	public RentalManager(RentStation rentStation, OrderDB orderDB) {
		this.rentStation = rentStation;
		this.orderDB  = orderDB;
	}
	
	public boolean rent(Order order) {
		if ( isSpareEquipment(order) && !isExceededNumberOfEquipmentForUser(order.getPerson()) ){
			// add order to person
			orderDB.addOrder(order);
			rentStation.addSpareRecord(rentStation.engagedEquipments, order.getEquipmentId());
			return true;
		}
		return false;
	}
	
	private boolean isEquipmentSpare(Equipment equipment) {

		//return equipment.getSpare();
		return true;
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Person person) {
		if ( orderDB.getEquipmentsOfPerson(person).length == NUM_ALLOW_EQUIPMENT ) {
			return true;
		}
		
		return false;
	}
	
	private boolean isSpareEquipment(Order order){
		return Arrays.asList(rentStation.getSpareEquipments()).contains( order.getEquipmentId() );
	}
	
}
