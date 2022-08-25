import java.util.InputMismatchException;

/**
 * Location class contains logic relating towards storing and displaying location information
 * @author Rob Reid
 *
 */
public class Location implements Comparable{
	/**
	 * Creates a longitude Object of type double.
	 */
	private double longitude;
	
	/**
	 * Creates a latitude Object of type double.
	 */
	private double latitude;
	
	/**
	 * Location sets the values of our current longitude and latitude.
	 * @param lon Object of type double.
	 * @param lat Object of type double.
	 */
	public Location(double lon, double lat) {
		this.longitude = lon;
		this.latitude = lat;
	}

	/**
	 * compareTo method compares to location objects to see if they are equal
	 * @param o - Object type object to be compared to location 
	 * @return int - -1 if objects could not be compared, 1 if equal, 0 if not equal locations
	 */
	@Override
	public int compareTo(Object o) {
		Location l = new Location(-1,-1);
		try {
			l = (Location) o;
		}catch (InputMismatchException e) {
			//The object was not a location and could not be cast
			return -1;
		}
		
		if(l.getLongitude() == -1 && l.getLatitude() == -1) {
			//return that objects could not be compared or that something happened
			return -1;
		}
		
		if(l.getLongitude() == this.longitude && l.getLatitude() == this.latitude) {
			//Return 1 if equal
			return 1;
		}else {
			//Return 0 if locations are not equal
			return 0;
		}
	}
	
	/**
	 * getLongitude is the constructor class for getting current location longitude.
	 * @return this.longitude
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * getlatitude is the constructor class for getting current location latitude.
	 * @return this.latitude
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * toString returns the string representation of the location.
	 * @return String representation of location.
	 */
	public String toString() {
		return this.longitude + "," + this.latitude; 
	}
	
}
