package by.htp.rental.entity;

import java.util.HashMap;

public class OrderDB {
	
	HashMap <Integer, int[]> units = new HashMap<>();

	public void addOrder(Order newOrder) {
		//[person.hashCode()] = addUnitsRecord(units[person.hashCode()], equipment);
		if ( units.containsKey(newOrder.getPerson().hashCode()) && units.get(newOrder.getPerson().hashCode()).length > 0  ) {
			units.put(newOrder.getPerson().hashCode(), addUnitsRecord(units.get(newOrder.getPerson().hashCode()), newOrder.getEquipmentId()));
		} else {
			int[] eq = new int[3];
			units.put(newOrder.getPerson().hashCode(), addUnitsRecord(eq, newOrder.getEquipmentId()));
		}
	}
	
	public int[] addUnitsRecord(int[] units, int equipment_id) {
		int emptyIndex = -1;
		System.out.println(units);
		while ( (emptyIndex = getEmptyEquipmentIndex(units)) == -1 ) {
			int[] serv = new int[units.length + 5];
			for (int i = 0; i < units.length; i++){
				serv[i] = units[i];
			}
			units = serv;
		}
		units[emptyIndex] = equipment_id;
		
		return units;
	}
	
	private int getEmptyEquipmentIndex(int[] units) {
		for ( int i = 0; i < units.length; i++ ) {
			if ( units[i] == 0 ) {
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

	public HashMap<Integer, int[]> getUnits() {
		return units;
	}
	
	public int[] getEquipmentsOfPerson(Person person) {
		if ( units.containsKey(person.hashCode()) ) {
			return units.get(person.hashCode());
		} else {
			int[] eq = new int[0]; 
			return eq;
		}
	}

	@Override
	public String toString() {
		return "OrderDB [units=" + units + "]";
	}
	
}
