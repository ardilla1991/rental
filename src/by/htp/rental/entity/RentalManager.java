package by.htp.rental.entity;

import java.util.ArrayList;
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
		if ( isExceededNumberOfEquipmentForUser(order.getPerson()) )
				return false;

		orderDB.addOrder(order); // add order to person
		rentStation.addEngagedRecord(order.getEquipment());
		rentStation.deleteSpareRecord(order.getEquipment());
		
		return true;
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Person person) {
		if ( orderDB.getEquipmentsOfPerson(person).size() == NUM_ALLOW_EQUIPMENT ) {
			return true;
		}
		
		return false;
	}
	
	public void resetEquipments() {
		for (ArrayList<Order> value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && isEquipmentIsRentByDate(value.get(i))) {
					value.remove(i);
					rentStation.deleteEngagedRecord(value.get(i).getEquipment());
					rentStation.addSpareRecord(value.get(i).getEquipment());
				}
			}
		}
	}
	
	private boolean isEquipmentIsRentByDate(Order order) {
		return order.getRentDate().getTime() + order.getRentPeriod() * 60 * 60 < new Date().getTime();
	}
	
	public ArrayList<Order> getRentedEquipmentsByTime(long from, long to) {
		for (ArrayList<Order> value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && value.get(i).getRentDate().getTime() >= from 
						&& value.get(i).getRentDate().getTime() <= to ) {
					System.out.println(value.get(i).getEquipment());
				}
			}
		}
		return new ArrayList<>(0);
	}
	
}
