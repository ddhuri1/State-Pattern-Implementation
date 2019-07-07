package racingDrivers.driverStates;

/**
 * @author Devina Dhuri
 */

import racingDrivers.driverStates.DriverContextClass;
import racingDrivers.driverStates.DriverStateI;
import racingDrivers.store.Store;
import racingDrivers.driverStates.States.State;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

public class RaceContextClass
{
	String[] temp;
	double distance[]; 
	Store store;
	int driver;
	String[] state ;
	DriverContextClass[] context;
	
	
	//constructor
	/**
	* @param driver No of drivers
	*/
	public RaceContextClass(int driver)	
	{
		MyLogger.writeMessage("RaceContextClass constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.driver=driver;
		distance = new double[driver];
		state = new String[driver];
		context = new DriverContextClass[driver];
		for ( int i=0; i<driver; i++) 
		{
			context[i]=new DriverContextClass();
		}
		store = Store.getInstance(driver);
	}

	/**
	* This Function is a handler to trigger the driver context
	* @param tem The line read from the file
	* @return String[] The array storing the states of the drivers
	*/
	public String[] parseInput(String tem)
	{
		temp = tem.split(" ");
		for(int i=0;i<temp.length;i++)
		{
			distance[i] = Double.parseDouble(temp[i]);
			context[i].enterDistance(distance[i],i);
		}
		store.rank();
		 for(int i=0;i<driver;i++)
		{
			context[i].calculateState(i);
			state[i] = context[i].finalState();
		}
		return state;
	}

	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "No of Driver are:" + driver + "\n" + "--------------------------" + "\n" ;
	}
}
