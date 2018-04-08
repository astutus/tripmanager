package pl.edu.agh.mwo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripManagerTest {
	
	TripManager tripManager;
	Trip trip1;
	Trip trip2;
	
	@BeforeEach
	public void prepatation() {
		trip1=new Trip("Turcja", "przecietna wycieczka");
		trip2=new Trip("Egipt", "niebezpieczna wycieczka");
		tripManager=new TripManager();
	}

	// w celach nauki hamcrest (bez importow statycznych)
	
	@Test
	@DisplayName("dodawanieTripa")
	public void testAddTrip() {
		tripManager.addTrip(trip1);
		org.hamcrest.MatcherAssert.assertThat(tripManager.getTrips(), org.hamcrest.Matchers.hasItem(trip1));
	}
	
	
}
