package racingDrivers.driverStates;

/**
 * @author Devina Dhuri
 */

import racingDrivers.driverStates.RecklessState;
import racingDrivers.driverStates.DriverStateI;
import racingDrivers.driverStates.States;
import racingDrivers.driverStates.States.State;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

public class DriverContextClass implements DriverContextI
{
	State state;
	String stateName = "";
	private DriverStateI currentState; 
	
	//constructor
	public DriverContextClass() 
	{
		MyLogger.writeMessage("DriverContextClass constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		currentState = new RecklessState(); 
	}

	/**
	* This Function sets the current state of the driver for the next iteration
	* @param statedriver Object of DriverStateI
	* @return None
	*/
	public void setState(DriverStateI statedriver)  
    { 
        currentState = statedriver; 
    } 

	/**
	* This Function will call a function to store the distance for teh current driver
	* @param distance Distance covered by the driver at that minute 
	* @param index Driver number
	* @return None
	*/
	public void enterDistance(double distance, int index)
	{
		currentState.enterDistance(distance, index);
	}
	
	/**
	* This Function will call calculate state on current driver state 
	* @param i Driver number
	* @return None
	*/
	public void calculateState(int i)
	{
		state = currentState.calculateState(i);
	}
	
	/**
	* This Function will set the state of each driver
	* @param None
	* @return String the new state change
	*/
	public String finalState()
	{
		if(state == State.CONFIDENT)
		{
			MyLogger.writeMessage("State changed to CONFIDENT", MyLogger.DebugLevel.IN_RUN);
			currentState = new ConfidentState();
			stateName = "CONFIDENT";
		}
		else if(state == State.CALCULATIVE)
		{
			MyLogger.writeMessage("State changed to CALCULATIVE", MyLogger.DebugLevel.IN_RUN);
			currentState = new CalculativeState();
			stateName = "CALCULATIVE";
		}
		else 
		{
			MyLogger.writeMessage("State changed to RECKLESS", MyLogger.DebugLevel.IN_RUN);
			currentState = new RecklessState();
			stateName = "RECKLESS";
		}
		return stateName;
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------DRIVER CONTEXT CLASS TO SET STATES OF THE DRIVERS------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) ;
	}
}
