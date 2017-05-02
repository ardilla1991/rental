package by.htp.rental.builder;

import java.util.ArrayList;
import java.util.List;

import by.htp.rental.entity.Equipment;

public abstract class AbstractEquipmentsBuilder {
	// protected так как к нему часто обращаются из подкласса
	protected List<Equipment> eq;
	
	public AbstractEquipmentsBuilder() {
		eq = new ArrayList<Equipment>();
	}
	
	public AbstractEquipmentsBuilder(List<Equipment> equipments) {
		this.eq = equipments;
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	abstract public void buildListEquipments(String fileName);
}
