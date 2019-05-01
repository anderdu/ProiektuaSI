package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.ls.LSInput;

import datuak.Pertsona;

public class AntzekoPertsonak {

	private ArrayList<Pertsona> pertsonak;
	private Antzekotasuna antzekotasun;
	private HashMap<Integer, ArrayList<Float>> pertsonenBalorazioak;
	private Integer[] antzekoenak;
	
	public AntzekoPertsonak() {
		// TODO Auto-generated constructor stub
		antzekotasun = new Kosinua();
		pertsonak = GureSistema.getGureSistema().getPertsonak();
		pertsonenBalorazioak = new HashMap<Integer, ArrayList<Float>>();
		antzekoenak = new Integer[5];
	}
	
	private void pertsonenBalJarri() {
		
		int id;
		ArrayList<Float> b = null;
		for (Pertsona p : pertsonak) {
			id = p.getId();
			b = new ArrayList<Float>();
			for(Map.Entry<Integer, Float> entry : p.getBereBalorazioak().entrySet()) {
				Float bal = entry.getValue();
				b.add(bal);
			}
			this.pertsonenBalorazioak.put(id, b);
		}
	}
	
	private void pertsonaAntzekoakKalkulatu(int idPertsona) {
		int id,cont = 0;
		int pos = 0;
		Float ant;
		Float[] listaF = new Float[5];
		for (Pertsona p : pertsonak) {
			id = p.getId();
			if (id != idPertsona) {
				ant = antzekotasun.antzekotasunaKalkulatu(idPertsona, id, pertsonenBalorazioak);
//				System.out.println("Antzekotasun: " + ant);
				if (cont < 5) {
					antzekoenak[cont] = id;
					listaF[cont] = ant;
					cont ++;
				} else {
					pos = 0;
					Float txiki = listaF[0];
					for (int i = 1; i < listaF.length; i++) {
						if (txiki.compareTo(listaF[i]) == 1) {
							txiki = listaF[i];
							pos = i;
						}
					}
//					System.out.println(pos);
					if (ant.compareTo(txiki) == 1) {
						listaF[pos] = ant;
						antzekoenak[pos] = id;
					}
				}
			}
		}
	}

	
	public Integer[] pertsonaAntzekoenakEman(int idPertsona) {
		pertsonenBalJarri();
		pertsonaAntzekoakKalkulatu(idPertsona);
		return this.antzekoenak;
	}
	
	public static void main(String[] args) {
		GureSistema.getGureSistema().pertsonakAtera();
		GureSistema.getGureSistema().produktuenBalorazioak();
		GureSistema.getGureSistema().produktuenIzenburuak();
		AntzekoPertsonak a = new AntzekoPertsonak();
		Integer[] i = a.pertsonaAntzekoenakEman(2);
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);
		}
	}
}
