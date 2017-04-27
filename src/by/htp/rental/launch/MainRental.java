package by.htp.rental.launch;

import java.util.ArrayList;
import java.util.Date;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.CategoryEq;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.MaterialType;
import by.htp.rental.entity.Order;
import by.htp.rental.entity.OrderDB;
import by.htp.rental.entity.Person;
import by.htp.rental.entity.RentStation;
import by.htp.rental.entity.RentalManager;
import by.htp.rental.entity.Skate;
import by.htp.rental.writer.Printer;

public class MainRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentStation rentStation = new RentStation();
		
		Equipment mainEq1 = new Bycicle(10.4, 1, 7, 0.7, CategoryEq.ADULT, 5);
		Equipment mainEq2 = new Bycicle(5.4, 1, 10, 1, CategoryEq.CHILD, 5);
		Equipment mainEq3 = new Skate(10, 3, 2, 1, CategoryEq.ADULT, 2);
		
		/// accessory
		Equipment mainEq4 = new Helmet(34, 23, 2, 2, CategoryEq.ADULT, MaterialType.WOOD, 20);
		Equipment mainEq5 = new Helmet(34.6, 23, 2, 2, CategoryEq.ADULT, MaterialType.PLASTIC, 20);
		Equipment mainEq6 = new Helmet(34.3, 23, 2, 2, CategoryEq.ADULT, MaterialType.PLASTIC, 20);
		
		rentStation.addEquipment(mainEq1);
		rentStation.addEquipment(mainEq3);
		rentStation.addEquipment(mainEq2);
		rentStation.addEquipment(mainEq4);
		rentStation.addEquipment(mainEq5);
		rentStation.addEquipment(mainEq6);
		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);

		ArrayList<Integer> eqSpare = rentStation.getSpareEquipments();
		print.printRes("All spare equipments:", eqSpare);
		
		ArrayList<Integer> eqEngaged = rentStation.getEngagedEquipments();
		print.printRes("All engaged equipments:", eqEngaged);
		
		Person person1 = new Person("Ivan", "Ivanov", "12345678");
		
		OrderDB orderDB = new OrderDB();
		RentalManager rentalManager = new RentalManager(rentStation, orderDB);
		
		//  Create order for person //
		System.out.println("Create order");
		Order order1 = new Order();
		order1.createOrder(person1, mainEq1, 24);
		boolean resRent1 = rentalManager.rent(order1);
		if ( resRent1 ) {
			print.printRes("Equipment was added");
		} else {
			print.printRes("Equipment wasn't added");
		}

		print.printRes("spare=", rentStation.getSpareEquipments());
		print.printRes("engaged=", rentStation.getEngagedEquipments());
		System.out.print(orderDB.getUnits());
		
		////////////////////////////////
		Order order2 = new Order();
		order2.createOrder(person1, mainEq2, 12);
		boolean resRent2 = rentalManager.rent(order2);
		if ( resRent2 ) {
			print.printRes("Equipment was added");
		} else {
			print.printRes("Equipment wasn't added");
		}
		
		print.printRes("spare=", rentStation.getSpareEquipments());
		print.printRes("engaged=", rentStation.getEngagedEquipments());
		System.out.print(orderDB.getUnits());
		
		////   find equipment by params
		rentalManager.resetEquipments();
		print.printRes("There are founded equipments", rentStation.findEquipmentByParams(40));
		
		print.printRes("There are founded equipments by last hour");
		rentalManager.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
		
	}

}
