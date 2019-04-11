package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.*;


import datuak.*;

public class GureSistema {
	// EMA klase orokorra
	private static GureSistema nGureSistema=null;
	
	private HashMap<Integer, ArrayList<Float>> balorazioak;
	private HashMap<Integer, String> izenburuak;
	
	private DatuenKarga karga;
	private Antzekotasuna antzekotasun;
	private ArrayList<Pertsona> pertsonak;
	private EstimazioaKalkulatu estimazio;
	
	
	private GureSistema() {
		karga = new KargaCSV();
		balorazioak = new HashMap<Integer, ArrayList<Float>>();
		izenburuak = new HashMap<Integer, String>();
		pertsonak = new ArrayList<Pertsona>();
		antzekotasun = new Kosinua();
		estimazio = EstimazioaKalkulatu.getEstimazioaKalkulatu();
	}
	
	public static synchronized GureSistema getGureSistema() {
		if(GureSistema.nGureSistema == null)
			GureSistema.nGureSistema = new GureSistema();
		return GureSistema.nGureSistema;
	}
	
	public HashMap<Integer, ArrayList<Float>> produktuenBalorazioak() {
		this.balorazioak = karga.produktuenBalorazioak();
		return this.balorazioak;
	}
	
	public HashMap<Integer, String> produktuenIzenburuak() {
		this.izenburuak = karga.produktuenIzenburuak();
		return this.izenburuak;
	}
	
	public ArrayList<Pertsona> pertsonakAtera() {
		this.pertsonak = karga.pertsonakAtera();
		return this.pertsonak;
	}
	
	
	public HashMap<Integer, ArrayList<Float>> getBalorazioak() {
		return this.balorazioak;
	}
	
	public void antzekotasunGuztiakKalkulatu() {
		
		Float ant;
		ProduktuInfo produk;
		Integer key,key2;
		ArrayList<ProduktuInfo> listaProduk;
		
		for(Entry<Integer, ArrayList<Float>> entry : this.balorazioak.entrySet()) {
		    key = entry.getKey();
//		    System.out.println(key);
		    
			for(Entry<Integer, ArrayList<Float>> entry2 : this.balorazioak.entrySet()) {
				key2 = entry2.getKey(); 
				if(key2 != key) {
//					System.out.println(key + "-ren eta " + key2 + "-ren arteko antzekotasuna");
					ant = antzekotasun.antzekotasunaKalkulatu(key, key2, this.balorazioak);
					produk = new ProduktuInfo(key2, ant);
					
					if(estimazio.getProduktuEredua().get(key) == null)
						listaProduk = new ArrayList<ProduktuInfo>();
					else
						listaProduk = estimazio.getProduktuEredua().get(key);
					listaProduk.add(produk);
					estimazio.gehituProduktuaEreduari(key, listaProduk);
				
				}
			}

		}
		
	}
	
	
	public Float balorazioaBilatu(int idUser, int idFilm) {
		HashMap<Integer, Float> bal = null;
		boolean aurkituta = false;
		
		for (int i = 0; i < this.pertsonak.size() && !aurkituta; i++) {
			if(this.pertsonak.get(i).getId() == idUser) {
				aurkituta = true;
				bal = this.pertsonak.get(i).getBereBalorazioak();
			}
		}
		
		for(Entry<Integer, Float> entry : bal.entrySet()) {
		    if(entry.getKey() == idFilm)
		    	return bal.get(idFilm);
		}
		
		return 0.0f;
		
	}
	
	// Probatzeko
	public static void main(String[] args) {
		GureSistema g = GureSistema.getGureSistema();
	}
	
	
}