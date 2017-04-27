package by.htp.rental.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;
import by.htp.rental.entity.Skate;

public class EquipmentSaxHandler extends DefaultHandler{
	private List<Equipment> eqList = new ArrayList<Equipment>();
	private Equipment equipment;
	private StringBuilder text;
	
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
		text = new StringBuilder();
		if (qName.equals("bycicle")) {
			equipment = new Bycicle();
		} else if (qName.equals("skate")) {
			equipment = new Skate();
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		EquipmentTagName tagName = EquipmentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		
		switch(tagName) {
			case PRICE:
				equipment.setPrice(Double.parseDouble(text.toString()));
				break;
			case WEIGHT:
				equipment.setWeight(Double.parseDouble(text.toString()));
				break;
			case WIDTH:
				equipment.setWidth(Double.parseDouble(text.toString()));
				break;
			case HEIGHT:
				equipment.setHeight(Double.parseDouble(text.toString()));
				break;
			case SKYTE:
			case BYCICLE:
				eqList.add(equipment);
				equipment = null;
				break;
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
