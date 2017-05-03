package by.htp.rental.launch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

import by.htp.rental.builder.AbstractEquipmentsBuilder;
import by.htp.rental.builder.EquipmentBuilderFactory;
import by.htp.rental.entity.Accessory;
import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Helmet;
import by.htp.rental.entity.MaterialEnum;
import by.htp.rental.entity.Order;
import by.htp.rental.entity.Person;
import by.htp.rental.entity.PersonCategoryEnum;
import by.htp.rental.entity.Skate;
import by.htp.rental.logic.OrderDB;
import by.htp.rental.logic.RentStation;
import by.htp.rental.logic.RentalManager;
import by.htp.rental.logic.Search;
import by.htp.rental.writer.Printer;

public class RentalRunner {
	
	public static final String XMLFilePath = "D:\\java\\JD1\\rental\\resource\\equipments.xml";
	
	public void mainRunner() throws ClassNotFoundException {
		RentStation rentStation = new RentStation();
		
		//addEquipments(rentStation);
		addEquipmentsFromXML(rentStation);
		start(rentStation);
	}
	
	private void addEquipments(RentStation rentStation) {
		Equipment mainEq1 = new Bycicle("model m1", 10.4, 1, 7, 0.7, PersonCategoryEnum.ADULT, 10, 5);
		Equipment mainEq2 = new Bycicle("model m2", 5.4, 1, 10, 1, PersonCategoryEnum.CHILD, 3, 5);
		Equipment mainEq3 = new Skate("model skate1", 10, 3, 2, 1, PersonCategoryEnum.ADULT, 8, 2);
		
		/// accessory
		ArrayList<Integer> categories = new ArrayList<Integer>();
		categories.add(Accessory.getCategoryId("bycicle"));
		categories.add(Accessory.getCategoryId("skate"));
		Equipment mainEq4 = new Helmet(categories, "model helmet1", 34, 23, 2, 2, PersonCategoryEnum.ADULT, MaterialEnum.WOOD, 20);
		Equipment mainEq5 = new Helmet(categories, "model helmet2", 34.6, 23, 2, 2, PersonCategoryEnum.ADULT, MaterialEnum.PLASTIC, 20);
		Equipment mainEq6 = new Helmet(categories, "model helmet3", 34.3, 23, 2, 2, PersonCategoryEnum.ADULT, MaterialEnum.PLASTIC, 20);
		
		rentStation.addEquipment(mainEq1);
		rentStation.addEquipment(mainEq3);
		rentStation.addEquipment(mainEq2);
		rentStation.addEquipment(mainEq4);
		rentStation.addEquipment(mainEq5);
		rentStation.addEquipment(mainEq6);
	}
	
	private void addEquipmentsFromXML(RentStation rentStation) {
		
		//isXMLAccordingWithXSD();
		startParser("stax", rentStation); // "sax", "dom", "stax"
	}
	
	private void startParser(String parserType, RentStation rentStation) {
		EquipmentBuilderFactory sFactory = new EquipmentBuilderFactory();
		AbstractEquipmentsBuilder builder = sFactory.createEquipmentBuilder(parserType);
		builder.buildListEquipments(XMLFilePath);
		List<Equipment> equipments = builder.getEquipments();
		
		for (Equipment  eq : equipments) {
			System.out.println(eq);
			rentStation.addEquipment(eq);
		}
	}
	
	private void isXMLAccordingWithXSD() {
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
	
	private void start(RentStation rentStation) throws ClassNotFoundException {

		Printer print = new Printer();
		
		print.printRes("All Equipments", rentStation);
		print.printRes("All spare equipments:", rentStation.getSpareEquipments());
		print.printRes("All engaged equipments:", rentStation.getEngagedEquipments());
		
		Person person1 = new Person("Ivan", "Ivanov", "12345678");
		
		OrderDB orderDB = new OrderDB();
		RentalManager rentalManager = new RentalManager(rentStation, orderDB);
		
		//  Create order for person //
		System.out.println("Create order");
		rentalManager.resetEquipments();
		Equipment equipmentForRent = Search.findSpareEquipmentByType(rentStation, "Bycicle");
		if ( equipmentForRent != null ) {
			Order order1 = new Order(person1, equipmentForRent, 24);
			boolean resRent1 = rentalManager.rent(order1);
			String printInf = ( resRent1 ? "Equipment was added" : "Equipment wasn't added" );
			print.printRes(printInf);
		}
		
		print.printRes("spare=", rentStation.getSpareEquipments());
		print.printRes("engaged=", rentStation.getEngagedEquipments());
		System.out.print(orderDB.getUnits());
		
		////////////////////////////////
		rentalManager.resetEquipments();
		Equipment equipmentForRent2 = Search.findSpareEquipmentByType(rentStation, "Bycicle");
		if ( equipmentForRent2 != null ) {
			Order order2 = new Order(person1, equipmentForRent2, 12);
			boolean resRent2 = rentalManager.rent(order2);
			String printInf = ( resRent2 ? "Equipment was added" : "Equipment wasn't added" );
			print.printRes(printInf);
		}
		
		print.printRes("spare=", rentStation.getSpareEquipments());
		print.printRes("engaged=", rentStation.getEngagedEquipments());
		System.out.print(orderDB.getUnits());
		
		////   find equipment by params
		rentalManager.resetEquipments();
		print.printRes("There are founded equipments", Search.findEquipmentByParams(rentStation, 40));
		
		print.printRes("There are founded equipments by last hour");
		rentalManager.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
	}
}
