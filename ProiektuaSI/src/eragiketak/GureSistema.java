package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

import datuak.*;

public class GureSistema {
	// EMA klase orokorra
	private static GureSistema nGureSistema=null;
	
	private HashMap<Integer, ArrayList<Float>> balorazioak;
	private HashMap<Integer, String> izenburuak;
	
	private DatuenKarga karga;
	private Antzekotasuna antzekotasun;
	private ArrayList<Pertsona> pertsonak;
	
	
	private GureSistema() {
		karga = new KargaCSV();
		balorazioak = new HashMap<Integer, ArrayList<Float>>();
		izenburuak = new HashMap<Integer, String>();
		pertsonak = new ArrayList<Pertsona>();
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
	
	// Probatzeko
	public static void main(String[] args) {
		GureSistema g = GureSistema.getGureSistema();
		g.pertsonakAtera();
		System.out.println("Pertsona kopurua: " + g.pertsonak.size());
		for (Pertsona p : g.pertsonak) {
			p.inprimatu();
		}
		
	}
	
}
