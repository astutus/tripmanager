package pl.edu.agh.mwo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

public class TripTest {
	Trip trip;
	Photo photo1;
	// fixture
	String imagePath="src/main/resources/skillvssalary.jpeg";
	
	@BeforeEach
	public void prepare() {
		trip=new Trip("Majorka", "to jest bardzo fajna wycieczka");
		photo1=new Photo(imagePath);
	}
	
	@Test
	public void checkAddPhoto() {
		assertAll( "wlasciwosci",
				() -> {
					assertNotNull(trip.getName());
				},
				() -> {
					assertTrue(trip.addPhoto(photo1));
				}
		);
	}
	
}
