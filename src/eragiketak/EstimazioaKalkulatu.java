package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

import datuak.ProduktuInfo;

public interface EstimazioaKalkulatu {
	
	public Float estimatuBalorazioak(int idE, int idPelikula);
	
	public Float borobildu(Float num);
	
	public void ordenatu(int idE);
	
	public void gehituProduktuaEreduari(Integer key, ArrayList<ProduktuInfo> bereLista);
	
	public HashMap<Integer, ArrayList<ProduktuInfo>> getProduktuEredua();

}
