package by.htp.rental.entity;

public abstract class Equipment {
	
	private int id;
	private String model;
	private double price;
	private double weight;
	private double width;
	private double height;
	private PersonCategoryEnum personCategory; // for child or for adult 
	
	public Equipment() {
		
	}
	
	public Equipment(String model, double price, double weight, 
			double width, double height, PersonCategoryEnum personCategory) {
		this.model = model;
		this.price = price;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.personCategory = personCategory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PersonCategoryEnum getPersonCategory() {
		return personCategory;
	}

	public void setPersonCategory(PersonCategoryEnum personCategory) {
		this.personCategory = personCategory;
	}

	@Override
	public String toString() {
		return "model=" + model + ", price=" + price + ", weight=" + weight + ", width=" + width + ", height=" + height
				+ ", personCategory=" + personCategory + ", ";
	}
	
}
