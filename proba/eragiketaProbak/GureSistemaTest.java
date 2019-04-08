package eragiketaProbak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eragiketak.GureSistema;

public class GureSistemaTest {
	private static GureSistema nGureSistema=null;
	

	@Before
	public void setUp() throws Exception {
		nGureSistema = GureSistema.getGureSistema();

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
		assertEquals(a, nGureSistema.getProduktuEredua().get(808).get(0).getAntzekotasuna());
		a = 0.9298751f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(557).get(0).getAntzekotasuna());
		a = 0.925442f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(12).get(3).getAntzekotasuna());
		a = 0.93603414f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(13).get(2).getAntzekotasuna());
		
	}

	@Test
	public void testEstimatuBalorazioak() {
		Float a = 3.5f;
		assertEquals(a, nGureSistema.estimatuBalorazioak(1, 955));
		a = 0.0f;
		assertEquals(a, nGureSistema.estimatuBalorazioak(3, 808));
		a = 3.5f;
		assertEquals(a, nGureSistema.estimatuBalorazioak(4, 557));
		a = 3.5f;
		assertEquals(a, nGureSistema.estimatuBalorazioak(9, 807));
		a = 4.5f;
		assertEquals(a, nGureSistema.estimatuBalorazioak(20, 12));
		
	}
	
	@Test
	public void testBorobildu() {
		Float a = 3.5f;
		assertEquals(a, nGureSistema.borobildu(3.54789635412f));
		a = 3.5f;
		assertEquals(a, nGureSistema.borobildu(3.34789635412f));
		a = 4.0f;
		assertEquals(a, nGureSistema.borobildu(3.7589635412f));
		a = 3.0f;
		assertEquals(a, nGureSistema.borobildu(3.23789635412f));
		a = 3.5f;
		assertEquals(a, nGureSistema.borobildu(3.58521436945f));
		
	}
	
	

	@Test
	public void testOrdenatu() {
		
		nGureSistema.ordenatu(808);
		nGureSistema.ordenatu(557);
		
		Float a = 0.9531253f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(808).get(0).getAntzekotasuna());
		a = 0.8876531f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(808).get(nGureSistema.getProduktuEredua().get(808).size()-1).getAntzekotasuna());
		a = 0.94622636f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(557).get(0).getAntzekotasuna());
		a = 0.8822235f;
		assertEquals(a, nGureSistema.getProduktuEredua().get(557).get(nGureSistema.getProduktuEredua().get(557).size()-1).getAntzekotasuna());
		
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
