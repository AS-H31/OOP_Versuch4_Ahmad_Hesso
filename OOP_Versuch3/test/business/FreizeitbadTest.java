package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreizeitbadTest {
	
	private Freizeitbad freizeitbad;

	@BeforeEach
	void setUp() throws Exception {
		// wird vor dem Durchlauf einer Testmethode durchgef�hrt
		this.freizeitbad = new Freizeitbad("Stadtbad", "7.00", "17.00", "25", "24");
	}
	
	@AfterEach
	void tearDown() throws Exception{
		// wird nach dem Durchlauf einer Testmethode durchgef�hrt
		this.freizeitbad = null;
	}

	@Test
	// Methoden die mit Test gekennzeichnet sind werden als 
	// Tests durchgef�hrt
	void test() {
		assertTrue(() -> freizeitbad.getBeckenlaenge() == 25,
				"Beckenl�nge ungleich 25");
	}

}
