package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

public class TripManager {

	List<Trip> trips=new ArrayList<Trip>();
	
	
	public List<Trip> getTrips() {
		return trips;
	}


	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}


	public void addTrip(Trip trip1) {
		trips.add(trip1);		
	}

}
