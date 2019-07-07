package racingDrivers.driverStates;

import racingDrivers.driverStates.States;
import racingDrivers.driverStates.States.State;

public interface DriverStateI
{
	public void enterDistance(double distance, int index);
	public State calculateState(int i);
}
