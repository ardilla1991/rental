package by.htp.rental.writer;

import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.RentStation;

public class Printer {

	public void printRes(String str, Equipment[] eq) {
		System.out.println(str);
		for ( int i = 0; i < eq.length; i++ ) {
			System.out.println("Equipment" + i + ": obj: " + eq[i].getClass() 
			+ "; price: " + eq[i].getPrice() + "; spare: " + eq[i].getSpare()); 
		}
	}
	
	public void printRes(String str, RentStation rentSt) {
		System.out.println(str);
		System.out.println(rentSt);
	}
}
