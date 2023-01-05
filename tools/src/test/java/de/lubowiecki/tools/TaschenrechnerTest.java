package de.lubowiecki.tools;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class TaschenrechnerTest {
	
	private static Taschenrechner taschenrechner;
	
	private static List<Integer> zahlen;

	@BeforeAll
	public static void initAll() {
		// Wird einmalig vor allen Tests dieser Klasse ausgeführt
		taschenrechner = new Taschenrechner();
		System.out.println("ALL");
		
		zahlen = new ArrayList<>();
        zahlen.add(1);
        zahlen.add(2);
        zahlen.add(3);
	}
	
	@BeforeEach
	public void initEach() {
		// Wird vor jedem Test ausgeführt
		System.out.println("EACH");
	}
	
	@AfterAll
	public static void doAfterAll() {
		// Wird einmalig nach allen Tests dieser Klasse ausgeführt
		System.out.println("AFTER ALL");
	}
	
	@AfterEach
	public void doAfterEach() {
		// Wird nach jedem Test ausgeführt
		System.out.println("AFTER EACH");
	}
	
	@Test
    void add_Positiv_Add_Positiv() {
		double expected = 10.0;
		// Prüft ob die Rückgabe der Methode gleich dem erwarteten Wert ist
		//assertEquals(taschenrechner.add(5.0, 5.0), expected);
		assertEquals(taschenrechner.add(5.0, 5.0), expected, "5 + 5");
		
		// assertNotEquals(null, null)
		// assertNull(null)
		// assertNotNull(null)
		// assertTrue(null)
		// assertFalse(null)
    }
	
	@Test
    void add_Positiv_Add_Negativ() {
		double expected = 0.0;
		Taschenrechner t = new Taschenrechner();
		assertEquals(taschenrechner.add(5.0, -5.0), expected);
    }
	
	@DisplayName("Prüfe mehrere Operationen des Taschenrechners")
	@Test
    void check_operations() {
		double[] results = {0, 10, 20, 30};
		assertAll(() -> assertEquals(taschenrechner.add(5, 5), results[1]),
				  () -> assertEquals(taschenrechner.sub(60, 30), results[3]),
				  () -> assertEquals(taschenrechner.multi(10, 2), results[2]),
				  () -> assertEquals(taschenrechner.div(0, 10), results[0])
		);
    }
	
	@DisplayName("Prüfe Division durch 0")
	@Test
    void check_div_0() {
		// Prüft, ob eine spezielle Exception geworfen wird
		assertThrows(ArithmeticException.class, () -> taschenrechner.div(10, 0));
    }

    @Test
    @Disabled("ist noch nicht eingebaut")
    void sub() {
    }

    @Test
    @Disabled("ist noch nicht eingebaut")
    void multi() {
    }

    @Test
    @Disabled("ist noch nicht eingebaut")
    void div() {
    }
}
