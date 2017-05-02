package by.htp.rental.builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.rental.entity.Bycicle;
import by.htp.rental.entity.Equipment;

public class EquipmentDOMBuilder extends AbstractEquipmentsBuilder{
	private List<Equipment> eq;
	private DocumentBuilder docBuilder;
	public EquipmentDOMBuilder() {
		eq = new ArrayList<Equipment>();
		// создание DOM-анализатора
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.err.println("ќшибка конфигурации парсера: " + e);
		}
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	public void buildListEquipments(String fileName) {
		Document doc = null;
		try {
			// parsing XML-документа и создание древовидной структуры
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			// получение списка дочерних элементов <bycicle>
			NodeList bycicleList = root.getElementsByTagName("bycicle");
			for (int i = 0; i < bycicleList.getLength(); i++) {
				Element eqElement = (Element) bycicleList.item(i);
				Equipment equipment = buildEquipment(eqElement);
				eq.add(equipment);
			}
		} catch (IOException e) {
			System.err.println("File error or I/O error: " + e);
		} catch (SAXException e) {
			System.err.println("Parsing failure: " + e);
		}
	}
	
	private Equipment buildEquipment(Element eqElement) {
		Equipment equipment = new Bycicle();
		equipment.setPrice(Double.parseDouble(getElementTextContent(eqElement, "price")));
		equipment.setWeight(Double.parseDouble(getElementTextContent(eqElement, "weight")));
		equipment.setWidth(Double.parseDouble(getElementTextContent(eqElement, "width")));
		equipment.setHeight(Double.parseDouble(getElementTextContent(eqElement, "height")));
		
		return equipment;
	}
	
	// получение текстового содержимого тега
	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		
		return text;
	}
}
