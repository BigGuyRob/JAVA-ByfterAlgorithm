import java.util.ArrayList;

import org.json.*;

import java.util.List;
import java.util.Random;

import org.bson.Document;
/**
 * Controller class contains the main logic for calculating number of drivers
 * @author Rob Reid
 *
 */
public class Controller {
	
	/**
	 * Creates a calculator Object of type ORSfactory.
	 */
	private static ORSfactory calculator = new ORSfactory();
	
	/**
	 * Creates dbInter object of type DatabaseParse.
	 */
	private static DatabaseParse dbInter = new DatabaseParse();
	//Change this for different mongoDBconnection
	/**
	 * Creates key Object of type String.
	 */
	private static final String key = "mongodb+srv://ecko:clusterbasepass@cluster0.fp474.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
	
	/**
	 * Creates MongoInter Object of type MongoInterface.
	 */
	private static MongoInterface MongoInter = new MongoInterface(key);
	 
	//Change this to increase data set
	/**
	 * Creates numPassengers Object of type int.
	 */
	private final static int numPassengers = 1;
	/**
	 * Creates Locations Object of type ArrayList.
	 */
	private static ArrayList<Location> Locations = new ArrayList<>();
	/**
	 * Creates TargetMinutes Object of type int.
	 */
	private static final int TargetMinutes = 5;
	//Change this to increase maxQuerySize for system evolution
	/**
	 * Creates maxQuerySize Object of type int.
	 */
	private static final int maxQuerySize = 30;
	
	
	/**
	 * Main contains code for the Lyfter Algorithm in calculating number of drivers required 
	 * for 100 theoretical passengers given a data set of potential locations in mongoDB. 
	 * @param args Object of type String[]
	 */
	public static void main(String[] args) {
		List<Document> listOfLocations = MongoInter.getDocuments();
		//Here we get from the database and use the dbInter class to parse the JSON response
		//This is done using string manipulation because it was more convenient. 
		for(Document index : listOfLocations) {
			Location tempLocation = dbInter.of(dbInter.getCoordinates(index.toString()));
			Locations.add(tempLocation);
		}
		//No we know the amount of passengers we want so lets make them first
		ArrayList<Passenger> passengers = populatePassengers();
		//printPassengers(passengers); 
		//Now here is where the algorithm comes in
		ArrayList<Driver> drivers = new ArrayList<>();
		boolean optimizing = true;
		Random random = new Random();
		int rStart;
		int numDrivers = 0;
		boolean invalidStart = false;
		double totalTime = 0;
		//Starts HERE
		while(optimizing) {
			totalTime = 0;
			ArrayList<Person> peopleList = new ArrayList<Person>();
			//find the first available start location that doesn't match any other drivers
			
			do {
				rStart = random.nextInt(Locations.size() - 1);
				invalidStart = false;
					for(Driver d : drivers) {
						if(d.getStartLoc().equals(Locations.get(rStart))) { invalidStart = true; };
					}
			}while(invalidStart);
			drivers.add(new Driver(Locations.get(rStart),"driver"));
			
			numDrivers+=1;
			//The correct size of one row 
			int length = (passengers.size() + numDrivers*maxQuerySize);
			double[][] distances = new double[numDrivers][length];
			//We want the rows of the matrix to be the {driver, passenger, passenger....}
			
			String q;
			String res;
			for(int d = 1; d <= numDrivers; d++) {
				int counter = 0;
				//add driver d - 1 first to peopleList
				peopleList.add(drivers.get((d-1)));
				for(int i = 0; i < passengers.size(); i++) {
					//If the passenger number is a multiple of d
					if(i%d == 0) {
						//Check if the peopleList is too large for ORS we do this in multiple of 10
						if(peopleList.size() % maxQuerySize == 0) {
							//Create a temp query
							q = calculator.getQuery(peopleList);
							res = calculator.getDistance(q);
							double[] temp = parseResponse(res,1);
							//add the whole temp query to whatever the index we are at in the distances[d][i] 
							for(int addTodistancesD = 1; addTodistancesD < temp.length; addTodistancesD++) {
								distances[(d-1)][counter] = temp[addTodistancesD]/60; //so its in minutes
								//increment so we know the position to insert new dstances for the next query
								counter+=1;
							}
							//clear the list
							peopleList.clear();
							//add the driver we are on
							peopleList.add(drivers.get((d-1)));
						}
						//add the person
						peopleList.add(passengers.get(i));
					}
				}
				//when we are done adding people do the next query
				q = calculator.getQuery(peopleList);
				res = calculator.getDistance(q);
				double[] temp = parseResponse(res,1);
				//final for loop to add the rest of the distances to distancesD
				for(int addTodistancesD = counter; addTodistancesD < temp.length; addTodistancesD++) {
					distances[(d-1)][counter] = temp[addTodistancesD]/60;
				}
				//This should be the format
				//for each driver reset the counter
				counter = 0;
			}
			//Now thats its filled lets just loop through it
			for(int x = 0; x < distances.length; x++) {
				for(int y = 0; y < distances[x].length; y++) {
					if(distances[x][y]!=0) {
						totalTime += (distances[x][y]);
					}
				}
			}
			if(((totalTime)/numPassengers) < TargetMinutes) {
				//We will probably add up all of the time and divide this by the number of drivers
				optimizing = false;
			}
			
		}
		System.out.println("average time: "+ (totalTime)/numPassengers);
		System.out.println("number of drivers required for" + numPassengers + " passengers " + numDrivers);
	}
	
