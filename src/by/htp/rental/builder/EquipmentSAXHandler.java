package by.htp.rental.builder;

import java.util.ArrayList;
import java.util.List;
//import java.util.jar.Attributes;
import org.xml.sax.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.PersonCategoryEnum;
import by.htp.rental.entity.Skate;

public class EquipmentSAXHandler extends DefaultHandler{
	private List<Equipment> eqList = new ArrayList<Equipment>();
	private Equipment equipment;
	private EquipmentTagName text;
	
	private static ArrayList<String> classesNames = new ArrayList<String>();
	
	static {
		classesNames.add("bycicle");
		classesNames.add("skate");
		classesNames.add("helmet");
	}
	
	public List<Equipment> getEquipmentList() {
		return eqList;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("Parser started.");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("Parser ended.");
	}
	
	public void startElement(String uri, String localName, 
			String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement -> " + "uri: " + uri 
				+ ", localName: " + localName + ", qName: " + qName);
		if (classesNames.contains(localName)) {
			equipment = EquipmentsManager.createEquipment(localName);
		} else {
			text = EquipmentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		}
	}
	
	public void characters(char[] buffer, int start, int length) {
		//text.append(buffer, start, length);		
		String s = new String(buffer, start, length).trim();
		if ( text != null  && equipment != null) {
			switch (text) {
				case MODEL:
					equipment.setModel(s);
					break;
				case PRICE:
					equipment.setPrice(Double.parseDouble(s));
					break;
				case WEIGHT:
					equipment.setWeight(Double.parseDouble(s));
					break;
				case WIDTH:
					equipment.setWidth(Double.parseDouble(s));
					break;
				case HEIGHT:
					equipment.setHeight(Double.parseDouble(s));
					break;
				case PERSON_CATEGORY:
					equipment.setPersonCategory(PersonCategoryEnum.valueOf(s.toUpperCase()));
					break;
				default:
					equipment = EquipmentsManager.setObjectProperties(equipment, text, s);
					//throw new EnumConstantNotPresentException(
						//text.getDeclaringClass(), text.name());
			}
		}
		text = null;
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		//EquipmentTagName tagName = EquipmentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		if ( classesNames.contains(localName) ) {
			eqList.add(equipment);
			equipment = null;
		}
		
	}
	
	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " 
				+ exception.getMessage());
	}
	
	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
	}
	
	public void fatalError(SAXParseException exception) throws SAXException{
		System.err.println("FATAL: line " + exception.getLineNumber() + ": "
				+ exception.getMessage());
		throw (exception);
	}
}
