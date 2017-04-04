package by.htp.rental.launch;

import by.htp.rental.entity.CategoryEq;
import by.htp.rental.entity.MaterialType;
import by.htp.rental.entity.Person;
import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.RentStation;
import by.htp.rental.entity.RentalManager;
import by.htp.rental.entity.Skate;
import by.htp.rental.writer.Printer;

public class MainRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipment mainEq1 = new Bycicle(10.4, 1, 7, 0.7, CategoryEq.ADULT, 5);
		Equipment mainEq2 = new Bycicle(5.4, 1, 10, 1, CategoryEq.CHILD, 5);
		Equipment mainEq3 = new Skate(10, 3, 2, 1, CategoryEq.ADULT, 2);
		Equipment mainEq4 = new Helmet(34, 23, 2, 2, CategoryEq.ADULT, MaterialType.WOOD, 20);
		Equipment mainEq5 = new Helmet(34, 23, 2, 2, CategoryEq.ADULT, MaterialType.PLASTIC, 20);
		//Equipment mainEq6 = new Helmet(34, 23, 2, 2, CategoryEq.ADULT, MaterialType.PLASTIC, 20);
		
		RentStation rentStation = new RentStation();
		rentStation.addEquipment(mainEq1);
		rentStation.addEquipment(mainEq3);
		rentStation.addEquipment(mainEq2);
		rentStation.addEquipment(mainEq4);
		rentStation.addEquipment(mainEq5);
		//rentStation.addEquipment(mainEq6);
		
		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);
		
		
		System.out.println(rentStation);
		
		
		Equipment[] eqSpare = rentStation.getSpareEquipments();
		print.printRes("All spare equipments:", eqSpare);
		
		Equipment[] eqEngaged = rentStation.getEngagedEquipments();
		print.printRes("All engaged equipments:", eqEngaged);
		
		Person person1 = new Person("Ivan", "Ivanov", "12345678");
		
		/*  Create order  */
		RentalManager rentalManager = new RentalManager(rentStation);
		boolean resOfRent1 = rentalManager.rent(person1, mainEq1, 24 * 10 * 60 * 60);
		if ( resOfRent1 ) {
			print.printRes("Equipment was added", new Equipment[0]);
		} else {
			print.printRes("Equipment wasn't added", new Equipment[0]);
		}
		
		Equipment[] eqSpare1 = rentStation.getSpareEquipments();
		print.printRes("All spare equipments:", eqSpare1);
		
		Equipment[] eqEngaged1 = rentStation.getEngagedEquipments();
		print.printRes("All engaged equipments:", eqEngaged1);
		
		
	}

}
