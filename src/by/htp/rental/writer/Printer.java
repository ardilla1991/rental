package by.htp.rental.writer;

import java.util.ArrayList;
import java.util.HashMap;

import by.htp.rental.entity.Equipment;
import by.htp.rental.logic.RentStation;

public class Printer {

	public void printRes(String str, Equipment[] eq) {
		System.out.println(str);
		for ( int i = 0; i < eq.length; i++ ) {
			System.out.println("Equipment" + i + ": obj: " + eq[i].getClass() 
			+ "; price: " + eq[i].getPrice() + "; spare: "); 
		}
	}
	
	public void printRes(String str, RentStation rentSt) {
		System.out.println(str);
		System.out.println(rentSt);
	}
	
	public void printRes(String str, ArrayList<Integer> eq) {
		System.out.println(str);
		for ( int i = 0; i < eq.size(); i++ ) {
			System.out.println("Equipment" + i + ": obj: " + eq.get(i)); 
		}
	}
	
	public void printRes(String str) {
		System.out.println(str);
	}
	
	public void printRes(String str, HashMap<Integer, Equipment> eq) {
		System.out.println(str);

		for ( HashMap.Entry<Integer, Equipment> entry : eq.entrySet()) {
			System.out.println("Equipment" + entry.getKey() + ": obj: " + entry.getValue());
		}
	}
	
}
