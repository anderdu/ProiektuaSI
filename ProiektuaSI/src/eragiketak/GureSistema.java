package eragiketak;

import java.util.ArrayList;
import java.util.HashMap;

import datuak.*;

public class GureSistema {
	// EMA klase orokorra
	private static GureSistema nGureSistema=null;
	private DatuenKarga karga;
	
	private GureSistema() {
		karga = new KargaCSV();
	}
	
	public static synchronized GureSistema getGureSistema() {
		if(GureSistema.nGureSistema == null)
			GureSistema.nGureSistema = new GureSistema();
		return GureSistema.nGureSistema;
	}
	
	public HashMap<Integer, ArrayList<Float>> produktuenBalorazioak() {
		return karga.produktuenBalorazioak();
	}
	public HashMap<Integer, String> produktuenIzenburuak() {
		return karga.produktuenIzenburuak();
	}
}
