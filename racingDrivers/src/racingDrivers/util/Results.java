package racingDrivers.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Devina Dhuri
 */
 
public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{
	private String outFile;
	private PrintWriter writer;
	private BufferedWriter bw;
	int driverNo;
	private String[] result = new String[100]; //dataStructure to store the testMethods
	int sizeResult = 0;
	
	//Constructor 
	/**
	* @param outFile output file where result has to be written
	* @param driver number of drivers
	*/
	public Results(String outFile, int driver) 
	{
		this.outFile = outFile;
		MyLogger.writeMessage("Results constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.driverNo = driver;
		try
		{
		    bw = new BufferedWriter(new FileWriter(outFile));
		}
		catch (IOException e) 
		{
			System.err.println("Exit from Results Program");
			System.err.println("Error in file: Cannot open file");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	/**
	 * This Function will write output to the file.
	 * @param s String array holding the state of mind of the drivers at a given time 
	 * @return None
	 */
	public void writeToFile(String[] s)
	{
		try
		{
			for (String line : s) 
			{
				bw.write(line + " ");
			}
			MyLogger.writeMessage( "Results is being written to file", MyLogger.DebugLevel.FROM_RESULTS);
			bw.write("\n");
		}
		catch (IOException e) 
		{
			System.err.println("Exit from Results Program");
			System.err.println("Error writing to file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	* This Function will write output to the terminal.
	* @param s String array holding the state of mind of the drivers at a given time 
	* @return None
	*/	
	public void writeToStdout(String[] s) 
	{
		System.out.println(Arrays.toString(s).replace("[", "").replace(",", "").replace("]", ""));
	}
	
	/**
	* This Function will closes the open file stream once all content is written in it.
	* @param None
	* @return None
	*/
	public void closess()
	{
		try
		{
			bw.close();
		}
		catch (IOException e) 
		{
			System.err.println("Exit from Results Program");
			System.err.println("Error closing the file");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Output FileName:" + outFile + " \n " + "No of Driver are:" + driverNo + "\n" + "--------------------------" + "\n" ;
	}
}
