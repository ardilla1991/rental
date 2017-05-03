package by.htp.rental.logic;

import java.util.Arrays;
import java.util.HashMap;

import by.htp.rental.entity.Equipment;

public class Search {
	///// find equipment by param
	public static HashMap<Integer, Equipment> findEquipmentByParams(RentStation rentStation, double price) {
		HashMap<Integer, Equipment> eq = new HashMap<>();
		for ( HashMap.Entry<Integer, Equipment> entry : rentStation.getEquipments().entrySet()) {
			if ( entry.getValue().getPrice() < price && !Arrays.asList(rentStation.getSpareEquipments()).contains(entry.getValue().getId()) ) {
				eq.put(entry.getKey(), entry.getValue());
			}
		}

		return eq;
	}
	
	public static Equipment findSpareEquipmentByType(RentStation rentStation, String type) 
			throws ClassNotFoundException {
		for ( HashMap.Entry<Integer, Equipment> entry : rentStation.getSpareEquipments().entrySet()) {
			if ( Class.forName("by.htp.rental.entity."+type).isInstance(entry.getValue())) {
				return entry.getValue();
			}
		}
		return null;
	}
}
