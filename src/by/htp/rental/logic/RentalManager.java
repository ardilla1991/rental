package by.htp.rental.logic;

import java.util.ArrayList;
import java.util.Date;

import by.htp.rental.entity.Accessory;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.MainEquipment;
import by.htp.rental.entity.Order;
import by.htp.rental.entity.Person;

public class RentalManager {
	
	private RentStation rentStation;
	private OrderDB orderDB;
	private static final int NUM_ALLOW_EQUIPMENT = 3;

	public RentalManager(RentStation rentStation, OrderDB orderDB) {
		this.rentStation = rentStation;
		this.orderDB  = orderDB;
	}
	
	public boolean rent(Order order) {
		if ( isExceededNumberOfEquipmentForUser(order) )
				return false;

		orderDB.addOrder(order); // add order to person
		rentStation.addEngagedEquipment(order.getEquipment());
		rentStation.deleteSpareEquipment(order.getEquipment());
		
		return true;
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Order order) {
		if ( order.getEquipment() instanceof Accessory ) {
			return false;
		}
		
		if ( countRentedMainEquipmentByUser(order.getPerson()) == NUM_ALLOW_EQUIPMENT ) {
			return true;
		}
		
		return false;
	}
	
	private int countRentedMainEquipmentByUser(Person person) {
		ArrayList<Order> orders = orderDB.getEquipmentsOfPerson(person);
		int counter = 0;
		for (Order order : orders ){
			if ( order.getEquipment() instanceof MainEquipment ) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public void resetEquipments() {
		for (ArrayList<Order> value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && isEquipmentIsRentByDate(value.get(i))) {
					rentStation.deleteEngagedEquipment(value.get(i).getEquipment());
					rentStation.addSpareEquipment(value.get(i).getEquipment());
					value.remove(i);	
				}
			}
		}
	}
	
	private boolean isEquipmentIsRentByDate(Order order) {
		return order.getRentDate().getTime() + order.getRentPeriod() * 60 * 60 < new Date().getTime();
	}
	
	public ArrayList<Equipment> getRentedEquipmentsByTime(long from, long to) {
		ArrayList<Equipment> eq = new ArrayList<Equipment>();
		for (ArrayList<Order> value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && value.get(i).getRentDate().getTime() >= from 
						&& value.get(i).getRentDate().getTime() <= to ) {
					System.out.println(value.get(i).getEquipment());
					eq.add(value.get(i).getEquipment());
				}
			}
		}
		return eq;
	}
	
}
