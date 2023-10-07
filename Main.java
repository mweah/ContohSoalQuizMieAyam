package main;

import java.util.*;

import model.Mie;
import model.MieAyam;
import model.MieBakso;


public class Main{
	int choice = 0;

	Scanner scn = new Scanner(System.in);
	ArrayList<Mie> dataMie = new ArrayList<>();
	
	public void Menu() {
		System.out.println("Miantan Digital");
		System.out.println("=================");
		System.out.println("[1]. Tambah mie");
		System.out.println("[2]. Cek menu");
		System.out.println("[3]. Beli mie");
		System.out.println("[4]. Edit Mie");
		System.out.println("[5]. Exit");
		System.out.print(">>");
	}
	
	public void idRandom() {
//	formula of math.random = Math.random() * (max - min + 1) + min
	}
	
	private void tambahMie() {	
		String name = "";
		String flavor = "";
		int price = 0;
		String id = "";
		String type = "";
		
		int a = 0, b = 0, c = 0;
		int range = 9 - 0 + 1;
		a = (int) (Math.random() * range + 0);
		b = (int) (Math.random() * range + 0);
		c = (int) (Math.random() * range + 0);
		
		Mie mieBaru = null;
		
		
		do {
		System.out.print("Berikan input nama[6-12]: ");
		name = scn.nextLine();
		} while(name.length() < 6 || name.length() > 12);
		
		do {
			System.out.print("Berikan rasa (Pedas, Asin, Manis) [case insensitive]: ");
			flavor = scn.nextLine();
		} while(!(flavor.equalsIgnoreCase("Pedas")|| flavor.equalsIgnoreCase("Asin") || flavor.equalsIgnoreCase("Manis")));
		
		do {
			System.out.print("Berikan harga [10000 - 15000]: ");
			try {
				price = scn.nextInt(); scn.nextLine();
			} catch (Exception e) {
				System.out.println("Harga harus angka");
				scn.nextLine();
			}

		} while(price <= 10000 || price > 15000);
		
		do {
			System.out.println("Pilih tipe bakmi[Ayam, Bakso]: ");
			type = scn.nextLine();
		} while(!(type.equals("Ayam") || type.equals("Bakso")));
		
		if(type.equals("Ayam")) {
			String jenisAyam = "";
			do {
			System.out.println("Pilih jenis ayam [Kampung || Negeri]	");
			jenisAyam = scn.nextLine();
			} while(!(jenisAyam.equals("Kampung") || jenisAyam.equals("Negeri")));
			
			id = String.format("MA%d%d%d", a,b,c);
			
			mieBaru = new MieAyam(name, flavor, price, id, type, jenisAyam);
			
		} else if (type.equals("Bakso")) {
			int jumlahPentol = 0;
			do {
			System.out.println("Jumlah pentol [1-3]");
			
			try {
				jumlahPentol = scn.nextInt(); scn.nextLine();
			} catch (Exception e) {
				System.out.println("Input harus angka");
				scn.nextLine();
			}	
			} while (jumlahPentol < 1 || jumlahPentol > 3);
			
			mieBaru = new MieBakso(name, flavor, price, id, type, jumlahPentol);
		}
		
		dataMie.add(mieBaru);
		System.out.println("Berhasil menambahkan mie baru");
		
		mieBaru.printMie();
		mieBaru.printDescription();
		
		System.out.println("Tekan enter utk lanjut");
		scn.nextLine();
		
	}
	
	private void liatMenu() {
		if(dataMie.isEmpty()) {
			System.out.println("No  Data");
		} 
		
		int index = 0;
		
		for (Mie mie : dataMie) {
			index++;
			System.out.println("=============");
			System.out.println("[Menu no " + index + "]");
			mie.printDescription();
			mie.printMie();
			if(mie instanceof MieAyam) {
				((MieAyam) mie).printTeh();
			}
			System.out.println("=============");

		}
		System.out.println("Tekan enter untuk lanjut");
		scn.nextLine();
	}
	
	private void beliMie() {
		int nomor = 0;
		int quantity = 0;
		int index = -1;
		liatMenu();
	do {
		System.out.print("Pilih mie >>");
		
		try {
			nomor = scn.nextInt(); scn.nextLine();
		} catch (Exception e) {
			System.out.println("Input harus angka");
			scn.nextLine();
		}
	} while (nomor < 1 || nomor > dataMie.size());
	do {
		System.out.print("Jumlah mie yang ingin dibeli [minimal 1]: ");
		quantity = scn.nextInt(); scn.nextLine()
	
		try {
			quantity = scn.nextInt(); scn.nextLine();
		} catch (Exception e) {
			System.out.println("Input harus angka");
			scn.nextLine();
			}
	} while(quantity < 1);
	
	index = nomor - 1;
	System.out.println("Kamu telah membeli");
	dataMie.get(index).printMie(quantity);
	
	dataMie.remove(index);
	
	System.out.println("Tekan enter untuk lanjut");
	scn.nextLine();
	
	
	
}
	
	private void editMie() {
		String id = "";
		Mie mieEdit = null;
		String namaBaru = "";
		
		liatMenu();
		
		System.out.print("Pilih ID mie yang mau diedit: ");
		id = scn.nextLine();
		
		for (Mie mie : dataMie) {
			if(mie.getId().equals(id)) {
				System.out.println("Mie ketemu");
				mieEdit = mie;
			}
		}
		
		if(mieEdit != null) {
			System.out.println("Mie kamu: ");
			mieEdit.printMie();
			
			System.out.println("Nama baru untuk mie: ");
			namaBaru = scn.nextLine();
			
			mieEdit.setName(namaBaru);
		} else {
			System.out.println("Gak ada mie");
		}
		System.out.println("Tekan enter utk lanjut");
		scn.nextLine();
	}
	public Main() {
		do {
			do {
				Menu();
			try {
				choice = scn.nextInt(); scn.nextLine();
			} catch (Exception e) {
				System.out.println("Input harus angka");
				scn.nextLine();
			}
			} while(choice < 1 || choice > 5);

			switch(choice) {
			case 1:
				tambahMie();
				break;
			case 2:
				liatMenu();
				break;
			case 3:
				beliMie();
				break;
			case 4:
				editMie();
				break;
			case 5:
				System.out.println("Terima kasih dan kembali lagi");
				break;
			}
			
		} while (choice !=5);
	
	
	
	}
	


	public static void main(String[] args) {
		new Main();
	}

}
