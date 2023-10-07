package model;

public class MieBakso extends Mie {
	private int jumlahPentol;

	public MieBakso(String name, String flavor, int price, String id, String type, int jumlahPentol) {
		super(name, flavor, price, id, type);
		this.jumlahPentol = jumlahPentol;
	}

	@Override
	public void printDescription() {
		System.out.println("Mie bakso yang memiliki " + jumlahPentol + " pentol");	
		
	}

}
