package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

public class Kosinua implements Antzekotasuna {
	
	public Kosinua() {
		
	}
	
	public Float antzekotasunaKalkulatu(int p1, int p2, HashMap<Integer, ArrayList<Float>> hashMap) {
		
		if (!hashMap.containsKey(p1) || !hashMap.containsKey(p2)) {
			System.out.println("Emaitza 0 da");
			return 0.0f;
		}
		
		ArrayList<Float> bal1 = hashMap.get(p1);
		ArrayList<Float> bal2 = hashMap.get(p2);
		Float emaitza = null;
		double batErro1 = 0.0, batErro2 = 0.0, num1 = 0.0, num2 = 0.0, batukaria = 0.0;
		
		
		if(p1 == p2) {
			System.out.println("Zenbaki berdina sartu duzu!!!");
			return 0.0f;
		} else {	
			while(!bal1.isEmpty() && !bal2.isEmpty()) {
				num1 = (double)bal1.remove(0);
				num2 = (double)bal2.remove(0);
				
				batukaria = batukaria + num1 * num2;
				
				batErro1 = (batErro1 + Math.pow(num1, 2));
				batErro2 = (batErro2 + Math.pow(num2, 2));
				
//				System.out.println("batukaria: " + batukaria);
//				System.out.println("baterro1: " + batErro1);
//				System.out.println("baterro2: " + batErro2);
			}
			
			double erro1 =  Math.pow(batErro1, 0.5);
			double erro2 =  Math.pow(batErro2, 0.5);
			System.out.println("erro1: " + erro1);
//			System.out.println("erro2: " + erro2);
			
			if (erro1 != 0f && erro2 != 0f)
				emaitza = (float) (batukaria / (erro1 * erro2));
			else 
				emaitza = 0f;
			System.out.println("emaitza: " + emaitza);
			
			return emaitza;
		}	
	}
	
	public static void main(String[] args) {
		Kosinua k = new Kosinua();
		GureSistema n = GureSistema.getGureSistema();
		k.antzekotasunaKalkulatu(808, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 11, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 12, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 13, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 14, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 15, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 16, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 17, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 18, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(808, 19, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(807, 20, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(806, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(12, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(11, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(557, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(900, 557, n.produktuenBalorazioak());
		k.antzekotasunaKalkulatu(11, 557, n.produktuenBalorazioak());
	}

}
