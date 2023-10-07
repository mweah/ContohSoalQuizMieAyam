package model;

public abstract class Mie {
	
	private String name;
	private String flavor;
	private int price;
	private String id;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Mie(String name, String flavor, int price, String id, String type) {
		super();
		this.name = name;
		this.flavor = flavor;
		this.price = price;
		this.id = id;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract void printDescription();
	
	public void printMie() {
		System.out.println("ID Mie: " + this.id);
		System.out.println("Nama Mie: " + this.name);
		System.out.println("Rasa Mie: " + this.flavor);
		System.out.println("Harga Mie: " + this.price);
	}
	
	public void printMie(int quantity) {
		System.out.println("Nama Mie: " + this.id);
		System.out.println("Nama Mie: " + this.name);
		System.out.println("Rasa Mie: " + this.flavor);
		System.out.println("Harga Total: " + this.price * quantity);
	}

}
