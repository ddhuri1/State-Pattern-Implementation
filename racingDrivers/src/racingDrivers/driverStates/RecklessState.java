package racingDrivers.driverStates;

/**
 * @author Devina Dhuri
 */
 
import racingDrivers.store.Store;
import java.util.Collections;
import racingDrivers.driverStates.States;
import racingDrivers.driverStates.States.State;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;
import racingDrivers.util.MyLogger.DebugLevel;

public class RecklessState implements DriverStateI
{
	State state;
	int in =3;
	Store store;
	public RecklessState() 
	{
		MyLogger.writeMessage("Reckless State constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	private int driverNo = 0;
	/**
	* calls the function to store each driver distance
	* @param distance distance covered by each driver
	* @param index driver number
	* @return None
	*/
	public void enterDistance(double distance, int index)
	{
		store = Store.getInstance(in);
		store.enterDistance(distance, index);
		driverNo ++;
	}
	
	/**
	* Checks the current position of driver and changes state accordingly
	* @param i driver number
	* @return State State object holding change of state
	*/
	public State calculateState(int i)
	{
		String data = store.getData(i) ;
		int amount = Collections.frequency(store.ar, data);
		if(data == "LEADING" && amount == 1)
		{
			state = States.State.CONFIDENT;
			return state;
		}
		else if(data == "HOLDING_ON" && amount == 1)
		{
			state = States.State.CALCULATIVE;
			return state;
		}
			state = States.State.RECKLESS;
			return state;
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "No of Driver are:" + driverNo + "\n" + "--------------------------" + "\n" ;
	}
}
