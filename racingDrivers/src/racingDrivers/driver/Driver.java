package racingDrivers.driver;

import racingDrivers.util.Results;
import racingDrivers.util.MyLogger;
import racingDrivers.util.FileProcessor;
import racingDrivers.util.MyLogger.DebugLevel;
import racingDrivers.driverStates.RaceContextClass;
import racingDrivers.store.Store;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

/**
 * @author Devina Dhuri
 */

public class Driver 
{
	public static void main(String[] args)
	{
		String inFile="";
		String drivers, line;
		String[] state;
		int driver;
		String OutFile="";
		int debugValue = -1;
		float data = 0;
		DebugLevel debugLevel = null;
		int sum;		
		try
		{
			//validation check for arguments.
			if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}"))
			{
				throw new IllegalArgumentException("Error Illegal Number of Arguments");
			}	
			else if(args.length == 3)
			{
				if(args[0] != null && !args[0].equals("${arg0}")) 
				{
            		inFile = args[0];
            	}
				else 
				{
            		throw new IllegalArgumentException("Invalid input file");
            	}
            	if(args[1] != null && !args[1].equals("${arg1}")) 
				{
            		OutFile = args[1];
            	}
            	else {
            		throw new IllegalArgumentException("Invalid output file");
            	}
            	if(args[2] != null && !"".equals(args[2])) 
				{
            		try 
					{
            			debugValue = Integer.parseInt(args[2]);
						if(!(debugValue >= 0 && debugValue <= 4)) 
						{
							throw new NumberFormatException("Debug value must be integers between 0 and 4 inclusive");
						}
						MyLogger.setDebugValue(debugValue);
            		}
            		catch(NumberFormatException e) 
					{
            			System.err.println("Exit from Driver : Exiting Program");
						System.err.println(e.getMessage());
						e.printStackTrace();
						System.exit(1);
            		}
            	}
            	else 
				{
            		throw new IllegalArgumentException("Please enter debug value");
            	}
				
				
				File file=new File(inFile);
				boolean exists = file.exists();
				
				//checks of File exists.
				if(exists == false)
				{
					throw new FileNotFoundException("Error File Not Found");
				}
				FileProcessor fp = new FileProcessor(inFile);
				RaceContextClass race ;
				Store store;
				String[] tmp ;
				
				drivers = fp.readLine();
				
				if(drivers==null)
				{
					throw new Exception("Empty input file");
				}
				driver =  Integer.parseInt(drivers);				
				race = new RaceContextClass(driver);
				Results results = new Results(OutFile,driver);
				state = new String[driver];
				store = Store.getInstance(driver);
				line = fp.readLine();
				
				//Reading a file line by line
				while(line != null)
				{
					state = race.parseInput(line);
					MyLogger.writeMessage("State result of each driver added to Results", MyLogger.DebugLevel.IN_RESULTS);
					if(debugValue != 0)
						results.writeToStdout(state);
					results.writeToFile(state);
					line = fp.readLine();
				}
				results.closess();	
			}
		}
		catch(NumberFormatException e) 
		{
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		
		catch(IllegalArgumentException e) 
		{ 
			
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		catch(FileNotFoundException e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
}
