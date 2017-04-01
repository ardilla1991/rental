package by.htp.rental.entity;

public abstract class Equipment {
	
	private double price;
	private double weight;
	private double width;
	private double height;
	private boolean spare; // is spare for rental (true or false)
	private String type; // for child or for adult 
	
	public Equipment(double price, double weight, double width, double height, String type) {
		this.price = price;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.type = type;
		setSpare(true);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public boolean getSpare() {
		return spare;
	}

	public void setSpare(boolean spare) {
		this.spare = spare;
	}
}
