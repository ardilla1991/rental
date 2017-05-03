package by.htp.rental.builder;

import by.htp.rental.entity.Equipment;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class EquipmentSAXBuilder extends AbstractEquipmentsBuilder{
	private List<Equipment> eq;
	private EquipmentSAXHandler sh;
	private XMLReader reader;
	
	public EquipmentSAXBuilder() {

		sh = new EquipmentSAXHandler();
		try {
			// создание объекта-обработчика
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(sh);
			
			//включение проверки действительности
			reader.setFeature("http://xml.org/sax/features/validation", true);
			
			//включение обработки пространства имен
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			
			//включение канонизации строк
			reader.setFeature("http://xml.org/sax/features/string-interning", true);
			
			//отключение обработки схем
			//reader.setFeature("http://xml.org/sax/features/validation/schema", false);
			
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера: " + e);
		}
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	public void buildListEquipments(String fileName) {
		try {
			// разбор XML-документа
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера: " + e);
		} catch (IOException e) {
			System.err.print("ошибка I/О потока: " + e);
		}
		eq = sh.getEquipmentList();
	}
}
