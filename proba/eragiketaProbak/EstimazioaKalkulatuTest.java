package eragiketaProbak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eragiketak.EstimazioaKalkulatu;
import eragiketak.GureSistema;

public class EstimazioaKalkulatuTest {

	private EstimazioaKalkulatu estimazio;
	private GureSistema nGS;

	@Before
	public void setUp() throws Exception {
		estimazio = EstimazioaKalkulatu.getEstimazioaKalkulatu();
		
	}

	@After
	public void tearDown() throws Exception {
		estimazio = null;
	}

	@Test
	public void getEstimazioaKalkulatu() {
		assertNotNull(estimazio);
	}
	
	@Test
	public void testEstimatuBalorazioak() {
		nGS = GureSistema.getGureSistema();
		
		nGS.produktuenBalorazioak();
		nGS.pertsonakAtera();
		nGS.antzekotasunGuztiakKalkulatu();
		
		Float a = 3.5f;
		assertEquals(a, estimazio.estimatuBalorazioak(1, 955));
		a = 0.0f;
		assertEquals(a, estimazio.estimatuBalorazioak(3, 808));
		a = 3.5f;
		assertEquals(a, estimazio.estimatuBalorazioak(4, 557));
		a = 3.5f;
		assertEquals(a, estimazio.estimatuBalorazioak(9, 807));
		a = 4.5f;
		assertEquals(a, estimazio.estimatuBalorazioak(20, 12));
	}

	@Test
	public void testBorobildu() {
		Float a = 3.5f;
		assertEquals(a, estimazio.borobildu(3.54789635412f));
		a = 3.5f;
		assertEquals(a, estimazio.borobildu(3.34789635412f));
		a = 4.0f;
		assertEquals(a, estimazio.borobildu(3.7589635412f));
		a = 3.0f;
		assertEquals(a, estimazio.borobildu(3.23789635412f));
		a = 3.5f;
		assertEquals(a, estimazio.borobildu(3.58521436945f));
	}

	@Test
	public void testOrdenatu() {
		estimazio.ordenatu(808);
		estimazio.ordenatu(557);
		
		Float a = 0.9531253f;
		assertEquals(a, estimazio.getProduktuEredua().get(808).get(0).getAntzekotasuna());
		a = 0.8876531f;
		assertEquals(a, estimazio.getProduktuEredua().get(808).get(estimazio.getProduktuEredua().get(808).size()-1).getAntzekotasuna());
		a = 0.94622636f;
		assertEquals(a, estimazio.getProduktuEredua().get(557).get(0).getAntzekotasuna());
		a = 0.8822235f;
		assertEquals(a, estimazio.getProduktuEredua().get(557).get(estimazio.getProduktuEredua().get(557).size()-1).getAntzekotasuna());
	}


}
