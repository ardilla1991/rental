package by.htp.rental.entity;

import java.util.HashMap;

public class OrderDB {
	
	private HashMap <Integer, Order[]> units = new HashMap<>();

	public void addOrder(Order newOrder) {
		//[person.hashCode()] = addUnitsRecord(units[person.hashCode()], equipment);
		if ( units.containsKey(newOrder.getPerson().hashCode()) && units.get(newOrder.getPerson().hashCode()).length > 0  ) {
			units.put(newOrder.getPerson().hashCode(), addUnitsRecord(units.get(newOrder.getPerson().hashCode()), newOrder));
		} else {
			Order[] eq = new Order[3];
			units.put(newOrder.getPerson().hashCode(), addUnitsRecord(eq, newOrder));
		}
	}
	
	public Order[] addUnitsRecord(Order[] units, Order order) {
		int emptyIndex = -1;
		System.out.println(units);
		while ( (emptyIndex = getEmptyOrderIndex(units)) == -1 ) {
			Order[] serv = new Order[units.length + 5];
			for (int i = 0; i < units.length; i++){
				serv[i] = units[i];
			}
			units = serv;
		}
		units[emptyIndex] = order;
		
		return units;
	}
	
	private int getEmptyOrderIndex(Order[] units) {
		for ( int i = 0; i < units.length; i++ ) {
			if ( units[i] == null ) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int getOrdersArraySize(Order[] orders) {
		for ( int i = 0; i < orders.length; i++ ) {
			if ( orders[i] == null) {
				return i;
			} else if ( i == orders.length - 1 ) { // if the last element is full
				return i + 1;
			}
		}
		
		return 0;
	}

	public HashMap<Integer, Order[]> getUnits() {
		return units;
	}
	
	public Order[] getEquipmentsOfPerson(Person person) {
		if ( units.containsKey(person.hashCode()) ) {
			//Order[] orderList = getOrdersListForPerson(units.get(person.hashCode()));
			
			return getOrdersListForPerson(units.get(person.hashCode()));
		} else {
			Order[] eq = new Order[0]; 
			return eq;
		}
	}
	
	private Order[] getOrdersListForPerson(Order[] orders ) {
		Order[] eq = new Order[getOrdersArraySize(orders)];
		for ( int i = 0; i < getOrdersArraySize(orders); i++ ) {
			eq[i] = orders[i];
		}
		
		return eq;
	}

	@Override
	public String toString() {
		String str = "";
		//return "OrderDB [units=" + units + "]";
		for (Order[] value : units.values() ){
			for (int i=0; i<value.length; i++){
				str += "Value: " + value[i];
			}
		}
		return str;
	}
	
}
