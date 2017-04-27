package by.htp.rental.interf;

import java.util.ArrayList;

import by.htp.rental.entity.Equipment;

public interface IRentStation {

	void addEquipment(Equipment equipment);
	ArrayList<Integer> getSpareEquipments();
	ArrayList<Integer> getEngagedEquipments();
}
