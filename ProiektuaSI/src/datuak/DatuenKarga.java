package datuak;

import java.util.ArrayList;
import java.util.HashMap;

// Datuen karga egingo duen interfazea
//para cargaCSV
public interface DatuenKarga {

	public HashMap<Integer, ArrayList<Float>> produktuenBalorazioak();
	public HashMap<Integer, String> produktuenIzenburuak();
	public ArrayList<Pertsona> pertsonakAtera();
	
}