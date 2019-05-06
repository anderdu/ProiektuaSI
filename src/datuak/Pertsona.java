package datuak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eragiketak.ProdukturarekinEstimazioa;
import eragiketak.AntzekoPertsonak;
import eragiketak.GureSistema;

public class Pertsona {
	
	private int id;
	private HashMap<Integer, Float> bereBalorazioak;
	private HashMap<Integer, Float> baloratuEzDituenak;
	private Integer[] ap;
	
	public Pertsona(int pId) {
		this.id = pId;
		bereBalorazioak = new HashMap<Integer, Float>();
		baloratuEzDituenak = new HashMap<Integer, Float>();
		if(ap == null) {
			AntzekoPertsonak a = new AntzekoPertsonak(id);
			ap = a.getAntzekoenak();
		}
	}
	
	public void balorazioaSartu(int pelikulaId, Float bal) {
		bereBalorazioak.put(pelikulaId, bal);
	}
	
	public void baloratuEzDuenaSartu(int pelikulaId, Float bal) {
		baloratuEzDituenak.put(pelikulaId, bal);
	}
	
	public void inprimatu() {
		System.out.println("Pertsona id: " + id);
		for(Map.Entry<Integer, Float> entry : bereBalorazioak.entrySet()) {
		    Integer key = entry.getKey();
		    Float value = entry.getValue();
		    
		    System.out.println("	##############");
		    System.out.println("	Pelikula id: " + key);
			System.out.println("	Pelikularen balorazioa: " + value);
			System.out.println("	##############");
		}
		System.out.println("----------------------");
		System.out.println("----------------------");
		for(Map.Entry<Integer, Float> entry2 : baloratuEzDituenak.entrySet()) {
		    Integer key = entry2.getKey();
		    Float value = entry2.getValue();
		    
		    System.out.println("	##############");
		    System.out.println("	Pelikula id: " + key);
			System.out.println("	Pelikularen balorazioa: " + value);
			System.out.println("	##############");
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public HashMap<Integer, Float> getBereBalorazioak() {
		return this.bereBalorazioak;
	}
	
	public HashMap<Integer, Float> getBaloratuEzDituenak() {
		return this.baloratuEzDituenak;
	}
	
	public void estimatuBaloratuEzDituenak() {
		ProdukturarekinEstimazioa estimazioa = ProdukturarekinEstimazioa.getEstimazioaKalkulatu();
		for(Map.Entry<Integer, Float> entry : baloratuEzDituenak.entrySet()) {
			baloratuEzDituenak.put(entry.getKey(), estimazioa.estimatuBalorazioak(this.id, entry.getKey()));
		}
	}
	
	public ArrayList<String> emanEstimazioAltuenak() {
		// baloratuEzDituenak listatik, 10 gehien balorazio dutenak bueltatu
		// 10 gehienen produktuen id-ak edukita izenburuen HashMap-atik izenak hartu
		
		GureSistema gs = GureSistema.getGureSistema();
		HashMap<Integer, String> izenburuak = gs.produktuenIzenburuak();
		HashMap<Integer, Float> balEz = this.baloratuEzDituenak;
		
		
		ArrayList<String> lista = new ArrayList<String>();
		
		Float max;
		Integer key = 0;
		Float balioa;
        for(int i = 0; i < 10; i++) {
            max = 0.0f;
            for(Map.Entry<Integer, Float> entry : balEz.entrySet()) {
                balioa = entry.getValue();
                if (balioa > max){
                    max = balioa;
                    key = entry.getKey();
                }
            }
            balEz.remove(key);
            lista.add(izenburuak.get(key));
        }
        
        return lista;
	}
	
	public Integer[] getAntzekoPertsonak() {
		return this.ap;
	}
	
	public static void main(String[] args) {
		GureSistema.getGureSistema().pertsonakAtera();
		GureSistema.getGureSistema().produktuenBalorazioak();
		GureSistema.getGureSistema().produktuenIzenburuak();
		Pertsona p = new Pertsona(2);
		System.out.println("Erabiltzaile = 2");
		for (int j = 0; j < p.ap.length; j++) {
			System.out.println(p.ap[j]);
		}
		
		Pertsona pe = new Pertsona(3);
		System.out.println("Erabiltzaile = 3");
		for (int j = 0; j < pe.ap.length; j++) {
			System.out.println(pe.ap[j]);
		}
		
		Pertsona per = new Pertsona(2);
		System.out.println("Erabiltzaile = 2");
		for (int j = 0; j < per.ap.length; j++) {
			System.out.println(per.ap[j]);
		}
	}

}