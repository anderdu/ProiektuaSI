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
	private HashMap<Integer, ArrayList<ProduktuInfo>> produktuEredua;
	
	private DatuenKarga karga;
	private Antzekotasuna antzekotasun;
	private ArrayList<Pertsona> pertsonak;
	
	
	private GureSistema() {
		karga = new KargaCSV();
		balorazioak = new HashMap<Integer, ArrayList<Float>>();
		izenburuak = new HashMap<Integer, String>();
		pertsonak = new ArrayList<Pertsona>();
		antzekotasun = new Kosinua();
		produktuEredua = new HashMap<Integer, ArrayList<ProduktuInfo>>();
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
	
	public HashMap<Integer, ArrayList<ProduktuInfo>> getProduktuEredua(){
		return this.produktuEredua;
	}
	
	public void antzekotasunGuztiakKalkulatu() {
		
		Float ant;
		ProduktuInfo produk;
		Integer key,key2;
		ArrayList<ProduktuInfo> listaProduk;
		
//		HashMap<Integer, ArrayList<Float>> a = this.produktuenBalorazioak();
		
		for(Entry<Integer, ArrayList<Float>> entry : this.balorazioak.entrySet()) {
		    key = entry.getKey();
		    System.out.println(key);
		    
			for(Entry<Integer, ArrayList<Float>> entry2 : this.balorazioak.entrySet()) {
				key2 = entry2.getKey(); 
				if(key2 != key) {
					System.out.println(key + "-ren eta " + key2 + "-ren arteko antzekotasuna");
					ant = antzekotasun.antzekotasunaKalkulatu(key, key2, this.balorazioak);
					produk = new ProduktuInfo(key2, ant);
					
					if(produktuEredua.get(key) == null)
						listaProduk = new ArrayList<ProduktuInfo>();
					else
						listaProduk = produktuEredua.get(key);
					listaProduk.add(produk);
					produktuEredua.put(key, listaProduk);
				
				}
			}

		}
		
	}
	
	public Float estimatuBalorazioak(int idE, int idPelikula) {
		Float emaitza = 0.0f;
		int idAux;
		Float batukari1 = 0.0f, batukari2 = 0.0f;
		//
		this.ordenatu(idE);
		
		for (int i = 0; i < 30; i++) {
			idAux = this.produktuEredua.get(idE).get(i).getId();
			batukari1= batukari1 + balorazioaBilatu(idE, idPelikula) * antzekotasun.antzekotasunaKalkulatu(idAux, idPelikula, this.balorazioak);
			batukari2= batukari2 + antzekotasun.antzekotasunaKalkulatu(idAux, idPelikula, this.balorazioak);
		}
		
		emaitza = batukari1/batukari2;
		
		return emaitza;
		
	}
	
	public void ordenatu(int idE) {
		// produktu eredua ordenatu --> handienetik txikienera
		
		//produktuEredua = new HashMap<Integer, ArrayList<ProduktuInfo>>();
		
		ArrayList<ProduktuInfo> lista = this.produktuEredua.get(idE);
		Float max = lista.get(0).getAntzekotasuna();
		ArrayList<ProduktuInfo> listaAux = new ArrayList<ProduktuInfo>();
		int pos = 0;
		
		for (int k = 0; k < lista.size(); k++) {
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getAntzekotasuna() > max) {
					max = lista.get(i).getAntzekotasuna();
					pos = i;
				}
			}
			listaAux.add(lista.remove(pos));
		}
		this.produktuEredua.put(idE, listaAux);
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
//		g.pertsonakAtera();
//		System.out.println("Pertsona kopurua: " + g.pertsonak.size());
//		for (Pertsona p : g.pertsonak) {
//			p.inprimatu();
//		}
		System.out.println(g.produktuenBalorazioak().size());
//		g.antzekotasunGuztiakKalkulatu();
//		for(Entry<Integer, ArrayList<ProduktuInfo>> entry : g.produktuEredua.entrySet()) {
//			System.out.println("Produktu orokorra: " + entry.getKey());
//			for (ProduktuInfo lista : entry.getValue()) {
//				lista.inprimatu();
//			}
//			System.out.println("##################");
//		}
		
		for(Entry<Integer, ArrayList<Float>> entry : g.balorazioak.entrySet()) {
//			System.out.println(g.antzekotasun.antzekotasunaKalkulatu(12, entry.getKey(), g.balorazioak));
//			g.antzekotasunGuztiakKalkulatu();
		}
	}
	
	
}
