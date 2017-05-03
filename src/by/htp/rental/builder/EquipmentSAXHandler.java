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
import by.htp.rental.entity.Skate;

public class EquipmentSAXHandler extends DefaultHandler{
	private List<Equipment> eqList = new ArrayList<Equipment>();
	private Equipment equipment;
	private EquipmentTagName text;
	
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
		if ("bycicle".equals(localName)) {
			equipment = new Bycicle();
		} else if ("skate".equals(localName)) {
			equipment = new Skate();
		} else {
			text = EquipmentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		}
	}
	
	public void characters(char[] buffer, int start, int length) {
		//text.append(buffer, start, length);
		System.out.println(text);
		
		String s = new String(buffer, start, length).trim();
		System.out.println(s);
		if ( text != null ) {
			switch (text) {
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
				//default:
					//throw new EnumConstantNotPresentException(
						//text.getDeclaringClass(), text.name());
			}
		}
		text = null;
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		//EquipmentTagName tagName = EquipmentTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		if ("skyte".equals(localName) || "bycicle".equals(localName)) {
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
