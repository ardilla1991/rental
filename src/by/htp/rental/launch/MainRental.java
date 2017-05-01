package by.htp.rental.launch;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

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
import by.htp.rental.parser.EquipmentSaxHandler;
import by.htp.rental.writer.Printer;

public class MainRental {

	public static final String XMLFilePath = "D:\\java\\JD1\\rental\\resource\\equipments.xml";
	
	public static void main(String[] args) throws ClassNotFoundException {
		RentStation rentStation = new RentStation();
		
		//addEquipments(rentStation);
		addEquipmentsFromXML(rentStation);
		start(rentStation);
	}
	
	private static void addEquipments(RentStation rentStation) {
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
	}
	
	private static void addEquipmentsFromXML(RentStation rentStation) {
		
		//isXMLAccordingWithXSD();
		SAXParser(rentStation);
	}
	
	private static void SAXParser(RentStation rentStation) {
		try {
			org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();
			try {
				EquipmentSaxHandler handler = new EquipmentSaxHandler();
				reader.setContentHandler(handler);
				InputSource inputSource = new InputSource(XMLFilePath);
				System.out.println(new InputSource(XMLFilePath));
				reader.parse(inputSource);
				
				//включение проверки действительности
				reader.setFeature("http://xml.org/sax/features/validation", true);
				
				//включение обработки пространства имен
				reader.setFeature("http://xml.org/sax/features/namespaces", true);
				
				//включение канонизации строк
				reader.setFeature("http://xml.org/sax/features/string-interning", true);
				
				//отключение обработки схем
				//reader.setFeature("http://xml.org/sax/features/validation/schema", false);
				
				List<Equipment> equipments = handler.getEquipmentList();
				
				for (Equipment  eq : equipments) {
					System.out.println(eq);
					rentStation.addEquipment(eq);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void isXMLAccordingWithXSD() {
		String filename = XMLFilePath;
		String schemaname = "D:\\java\\JD1\\rental\\resource\\equipmentsSchema.xsd";
		String logname = "D:\\java\\JD1\\rental\\resource\\log.txt";
		Schema schema = null;
		String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		SchemaFactory factory = SchemaFactory.newInstance(language);
		try {
		// установка проверки с использованием XSD
		schema = factory.newSchema(new File(schemaname));
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setSchema(schema);
		// создание объекта-парсера
		SAXParser parser = spf.newSAXParser();
		// установка обработчика ошибок и запуск
		parser.parse(filename, new HandlerBase());
		System.out.println(filename + " is valid");
		} catch (ParserConfigurationException e) {
		System.err.println(filename + " config error: " + e.getMessage());
		} catch (SAXException e) {
		System.err.println(filename + " SAX error: " + e.getMessage());
		} catch (IOException e) {
		System.err.println("I/O error: " + e.getMessage());
		}
	}
	
	private static void start(RentStation rentStation) throws ClassNotFoundException {

		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);

		HashMap<Integer, Equipment> eqSpare = rentStation.getSpareEquipments();
		print.printRes("All spare equipments:", eqSpare);
		
		HashMap<Integer, Equipment> eqEngaged = rentStation.getEngagedEquipments();
		print.printRes("All engaged equipments:", eqEngaged);
		
		Person person1 = new Person("Ivan", "Ivanov", "12345678");
		
		OrderDB orderDB = new OrderDB();
		RentalManager rentalManager = new RentalManager(rentStation, orderDB);
		
		//  Create order for person //
		System.out.println("Create order");
		Order order1 = new Order();
		Equipment equipmentForRent = rentStation.findSpareEquipmentByType("Bycicle");
		if ( equipmentForRent != null ) {
			order1.createOrder(person1, equipmentForRent, 24);
			boolean resRent1 = rentalManager.rent(order1);
			if ( resRent1 ) {
				print.printRes("Equipment was added");
			} else {
				print.printRes("Equipment wasn't added");
			}
		}
		
		print.printRes("spare=", rentStation.getSpareEquipments());
		print.printRes("engaged=", rentStation.getEngagedEquipments());
		System.out.print(orderDB.getUnits());
		
		////////////////////////////////
		Order order2 = new Order();
		Equipment equipmentForRent2 = rentStation.findSpareEquipmentByType("Bycicle");
		if ( equipmentForRent2 != null ) {
			order2.createOrder(person1, equipmentForRent2, 12);
			boolean resRent2 = rentalManager.rent(order2);
			if ( resRent2 ) {
				print.printRes("Equipment was added");
			} else {
				print.printRes("Equipment wasn't added");
			}
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
