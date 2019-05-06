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
	
	public AntzekoPertsonak(int erabID) {
		// TODO Auto-generated constructor stub
		antzekotasun = new Kosinua();
		pertsonak = GureSistema.getGureSistema().getPertsonak();
		pertsonenBalorazioak = new HashMap<Integer, ArrayList<Float>>();
		antzekoenak = pertsonaAntzekoak(erabID);
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
	
	public Integer[] getAntzekoenak() {
		return antzekoenak;
	}

	public Integer[] pertsonaAntzekoak(int idPertsona) {
		int id,cont = 0;
		int pos = 0;
		Float ant;
		Float[] listaF = new Float[5];
		Integer[] lis = new Integer[5];
		pertsonenBalJarri();
		for (Pertsona p : pertsonak) {
			id = p.getId();
			if (id != idPertsona) {
				ant = antzekotasun.antzekotasunaKalkulatu(idPertsona, id, pertsonenBalorazioak);
				if (cont < 5) {
					lis[cont] = id;
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
					if (ant.compareTo(txiki) == 1) {
						listaF[pos] = ant;
						lis[pos] = id;
					}
				}
			}
		}
		return lis;
	}

	public static void main(String[] args) {
//		GureSistema.getGureSistema().pertsonakAtera();
//		GureSistema.getGureSistema().produktuenBalorazioak();
//		GureSistema.getGureSistema().produktuenIzenburuak();
//		AntzekoPertsonak a = new AntzekoPertsonak();
//		Integer[] i = a.pertsonaAntzekoenakEman(2);
//		System.out.println("Erabiltzaile = 2");
//		for (int j = 0; j < i.length; j++) {
//			System.out.println(i[j]);
//		}
//		GureSistema.getGureSistema().pertsonakAtera();
//		GureSistema.getGureSistema().produktuenBalorazioak();
//		GureSistema.getGureSistema().produktuenIzenburuak();
//		AntzekoPertsonak an = new AntzekoPertsonak();
//		Integer[] k = an.pertsonaAntzekoenakEman(1);
//		System.out.println("Erabiltzaile = 1");
//		for (int j = 0; j < k.length; j++) {
//			System.out.println(k[j]);
//		}
//		GureSistema.getGureSistema().pertsonakAtera();
//		GureSistema.getGureSistema().produktuenBalorazioak();
//		GureSistema.getGureSistema().produktuenIzenburuak();
//		AntzekoPertsonak al = new AntzekoPertsonak();
//		Integer[] li = al.pertsonaAntzekoenakEman(2);
//		System.out.println("Erabiltzaile = 2");
//		for (int j = 0; j < li.length; j++) {
//			System.out.println(li[j]);
//		}
//		GureSistema.getGureSistema().pertsonakAtera();
//		GureSistema.getGureSistema().produktuenBalorazioak();
//		GureSistema.getGureSistema().produktuenIzenburuak();
//		AntzekoPertsonak ah = new AntzekoPertsonak();
//		Integer[] b = ah.pertsonaAntzekoenakEman(9);
//		System.out.println("Erabiltzaile = 9");
//		for (int j = 0; j < b.length; j++) {
//			System.out.println(b[j]);
//		}
		GureSistema.getGureSistema().pertsonakAtera();
		GureSistema.getGureSistema().produktuenBalorazioak();
		GureSistema.getGureSistema().produktuenIzenburuak();
		AntzekoPertsonak a = new AntzekoPertsonak(1);
		System.out.println("Erabiltzaile = 1");
		for (int j = 0; j < a.antzekoenak.length; j++) {
			System.out.println(a.antzekoenak[j]);
		}
		
		AntzekoPertsonak an = new AntzekoPertsonak(2);
		System.out.println("Erabiltzaile = 2");
		for (int j = 0; j < an.antzekoenak.length; j++) {
			System.out.println(an.antzekoenak[j]);
		}
		
		AntzekoPertsonak ap = new AntzekoPertsonak(2);
		System.out.println("Erabiltzaile = 2");
		for (int j = 0; j < ap.antzekoenak.length; j++) {
			System.out.println(ap.antzekoenak[j]);
		}
		
	}
}
