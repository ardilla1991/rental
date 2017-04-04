package by.htp.rental.entity;

import java.util.HashMap;
import java.util.Map;

public class RentUnit {
	
	//private Equipment[][] units;
	Map <Integer, Equipment[]> units = new HashMap<>();
	
	public RentUnit() {
		super();
	}
	
	public void addEquipment(Person person, Equipment equipment) {
		//[person.hashCode()] = addUnitsRecord(units[person.hashCode()], equipment);
		if ( units.containsKey(person.hashCode()) && units.get(person.hashCode()).length > 0  ) {
			units.put(person.hashCode(), addUnitsRecord(units.get(person.hashCode()), equipment));
		} else {
			Equipment[] eq = new Equipment[3];
			units.put(person.hashCode(), addUnitsRecord(eq, equipment));
		}
	}
	
	public Equipment[] addUnitsRecord(Equipment[] units, Equipment equipment) {
		int emptyIndex = -1;
		System.out.println(units);
		while ( (emptyIndex = getEmptyEquipmentIndex(units)) == -1 ) {
			Equipment[] serv = new Equipment[units.length + 5];
			for (int i = 0; i < units.length; i++){
				serv[i] = units[i];
			}
			units = serv;
		}
		units[emptyIndex] = equipment;
		
		return units;
	}
	
	private int getEmptyEquipmentIndex(Equipment[] units) {
		for ( int i = 0; i < units.length; i++ ) {
			if ( units[i] == null ) {
				return i;
			}
		}
		
		return -1;
	}
	
	/*public int getEquipmentsArraySize() {
		for ( int i = 0; i < units.length; i++ ) {
			if ( units[i] == null) {
				return i;
			} else if ( i == units.length - 1 ) { // if the last element is full
				return i + 1;
			}
		}
		
		return 0;
	}*/

	public Map<Integer, Equipment[]> getUnits() {
		return units;
	}
	
	public Equipment[] getEquipmentsOfPerson(Person person) {
		if ( units.containsKey(person.hashCode()) ) {
			return units.get(person.hashCode());
		} else {
			Equipment[] eq = new Equipment[0]; 
			return eq;
		}
	}
	
}
