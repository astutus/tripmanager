package pl.edu.agh.mwo;

public class AddExistingTripException extends Exception {
	public AddExistingTripException() {
		super("you are trying to add the existing trip!");
	}
}
