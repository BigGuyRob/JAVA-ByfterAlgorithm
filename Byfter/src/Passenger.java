/**
 * Passenger Object class contains logic related towards using passenger information
 * @author Rob Reid
 *
 */
public class Passenger extends Person{
	/**
	 * Creates endLoc Object of type Location.
	 */
	private Location endLoc;
	
	/**
	 * Creates travelTime Object of type double.
	 */
	private double travelTime;
	
	/**
	 * Default constructor for the Passenger class is the same as the person
	 * @param start - Location passenger is starting from
	 * @param type - String type of Person ie "passenger"
	 * @param end - Location passenger is going to 
	 */
	public Passenger(Location start, String type, Location end) {
		super(start, type);
		this.endLoc = end;
	}
	
	/**
	 * Returns the intended location of the person. 
	 * @return Location representation of end Location
	 */
	public Location getEndLoc() {
		return this.endLoc;
	}
	
	/**
	 * Outputs the passenger to String representation containing all data fields
	 */
	@Override
	public String toString() {
		return "Passenger - From: " + this.getStartLoc().toString() + " To: " +this.getEndLoc().toString(); 
	}
}
