package datuenKargaProbak;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datuak.KargaCSV;
import datuak.Pertsona;

public class KargaCSVTest {

	private KargaCSV klasea;
	private HashMap<Integer, ArrayList<Float>> balorazioHM;
	private HashMap<Integer, String> izenburuHM;
	private ArrayList<Pertsona> pertsonak;
	
	@Before
	public void setUp() throws Exception {
		klasea = new KargaCSV();
		balorazioHM = new HashMap<Integer, ArrayList<Float>>();
		izenburuHM = new HashMap<Integer, String>();
		pertsonak = new ArrayList<Pertsona>();
	}

	@After
	public void tearDown() throws Exception {
		klasea = null;
		balorazioHM = null;
		izenburuHM = null;
		pertsonak = null;
	}

	@Test
	public void testKargaCSV() {
		assertNotNull(klasea);
	}

	@Test
	public void testProduktuenBalorazioak() {
		balorazioHM = klasea.produktuenBalorazioak();
		assertNotNull(balorazioHM.get(11));
//		System.out.println(balorazioHM.get(11));
		assertTrue(balorazioHM.get(11).get(0)==4.0);
		assertTrue(balorazioHM.get(11).get(4)==5.0);
	}

	@Test
	public void testProduktuenIzenburuak() {
		izenburuHM = klasea.produktuenIzenburuak();
		assertNotNull(izenburuHM.get(12));
		System.out.println(izenburuHM.get(11));
		System.out.println(izenburuHM.get(808));
		char comilla = '"';
		String izenburua = comilla +"Star Wars: Episode IV - A New Hope (1977)" + comilla;
		assertEquals(izenburuHM.get(808), comilla + "Shrek (2001)" + comilla);
		assertTrue(izenburuHM.get(11).equals(izenburua));
		
	}
	
	@Test
	public void pertsonakAtera() {
		pertsonak = klasea.pertsonakAtera();
		for (int i = 0; i < 5; i++) {
			pertsonak.get(i).inprimatu();
		}
		Float a = 5.0f;
		assertEquals(pertsonak.get(0).getBereBalorazioak().get(9741), a);
		a = 4.0f;
		assertEquals(pertsonak.get(1).getBereBalorazioak().get(581), a);
		a = 4.5f;
		assertEquals(pertsonak.get(2).getBereBalorazioak().get(1892), a);
		a = 2.0f;
		assertEquals(pertsonak.get(3).getBereBalorazioak().get(120), a);
		a = 1.5f;
		assertEquals(pertsonak.get(4).getBereBalorazioak().get(640), a);

	}

}
