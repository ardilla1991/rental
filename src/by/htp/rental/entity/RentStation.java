package by.htp.rental.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import by.htp.rental.interf.IRentStation;

public class RentStation implements IRentStation{

	private HashMap<Integer, Equipment> equipments = new HashMap<>();
	private ArrayList<Integer> spareEquipments = new ArrayList<>();
	private ArrayList<Integer> engagedEquipments = new ArrayList<>();

	public void addEquipment(Equipment equipment) {
		int id = generateIdOfEquipment();
		equipments.put(id, equipment);
		equipment.setId(id);
		spareEquipments.add(id);
	}
	
	private int generateIdOfEquipment() {
		int id = (int) (Math.random()*100000); 
		
		return id;
	}

	@Override
	public String toString() {
		return "RentStation [equipments=" + equipments + "]";
	}
	
	public ArrayList<Integer> getSpareEquipments() {
		
		return spareEquipments;
	}
	
	public ArrayList<Integer> getEngagedEquipments() {
		
		return engagedEquipments;
	}
	
	public HashMap<Integer, Equipment> getEquipments() {
		
		return equipments;
	}
	
	public void addEngagedRecord(int id) {
		engagedEquipments.add(id);
	}
	
	public void addSpareRecord(int id) {
		engagedEquipments.add(id);
	}	
	
	public void deleteSpareRecord(int id) {
		spareEquipments.remove(new Integer(id));
	}
	
	public void deleteEngagedRecord(int id) {
		engagedEquipments.remove(new Integer(id));
	}
	
	///// find equipment by param
	public HashMap<Integer, Equipment> findEquipmentByParams(double price) {
		HashMap<Integer, Equipment> eq = new HashMap<>();
		for ( HashMap.Entry<Integer, Equipment> entry : equipments.entrySet()) {
			if ( entry.getValue().getPrice() < price && !Arrays.asList(getSpareEquipments()).contains(entry.getValue().getId()) ) {
				eq.put(entry.getKey(), entry.getValue());
			}
		}

		return eq;
	}
	

}
