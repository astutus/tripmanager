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


	public void addTrip(Trip trip1) throws AddExistingTripException {
		for (Trip trip: trips) {
			if (trip == trip1) {
				throw new AddExistingTripException();
			}
		}
		trips.add(trip1);		
	}


	public void removeTrip(Trip trip1) {
		// TODO Auto-generated method stub
		
	}

}
