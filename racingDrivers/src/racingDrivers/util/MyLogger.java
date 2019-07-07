package racingDrivers.util;

public class MyLogger {

    /**
	 * DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
     * DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
     * DEBUG_VALUE=2 [Print to stdout everytime an output is added to Results]
     * DEBUG_VALUE=1 [Print to stdout everytime Results is written to File]
     * DEBUG_VALUE=0 [No output is printed from the application to stdout. It writes to the output file though" ]
     */

	public static enum DebugLevel 
	{
    	CONSTRUCTOR,
		IN_RUN,
		IN_RESULTS,
		FROM_RESULTS,
		RELEASE
	};
	
	private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) 
	{
    	switch (levelIn) 
		{
    		case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
				break;
    		case 3: debugLevel = DebugLevel.IN_RUN; 
				break;
    		case 2: debugLevel = DebugLevel.IN_RESULTS; 
				break;
    		case 1: debugLevel = DebugLevel.FROM_RESULTS; 
				break;
    		case 0: debugLevel = DebugLevel.RELEASE; 
				break;
    	}
    }

    public static void setDebugValue (DebugLevel levelIn) 
	{
    	debugLevel = levelIn;
    }

     /**
	 * @param String message to be displayed for given debug value
	 * @param levelIn debug value specified on command line.
	 * @return None
	 */
    public static void writeMessage (String  message, DebugLevel levelIn ) 
	{
		if (levelIn == debugLevel)
			System.out.println(message);
    }

    /**
	* @param None 
	* @return String
	*/
    public String toString() 
	{
    	return "Debug Level is " + debugLevel;
    }
}