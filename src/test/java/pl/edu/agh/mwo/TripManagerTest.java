package pl.edu.agh.mwo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripManagerTest {

	TripManager tripManager;
	Trip trip1;
	Trip trip2;

	@BeforeEach
	public void prepatation() {
		trip1 = new Trip("Turcja", "przecietna wycieczka");
		trip2 = new Trip("Egipt", "niebezpieczna wycieczka");
		tripManager = new TripManager();
	}

	// w celach nauki hamcrest (bez importow statycznych)

	@Test
	@DisplayName("dodawanieTripa")
	public void testAddTrip() {
		try {
			tripManager.addTrip(trip1);
		}
		catch (AddExistingTripException ex) {
			ex.printStackTrace();
		}
		org.hamcrest.MatcherAssert.assertThat(tripManager.getTrips(), org.hamcrest.Matchers.hasItem(trip1));
	}

	// sprawdzanie czy odrzuca dodawanie tego samego
	@Test
	@DisplayName("odrzucaDodaniaTegoSamego")
	public void testAddTheSame() {
		try {
			tripManager.addTrip(trip1);
		}
		catch (AddExistingTripException ex) {
			ex.printStackTrace();
		}
		Throwable exception = org.junit.jupiter.api.Assertions.assertThrows(AddExistingTripException.class, () -> {
			tripManager.addTrip(trip1);
		});
	}
	
	// find trip
	@Test
	public void findTrip() {
		try {
			tripManager.addTrip(trip1);
			tripManager.addTrip(trip2);
		}
		catch (AddExistingTripException ex) {
			ex.printStackTrace();
		}
		String toFind="Turcja";
		Trip founded=tripManager.findTrip(toFind);
		assertTrue(founded.equals(trip1));
	}
	
	@Test
	@DisplayName("szukanieNiepelnejNazwy")
	public void findPartialTripName() {
		try {
			tripManager.addTrip(trip1);
			tripManager.addTrip(trip2);
		}
		catch (AddExistingTripException ex) {
			ex.printStackTrace();
		}
		String toFind="turc";
		Trip founded=tripManager.findTrip(toFind);
		assertTrue(founded.equals(trip1));
	}
}
