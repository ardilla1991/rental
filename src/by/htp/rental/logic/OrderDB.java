package by.htp.rental.logic;

import java.util.ArrayList;
import java.util.HashMap;

import by.htp.rental.entity.Order;
import by.htp.rental.entity.Person;

public class OrderDB {
	
	private HashMap <Integer, ArrayList<Order>> units = new HashMap<>();

	public void addOrder(Order newOrder) {
		ArrayList<Order> eq;
		if ( units.containsKey(newOrder.getPerson().hashCode()) && units.get(newOrder.getPerson().hashCode()).size() > 0  ) {
			 eq = units.get(newOrder.getPerson().hashCode());
		} else {
			eq = new ArrayList<>(3);
		}
		eq.add(newOrder);
		units.put(newOrder.getPerson().hashCode(), eq);
	}

	public HashMap<Integer, ArrayList<Order>> getUnits() {
		return units;
	}
	
	public ArrayList<Order> getEquipmentsOfPerson(Person person) {
		if ( units.containsKey(person.hashCode()) ) {
			return units.get(person.hashCode());
		} else {
			ArrayList<Order> eq = new ArrayList<>(0); 
			return eq;
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (ArrayList<Order> value : units.values() ){
			for (int i=0; i<value.size(); i++){
				str += "Value: " + value.get(i);
			}
		}
		return str;
	}
	
}
