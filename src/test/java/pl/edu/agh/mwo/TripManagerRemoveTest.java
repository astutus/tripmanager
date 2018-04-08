package pl.edu.agh.mwo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TripManagerRemoveTest {

	Trip trip1;
	Trip trip2;
	Trip trip3;
	TripManager tripManager;

	@BeforeEach
	public void init() {
		trip1 = new Trip("Turcja", "przecietna wycieczka");
		trip2 = new Trip("Egipt", "niebezpieczna wycieczka");
		trip3 = new Trip("Grecja", "normalne wczasy");
		tripManager = new TripManager();
		try {
			tripManager.addTrip(trip1);
			tripManager.addTrip(trip2);
		} catch (AddExistingTripException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRemoveTrip() {
		tripManager.removeTrip(trip1);
		org.hamcrest.MatcherAssert.assertThat(tripManager.getTrips(),
				org.hamcrest.Matchers.not(org.hamcrest.Matchers.hasItem(trip1)));
	}

}
