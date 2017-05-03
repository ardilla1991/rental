package by.htp.rental.entity;

public abstract class MainEquipment extends Equipment{
	
	private int termOfService;
	
	public MainEquipment() {
		super();
	}
	
	public MainEquipment(String model, double price, double weight, double width, 
			double height, PersonCategoryEnum category, int termOfService) {
		super(model, price, weight, width, height, category);
		this.termOfService = termOfService;
	}

	public int getTermOfService() {
		return termOfService;
	}

	public void setTermOfService(int termOfService) {
		this.termOfService = termOfService;
	}

	@Override
	public String toString() {
		return super.toString() + "termOfService=" + termOfService + ", ";
	}
}
