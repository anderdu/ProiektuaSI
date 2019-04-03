package datuak;

import java.util.HashMap;
import java.util.Map;

public class Pertsona {
	
	private int id;
	private HashMap<Integer, Float> bereBalorazioak;
	
	public Pertsona(int pId) {
		this.id = pId;
		bereBalorazioak = new HashMap<Integer, Float>();
	}
	
	public void balorazioaSartu(int pelikulaId, Float bal) {
		bereBalorazioak.put(pelikulaId, bal);
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
	}
	
	public int getId() {
		return this.id;
	}
	
	public HashMap<Integer, Float> getBereBalorazioak() {
		return this.bereBalorazioak;
	}

}
