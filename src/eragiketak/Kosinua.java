package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

public class Kosinua implements Antzekotasuna {
	
	public Kosinua() {
		
	}
	
	public Float antzekotasunaKalkulatu(int p1, int p2, HashMap<Integer, ArrayList<Float>> map) {
		
		HashMap<Integer, ArrayList<Float>> hm = new HashMap<Integer, ArrayList<Float>>(map);
		
		if (!hm.containsKey(p1) || !hm.containsKey(p2)) {
//			System.out.println("Emaitza 0 da");
			return 0.0f;
		}
		
		ArrayList<Float> bal1 = hm.get(p1);
		ArrayList<Float> bal2 = hm.get(p2);
		
		Float emaitza = null;
		double batErro1 = 0.0, batErro2 = 0.0, num1 = 0.0, num2 = 0.0, batukaria = 0.0;
		int i=0;
		if(p1 == p2) {
//			System.out.println("Zenbaki berdina sartu duzu!!!");
			return 0.0f;
		} else {	
			while(i<bal1.size() && i<bal2.size()) {		
				
				num1 = (double) bal1.get(i);
				num2 = (double) bal2.get(i);
				
				batukaria = batukaria + num1 * num2;
				
				batErro1 = (batErro1 + Math.pow(num1, 2));
				batErro2 = (batErro2 + Math.pow(num2, 2));
				
//				System.out.println("batukaria: " + batukaria);
//				System.out.println("baterro1: " + batErro1);
//				System.out.println("baterro2: " + batErro2);
				
				i++;
			}
			
			double erro1 =  Math.pow(batErro1, 0.5);
			double erro2 =  Math.pow(batErro2, 0.5);
//			System.out.println("erro1: " + erro1);
//			System.out.println("erro2: " + erro2);
			
			if (erro1 != 0f && erro2 != 0f)
				emaitza = (float) (batukaria / (erro1 * erro2));
			else 
				emaitza = 0f;
//			System.out.println("emaitza: " + emaitza);
			
			return emaitza;
		}	
	}
	
	public static void main(String[] args) {
		Kosinua k = new Kosinua();
		GureSistema n = GureSistema.getGureSistema();
//		k.antzekotasunaKalkulatu(808, 557, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 11, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 12, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 13, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 14, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 15, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 16, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 17, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 18, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(808, 19, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(807, 20, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(951,63, n.produktuenBalorazioak());
		
		k.antzekotasunaKalkulatu(243, 4327, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(243, 2024, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(243, 3049, n.produktuenBalorazioak());
//		k.antzekotasunaKalkulatu(243, 745, n.produktuenBalorazioak());

		
//		n.produktuenBalorazioak();
//		System.out.println(n.produktuenBalorazioak().size());
//		n.antzekotasunGuztiakKalkulatu();
	}

}