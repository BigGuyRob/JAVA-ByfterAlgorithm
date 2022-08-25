/**
 * Person class contains logic for creating a person object which would be the drivers and passengers
 * @author rreid
 *
 */
public class Person {
	/**
	 * Creates startLoc Object of type Location.
	 */
	protected Location startLoc = null;
	/**
	 * Creates type Object of type String.
	 */
	protected String type = "";
	
	/**
	 * constructor for person object takes a start Location and a type "driver or passenger"
	 * @param start Object of type Location.
	 * @param type Object of type String.
	 */
	public Person(Location start, String type) {
		this.startLoc = start;
		this.type = type;
	}
	
	/**
	 * getType() returns the type of person as a string to be compared
	 * @return String representation of person type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * returns the starting Location
	 * @return Location of the where the person is starting from or getting picked up from
	 */
	public Location getStartLoc() {
		return this.startLoc;
	}
	
}
