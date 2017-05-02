package by.htp.rental.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;

public class EquipmentStAXBuilder {
	private List<Equipment> eq = new ArrayList<Equipment>();
	private XMLInputFactory inputFactory;
	
	public EquipmentStAXBuilder() {
		inputFactory = XMLInputFactory.newInstance();
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	public void buildListEquipments(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader = null;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			// StAX parsing
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (EquipmentTagName.valueOf(name.toUpperCase()) == EquipmentTagName.BYCICLE) {
						Equipment equipment = buildEquipment(reader);
						eq.add(equipment);
					}
				}
			}
		} catch (XMLStreamException ex) {
			System.err.println("StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			System.err.println("File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				System.err.println("Impossible close file "+fileName+" : "+e);
			}
		}
	}
	
	private Equipment buildEquipment(XMLStreamReader reader) throws XMLStreamException {
		Equipment equipment = new Bycicle();

		String name;
		EquipmentTagName tagName;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					tagName = EquipmentTagName.valueOf(name.toUpperCase().replace("-", "_"));
					switch (tagName) {
						case PRICE:
							name = getXMLText(reader);
							equipment.setPrice(Double.parseDouble(name));
							break;
						case WEIGHT:
							name = getXMLText(reader);
							equipment.setWeight(Double.parseDouble(name));
							break;
						case WIDTH:
							name = getXMLText(reader);
							equipment.setWidth(Double.parseDouble(name));
							break;
						case HEIGHT:
							name = getXMLText(reader);
							equipment.setHeight(Double.parseDouble(name));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					name = reader.getLocalName();
					tagName = EquipmentTagName.valueOf(name.toUpperCase().replace("-", "_"));
					if (tagName == EquipmentTagName.BYCICLE) {
						return equipment;
					}
					break;
				}
			}
			throw new XMLStreamException("Unknown element in tag Student");
	}
	
	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		
		return text;
	}
}
