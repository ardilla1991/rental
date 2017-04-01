package by.htp.rental.launch;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Skate;

public class MainRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipment mainEq1 = new Bycicle(10.4, 1, 7, 0.7, "child", 5);
		Equipment mainEq2 = new Bycicle(5.4, 1, 10, 1, "adult", 5);
		Equipment mainEq3 = new Skate(10, 3, 2, 1, "adult", 2);
		
	}

}
