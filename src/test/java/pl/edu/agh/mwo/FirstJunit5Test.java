package pl.edu.agh.mwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class FirstJunit5Test {

	@Test
	@Disabled("tak tylko do sprawdzenia")	
	void testMyFirstFeature() {
		assertEquals(2,1+1);
	}

}
