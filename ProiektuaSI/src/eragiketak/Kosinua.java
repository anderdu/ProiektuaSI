package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

public class Kosinua implements Antzekotasuna {
	
	public Kosinua() {
		
	}
	
	public Float antzekotasunaKalkulatu(int p1, int p2, HashMap<Integer, ArrayList<Float>> hashMap) {
		ArrayList<Float> bal1 = hashMap.get(p1);
		ArrayList<Float> bal2 = hashMap.get(p2);
		Float emaitza, batukaria, num1, num2 = null;
		Float batErro1, batErro2;
		
		batukaria= (float) 0.0;
		batErro1= (float) 0.0;
		batErro2 = (float) 0.0;
		
		if(p1 == p2) {
//			System.out.println("Zenbaki berdina sartu duzu!!!");
			return (float) 0.0;
		} else {	
			while(!bal1.isEmpty() && !bal2.isEmpty()) {
				num1 = bal1.remove(0);
				num2 = bal2.remove(0);
				
				batukaria = batukaria + num1 * num2;
				
				batErro1 = (float) (batErro1 + Math.pow(num1, 2));
				batErro2 = (float) (batErro2 + Math.pow(num2, 2));
				
//				System.out.println("batukaria: " + batukaria);
//				System.out.println("baterro1: " + batErro1);
//				System.out.println("baterro2: " + batErro2);
			}
			
			Float erro1 = (float) Math.sqrt(batErro1);
			Float erro2 = (float) Math.sqrt(batErro2);
//			System.out.println("erro1: " + erro1);
//			System.out.println("erro2: " + erro2);
			
			emaitza = batukaria / (erro1 * erro2);
//			System.out.println("emaitza: " + emaitza);
			
			return emaitza;
		}	
			
	}
	
	public static void main(String[] args) {
		Kosinua k = new Kosinua();
		GureSistema n = GureSistema.getGureSistema();
		k.antzekotasunaKalkulatu(808, 557, n.produktuenBalorazioak());
	}

}
