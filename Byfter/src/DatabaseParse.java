import java.util.Arrays;

/**
 * DBIinterface contains software for converting data returned from MongoDB into usable location objects
 * @author Brian, Rob, Kiernan
 *
 */
public class DatabaseParse {
	/**
	 * Creates a LongJIndex Object of type int.
	 */
	private final int LongJIndex = 3;
	
	/**
	 * Creates a LatJIndex Object of type int.
	 */
	private final int LatJIndex = 5;
	
	/**
	 * Converts the LatLong string received from a MongoDB query to an array of doubles
	 * @param latLong Object of type String.
	 * @return coordinates Object of type double[].
	 */
	public double[] getCoordinates(String latLong) {
		String[] toParse = latLong.split("=");
		String unrefinedLong = toParse[LongJIndex];
		String unrefinedLat = toParse[LatJIndex];
		String[] trefined = unrefinedLong.split(",");
		String refinedLong = trefined[0];
		refinedLong = refinedLong.replace("}", "");
		String refinedLat = unrefinedLat.replace("}", "");
		
		double[] coordinates = new double[2];
		coordinates[0] = (Double.parseDouble(refinedLat));
		coordinates[1] = (Double.parseDouble(refinedLong));
		return coordinates;
	}
	
	/**
	 * Converts a double array containing latitude and longitude coordinates into a Location object
	 * @param coordinates - a double array of length 2, coordinates[0] = latitude, coordinates[1] = longitude
	 * @return a new location object containing both latitude and longitude coordinates
	 */
	public Location of(double[] coordinates) {
		Location loc = new Location(coordinates[0], coordinates[1]);
		
		return loc;
	}
}
