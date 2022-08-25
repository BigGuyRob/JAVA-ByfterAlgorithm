import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.core.Response;

import netscape.javascript.JSObject;

import javax.ws.rs.core.MediaType;

/**
 * ORSfactory contains logic for connecting to OpenRouteService and utilizing its services
 * @author rreid
 *
 */
public class ORSfactory {
	/**
	 * Creates client Object of type Client.
	 */
	public Client client = ClientBuilder.newClient();

	/**
	 * Get distance method returns the driving distance in minutes between two Locations
	 * @param query Object of type String.
	 * @return distance in minutes to get from location a to location b
	 */
	public String getDistance(String query) {
		Entity<String> payload = Entity.json(query);
		Response response = client.target("https://api.openrouteservice.org/v2/matrix/driving-car")
		  .request()
		  .header("Authorization", "5b3ce3597851110001cf62488ae7c0df7b914c49ac31bda114309168")
		  .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
		  .header("Content-Type", "application/json; charset=utf-8")
		  .post(payload);
		String res = response.readEntity(String.class);
		return res;
	}
	
	/**
	 * Get query method returns the query object ORS is expecting
	 * @param people - ArrayList of people objects, either driver or passenger
	 * @return query - string object to be sent to getDistance to return distance matrix
	 */
	public String getQuery(ArrayList<Person> people){
		String q = "{\"locations\":[";
		for(Person d : people) {
			if(d.getType() == "driver") {
				q+="[";
				q +=d.getStartLoc().getLongitude() +",";
				q+=d.getStartLoc().getLatitude() +"]";
				q+=",";
			}
		}
		for(Person p : people) {
			if(p.getType() == "passenger") {
				q+="[";
				q +=p.getStartLoc().getLongitude() +",";
				q+=p.getStartLoc().getLatitude() +"]";
				q+=",";
			}
		}
		q = q.substring(0, q.length() -1 );
		q+="]}";
		//Driver locations always come first
		return q;
	}
}
