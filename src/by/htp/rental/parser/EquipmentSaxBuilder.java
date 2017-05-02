package by.htp.rental.parser;

import by.htp.rental.entity.Equipment;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class EquipmentSaxBuilder {
	private List<Equipment> eq;
	private EquipmentSaxHandler sh;
	private XMLReader reader;
	public EquipmentSaxBuilder() {
		// �������� SAX-�����������
		sh = new EquipmentSaxHandler();
		try {
			// �������� �������-�����������
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(sh);
			
			//��������� �������� ����������������
			reader.setFeature("http://xml.org/sax/features/validation", true);
			
			//��������� ��������� ������������ ����
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			
			//��������� ����������� �����
			reader.setFeature("http://xml.org/sax/features/string-interning", true);
			
			//���������� ��������� ����
			//reader.setFeature("http://xml.org/sax/features/validation/schema", false);
			
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		}
	}
	
	public List<Equipment> getStudents() {
		return eq;
	}
	
	public void buildListEquipments(String fileName) {
		try {
			// ������ XML-���������
			reader.parse(fileName);
		} catch (SAXException e) {
			System.err.print("������ SAX �������: " + e);
		} catch (IOException e) {
			System.err.print("������ I/� ������: " + e);
		}
		eq = sh.getEquipmentList();
	}
}
