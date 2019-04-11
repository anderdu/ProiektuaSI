package eragiketaProbak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eragiketak.EstimazioaKalkulatu;
import eragiketak.GureSistema;

public class GureSistemaTest {
	private static GureSistema nGureSistema=null;
	private static EstimazioaKalkulatu estimazio = null;


	@Before
	public void setUp() throws Exception {
		nGureSistema = GureSistema.getGureSistema();
		estimazio = EstimazioaKalkulatu.getEstimazioaKalkulatu();

		nGureSistema.produktuenBalorazioak();
		nGureSistema.pertsonakAtera();
	}

	@After
	public void tearDown() throws Exception {
		nGureSistema = null;
	}
	
	@Test
	public void testAntzekotasunGuztiakKalkulatu() {
		nGureSistema.antzekotasunGuztiakKalkulatu();
		
		Float a = 0.94159514f;
		assertEquals(a, estimazio.getProduktuEredua().get(808).get(0).getAntzekotasuna());
		a = 0.9298751f;
		assertEquals(a, estimazio.getProduktuEredua().get(557).get(0).getAntzekotasuna());
		a = 0.925442f;
		assertEquals(a, estimazio.getProduktuEredua().get(12).get(3).getAntzekotasuna());
		a = 0.93603414f;
		assertEquals(a, estimazio.getProduktuEredua().get(13).get(2).getAntzekotasuna());
		
	}


	@Test
	public void testBalorazioaBilatu() {

		Float a = 3.5f;
		assertEquals(a, nGureSistema.balorazioaBilatu(1, 12));
		a = 4.0f;
		assertEquals(a, nGureSistema.balorazioaBilatu(2, 955));
		a = 3.0f;
		assertEquals(a, nGureSistema.balorazioaBilatu(3, 5503));
		a = 2.0f;
		assertEquals(a, nGureSistema.balorazioaBilatu(4, 122));
		a = 2.5f;
		assertEquals(a, nGureSistema.balorazioaBilatu(5, 5503));
		
	}

}
