package eragiketaProbak;

import static org.junit.Assert.*;

import org.junit.After;

import eragiketak.ProdukturarekinEstimazioa;
import eragiketak.AntzekoPertsonak;
import eragiketak.GureSistema;
import org.junit.Before;
import org.junit.Test;


public class AntzekoPertsonakTest {
	
	private AntzekoPertsonak antzeko;
	private GureSistema nGS;
	

	@After
	public void tearDown() throws Exception {
		antzeko = null;
	}

	@Test
	public void pertsonaAntzekoak() {
		nGS = GureSistema.getGureSistema();
		
		nGS.produktuenBalorazioak();
		nGS.pertsonakAtera();
		nGS.antzekotasunGuztiakKalkulatu();
		
		int[] antzekoak1 = new int[] {1661,3550,383,1232,1461};
		int[] antzekoak2 = new int[] {4664,1461,1232,1661,5419};
		
		int[] a1 = new int[5];
		int[] a2 = new int[5];
		
		antzeko = new AntzekoPertsonak(1);
		Integer[] a = antzeko.pertsonaAntzekoak(1);
		for (int i = 0; i < a.length; i++) {
			a1[i] = a[i];
		}
		
		
		antzeko = new AntzekoPertsonak(2);
		Integer[] b = antzeko.pertsonaAntzekoak(2);
		for (int i = 0; i < b.length; i++) {
			a2[i] = b[i];
		}
		
		
		assertArrayEquals(antzekoak1, a1);
		assertArrayEquals(antzekoak2, a2);
}
}