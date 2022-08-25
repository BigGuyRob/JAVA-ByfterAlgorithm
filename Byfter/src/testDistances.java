
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

	/**
	 * TestDistances class holds the logic for JUnit tests.
	 * @author Kiernan
	 *
	 */
	class TestDistances {
		/**
		 * Creates tolerance Object of type double.
		 */
		public static double tolerance = 3; //minutes
		
		/**
		 * Creates calculator Object of type ORSfactory.
		 */
		public static ORSfactory calculator = new ORSfactory();
			
		/**
		 * test() executes the necessary JUnit testing modules.
		 */
		@Test
		void test() {
				Location A;
				Location B;
				//Google Distance = 7
				//ORS Distance = 7.7
				double test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.44080100967638,40.523481621316265);
				Passenger a = new Passenger(A, "passenger", new Location(11,12));
				Driver b = new Driver(B, "driver");
				ArrayList<Person> peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				String f = calculator.getDistance(calculator.getQuery(peopleList));
				double[] Driver1times = Controller.parseResponse(f,1);
				double test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//---------------------------------------------------------------------
				//Google Distance = 1
				//ORS Distance = 2.08
				test1a = 1;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.44951347823697,40.50260483141019);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 6.26
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.4654890504415,40.51387890064649);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 6.7
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.45944338580728,40.52478453467858);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 4.9
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.43437829061803,40.48616890570609);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 8
				//ORS Distance = 6.79
				test1a = 8;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.46734198620747,40.523616163291486);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 8.25
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.43882998297394,40.52581471578155);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 4
				//ORS Distance = 1.98
				test1a = 4;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.4481750474136,40.49506775499927);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 1.1
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.45371204231314,40.497072231318185);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 1.9
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.44963002319015,40.49595673972159);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 3
				//ORS Distance = 1.48
				test1a = 3;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.4562346170299,40.496577019434156);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 7.61
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.44060405110307,40.517451789063706);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 2.2
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.45254580584074,40.501635484608656);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 1.26
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.4548956455851,40.50017634258972);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 0.72
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.4505628968932,40.49853328152169);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 2
				//ORS Distance = 1.13
				test1a = 2;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.44676854804456,40.49701259859405);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 8
				//ORS Distance = 7.05
				test1a = 8;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.45583458933707,40.52090393139715);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 8
				//ORS Distance = 7.94
				test1a = 8;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.46252486959241,40.52397394425372);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
				//-----------------------------------------------------------------------
				//Google Distance = 7
				//ORS Distance = 7.55
				test1a = 7;
				A = new Location(-74.44836856814132,40.499544446918364);
				B = new Location(-74.46049506152382,40.52002706720062);
				a = new Passenger(A, "passenger", new Location(11,12));
				b = new Driver(B, "driver");
				peopleList = new ArrayList<Person>();
				peopleList.add(a);
				peopleList.add(b);  
				f = calculator.getDistance(calculator.getQuery(peopleList));
				Driver1times = Controller.parseResponse(f,1);
				test1b = Driver1times[1]/60;
				assertTrue(Math.abs(test1a-test1b) < tolerance);
			}
}
