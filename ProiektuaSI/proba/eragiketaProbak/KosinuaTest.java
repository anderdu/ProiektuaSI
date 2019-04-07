package eragiketaProbak;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eragiketak.Antzekotasuna;
import eragiketak.GureSistema;
import eragiketak.Kosinua;

public class KosinuaTest {

	private Antzekotasuna antzekotasun;
	private GureSistema n;
	private HashMap<Integer, ArrayList<Float>> balorazioak;

	@Before
	public void setUp() throws Exception {
		antzekotasun = new Kosinua();
		n = GureSistema.getGureSistema();
		balorazioak = new HashMap<Integer, ArrayList<Float>>();
	}

	@After
	public void tearDown() throws Exception {
		antzekotasun = null;
		n = null;
		balorazioak = null;
	}

	@Test
	public void testAntzekotasunaKalkulatu() {
		
//		System.out.println(antzekotasun.antzekotasunaKalkulatu(11, 12, n.produktuenBalorazioak()));
		balorazioak = n.produktuenBalorazioak();
		Float a = 0.940315f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(11, 12, balorazioak));
		a = 0.0f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(808, 17, balorazioak));
		a = 0.8722739f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(243, 4327, balorazioak));
		a = 0.9329622f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(808, 557, balorazioak));
		a = 0.0f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(34, 4, balorazioak));
		a = 0.0f;
		assertEquals(a, antzekotasun.antzekotasunaKalkulatu(951,63, balorazioak));
	}

}
