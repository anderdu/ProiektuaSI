package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

import datuak.ProduktuInfo;

public class EstimazioaKalkulatu {
	
	private static EstimazioaKalkulatu nEstimazioaKalkulatu = null;
	private HashMap<Integer, ArrayList<ProduktuInfo>> produktuEredua;
	private GureSistema nGureSistema;
	private Antzekotasuna antzekotasun;
	
	private EstimazioaKalkulatu() {
		produktuEredua = new HashMap<Integer, ArrayList<ProduktuInfo>>();
		antzekotasun = new Kosinua();
	}
	
	public static synchronized EstimazioaKalkulatu getEstimazioaKalkulatu() {
		if(EstimazioaKalkulatu.nEstimazioaKalkulatu == null)
			EstimazioaKalkulatu.nEstimazioaKalkulatu = new EstimazioaKalkulatu();
		return EstimazioaKalkulatu.nEstimazioaKalkulatu;
	}
	
	public Float estimatuBalorazioak(int idE, int idPelikula) {
		nGureSistema = GureSistema.getGureSistema();
		
		Float emaitza = 0.0f;
		int idAux;
		Float batukari1 = 0.0f, batukari2 = 0.0f;
		//
		this.ordenatu(idPelikula);
		
		for (int i = 0; i < 30; i++) {
			idAux = this.produktuEredua.get(idPelikula).get(i).getId();
			batukari1= batukari1 + nGureSistema.balorazioaBilatu(idE, idPelikula) * antzekotasun.antzekotasunaKalkulatu(idAux, idPelikula, nGureSistema.getBalorazioak());
			batukari2= batukari2 + antzekotasun.antzekotasunaKalkulatu(idAux, idPelikula, nGureSistema.getBalorazioak());
		}
		
		emaitza = batukari1/batukari2;
		
		emaitza = borobildu(emaitza);
		return emaitza;
		
	}
	
	public Float borobildu(Float num) {
		
		String a = String.valueOf(num);
		if(Float.parseFloat(String.valueOf(a.charAt(0))) + 0.25f > num)
			return Float.parseFloat(String.valueOf(a.charAt(0)));
		else if ((Float.parseFloat(String.valueOf(a.charAt(0))) + 0.25f < num) && Float.parseFloat(String.valueOf(a.charAt(0))) + 0.75f > num)
			return (Float.parseFloat(String.valueOf(a.charAt(0))) + 0.5f);
		else
			return (Float.parseFloat(String.valueOf(a.charAt(0))) + 1.0f);
		
	}
	
	public void ordenatu(int idE) {
		// produktu eredua ordenatu --> handienetik txikienera
		
		ArrayList<ProduktuInfo> lista = this.produktuEredua.get(idE);
		Float max = lista.get(0).getAntzekotasuna();
		ArrayList<ProduktuInfo> listaAux = new ArrayList<ProduktuInfo>();
		int pos;
		int a;
		
		while(!lista.isEmpty()) {
			a = 0;
			pos = 0;
			while(a < lista.size()) {
				if(lista.get(a).getAntzekotasuna().compareTo(max) == 1) {
					max = lista.get(a).getAntzekotasuna();
					pos = a;
				}
				else if (lista.size() == 1) {
					max = lista.get(0).getAntzekotasuna();
					pos = 0;
				}
				a++;
			}
			listaAux.add(lista.remove(pos));
			if (!lista.isEmpty())
				max = lista.get(0).getAntzekotasuna();
			
		}
		this.produktuEredua.put(idE, listaAux);
	}
	
	
	public void gehituProduktuaEreduari(Integer key, ArrayList<ProduktuInfo> bereLista) {
		this.produktuEredua.put(key, bereLista);
	}
 	
	public HashMap<Integer, ArrayList<ProduktuInfo>> getProduktuEredua(){
		return this.produktuEredua;
	}
	
}
