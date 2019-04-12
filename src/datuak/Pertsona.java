package datuak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import eragiketak.EstimazioaKalkulatu;
import eragiketak.GureSistema;

public class Pertsona {
	
	private int id;
	private HashMap<Integer, Float> bereBalorazioak;
	private HashMap<Integer, Float> baloratuEzDituenak;
	
	public Pertsona(int pId) {
		this.id = pId;
		bereBalorazioak = new HashMap<Integer, Float>();
		baloratuEzDituenak = new HashMap<Integer, Float>();
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
		EstimazioaKalkulatu estimazioa = EstimazioaKalkulatu.getEstimazioaKalkulatu();
		for(Map.Entry<Integer, Float> entry : baloratuEzDituenak.entrySet()) {
			baloratuEzDituenak.put(entry.getKey(), estimazioa.estimatuBalorazioak(this.id, entry.getKey()));
		}
	}
	
	public ArrayList<String> emanEstimazioAltuenak() {
		// baloratuEzDituenak listatik, 10 gehien balorazio dutenak bueltatu
		// 10 gehienen produktuen id-ak edukita izenburuen HashMap-atik izenak hartu
		
		GureSistema gs = GureSistema.getGureSistema();
		gs.produktuenIzenburuak();
		
		ArrayList<String> lista = new ArrayList<String>();
		
		
		return lista;
	}

}