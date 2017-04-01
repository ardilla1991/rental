package by.htp.rental.launch;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.RentStation;
import by.htp.rental.entity.Skate;
import by.htp.rental.writer.Printer;

public class MainRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipment mainEq1 = new Bycicle(10.4, 1, 7, 0.7, "child", 5);
		Equipment mainEq2 = new Bycicle(5.4, 1, 10, 1, "adult", 5);
		Equipment mainEq3 = new Skate(10, 3, 2, 1, "adult", 2);
		Equipment mainEq4 = new Helmet(34, 23, 2, 2, "adult", "wood", 20);
		Equipment mainEq5 = new Helmet(34, 23, 2, 2, "adult", "wood", 20);
		
		RentStation rentStation = new RentStation();
		rentStation.addEquipment(mainEq1);
		rentStation.addEquipment(mainEq3);
		rentStation.addEquipment(mainEq2);
		rentStation.addEquipment(mainEq4);
		rentStation.addEquipment(mainEq5);
		
		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);
		
		Equipment[] eqSpare = rentStation.getSpareEquipments();
		print.printRes("All spare equipments:", eqSpare);
		
		Equipment[] eqEngaged = rentStation.getEngagedEquipments();
		print.printRes("All ngaged equipments:", eqEngaged);
	}

}
