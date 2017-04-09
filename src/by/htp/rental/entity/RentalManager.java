package by.htp.rental.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class RentalManager {
	
	private RentStation rentStation;
	private OrderDB orderDB;
	private static final int NUM_ALLOW_EQUIPMENT = 3;

	public RentalManager(RentStation rentStation, OrderDB orderDB) {
		this.rentStation = rentStation;
		this.orderDB  = orderDB;
	}
	
	public boolean rent(Order order) {
		resetEquipments();
		if ( isSpareEquipment(order) && !isExceededNumberOfEquipmentForUser(order.getPerson()) ){
			// add order to person
			orderDB.addOrder(order);
			rentStation.setEngagedEquipments(rentStation.addEngagedRecord(rentStation.getEngagedEquipments(), order.getEquipmentId()));
			rentStation.setSpareEquipments(rentStation.deleteSpareRecord(rentStation.getSpareEquipments(), order.getEquipmentId()));
			return true;
		}
		return false;
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Person person) {
		if ( orderDB.getEquipmentsOfPerson(person).length == NUM_ALLOW_EQUIPMENT ) {
			return true;
		}
		
		return false;
	}
	
	private boolean isSpareEquipment(Order order){
		boolean isset = false;
		for (int i=0; i<rentStation.getSpareEquipments().length; i++) {
			if (rentStation.getSpareEquipments()[i] == order.getEquipmentId() ) {
				isset = true;
			}
		}
		
		return isset;
	}
	
	public void resetEquipments() {
		for (Order[] value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.length; i++){
				if ( value[i] != null && isEquipmentIsRentByDate(value[i])) {
					value[i] = null;
					rentStation.setEngagedEquipments(rentStation.deleteEngagedRecord(rentStation.getEngagedEquipments(), value[i].getEquipmentId()));
					rentStation.setSpareEquipments(rentStation.addSpareRecord(rentStation.getSpareEquipments(), value[i].getEquipmentId()));
				}
			}
		}
	}
	
	private boolean isEquipmentIsRentByDate(Order order) {
		return order.getRentDate().getTime() + order.getRentPeriod() * 60 * 60 < new Date().getTime();
	}
	
	public Equipment[] getRentedEquipmentsByTime(long from, long to) {
		for (Order[] value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.length; i++){
				if ( value[i] != null && value[i].getRentDate().getTime() >= from 
						&& value[i].getRentDate().getTime() <= to ) {
					System.out.println(value[i].getEquipmentId());
				}
			}
		}
		return new Equipment[0];
	}
	
}
