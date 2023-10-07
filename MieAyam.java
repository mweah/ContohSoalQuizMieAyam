package model;

public class MieAyam extends Mie{
	private String jenisAyam;

	public MieAyam(String name, String flavor, int price, String id, String type, String jenisAyam) {
		super(name, flavor, price, id, type);
		this.jenisAyam = jenisAyam;
	}

	@Override
	public void printDescription() {
		System.out.println("Mie ayam dengan daging ayam " + this.jenisAyam);
	}
	
	public void printTeh() {
		System.out.println("Tambah es teh manis");
	}
}