	/**
	 * Method for printing out an array of passengers
	 * @param passengers array of passengers
	 */
	public static void printPassengers(ArrayList<Passenger> passengers) {
		int count = 1;
		for(Passenger pas : passengers) {
			System.out.println(count + " " + pas.toString());
			count +=1;
		}
	}
	
	/**
	 * Method for creating a predefined number of Passenger objects and returning an array of them
	 * @return Passenger[numPassengers] 
	 */
	public static ArrayList<Passenger> populatePassengers() {
		ArrayList<Passenger> passengers = new ArrayList<>();
		int rStart = 0;
		for(int x = 0; x < numPassengers; x++) {
			//Generate a random number between 0 and the Locations List size
			Random random = new Random();
			boolean invalidStart = false;
			
			int rEnd = random.nextInt(Locations.size() - 1);
			//Next lets loop through the people list to make sure the start location is not already chosen
			do {
			 rStart = random.nextInt(Locations.size() - 1);
			 invalidStart = false;
				for(Passenger p : passengers) {
					//We want to see if a person exists already with this start location
					if(p.getStartLoc().equals(Locations.get(rStart))){
						invalidStart = true;
					}
				}
			}while(invalidStart);
			invalidStart = false;
			//obviously once we have broken out of the loop we know we got a good start location
			//Dont care about where the passenger is going it doesn't really matter
			Passenger tempP = new Passenger(Locations.get(rStart), "passenger", Locations.get(rEnd));
			
			passengers.add(tempP);
		}
		return passengers;
	}
	
	/**
	 * Returns the arrays for each driver corresponding to their current
	 * location and each passenger pickup location
	 * @param string Object of type String.
	 * @param numDriver Object of type int.
	 * @return distances Object of type double[].
	 */
	public static double[] parseResponse(String string, int numDriver) {
		numDriver = numDriver - 1; //subtract such that the input to this function start at 0
		JSONObject res = new JSONObject(string);
		ArrayList<String> list = new ArrayList<String>();
		//System.out.println(string);
		JSONArray jsonArray = new JSONArray();
		try {
			 jsonArray = (JSONArray)res.get("durations"); 
		}catch(JSONException e) {
			System.out.println(res);
			System.exit(0);
		}
		
		if (jsonArray != null) { 
		   int len = jsonArray.length();
		   for (int i=0;i<len;i++){ 
		    list.add(jsonArray.get(i).toString());
		   } 
		} 
		double[] distances = new double[list.size()];
		for(int y = 0; y < numPassengers; y++) {
			String[] values = list.get(numDriver).split(",");
			for(int x = 1; x < values.length; x++) {
					values[x] = values[x].replace("[", "");
					values[x] = values[x].replace("]", "");
					distances[x] = Double.parseDouble(values[x]);
			}
		}
		return (distances);
	}
	
	/**
	 * Get closest method returns index of person closest to the driver
	 * @param durations Object of type Double ArrayList.
	 * @param numDriver Object of type int.
	 * @return minIndex Object of type int.
	 */
	private static int getClosest(ArrayList<Double> durations, int numDriver) {
		double min = durations.get(numDriver);
		//The way the matrix is returned, we always start at the driverNum bc
		//driverNum - 1 in the matrix table is always 0 as it is the distance from 
		//driver start location to the driver start location
		int minIndex = 0;
		//first duration is 0 because it is driver to driver duration 
		for(int i = 0; i < durations.size(); i ++) {
			double curr = durations.get(i);
			if(curr !=0.0) {
				if(min > curr) {
					min = curr;
					minIndex = i;
				}
			}
		}
		return minIndex;
	}
	
	
}
