package pl.edu.agh.mwo;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;

import static java.time.Duration.ofMillis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripTest {
	Trip trip;
	Photo photo1;
	// fixture
	String imagePath="src/main/resources/skillvssalary.jpeg";
	String imagePath2 = "src/main/resources/success.jpg";
	
	@BeforeEach
	public void prepare() {
		trip=new Trip("Majorka", "to jest bardzo fajna wycieczka");
	}
	
	@Test
	@DisplayName("addPhoto")
	public void checkAddPhoto() {
		assertAll( "wlasciwosci",
				() -> {
					assertNotNull(trip.getName());
				},
				() -> {
					assertTrue(trip.addPhoto(imagePath));
				}
		);
	}
	// tested with 1 ms and fails
	@Test
	@DisplayName("loadingSpeed")
	public void checkSpeed() {
		assertTimeout(
				ofMillis(500), () -> {
					trip.addPhoto(imagePath2);
				},
				"too slow"
			
	);
	}
	
	// add the same photo
	@Test
	@DisplayName("toSamoZdjecie")
	// sprawdzanie zmiany zdjecia wczytywania
	void theSamePhoto() throws NotJpgException, TheSameImageException {
				trip.addPhoto(imagePath);
				assertThrows(TheSameImageException.class, () -> {
					trip.addPhoto(imagePath);
				});

	}
	
	@Test
	@DisplayName("loadPhotosWorking")
	public void loadWorking() {
		assumeTrue("PRODUCTION".equals(System.getenv("ENV")));
		try {
			trip.addPhoto(imagePath);
		}
		catch (TheSameImageException e) {
			e.printStackTrace();
		}
		assertNotNull(trip.getPhotos().get(0));
	}

}
