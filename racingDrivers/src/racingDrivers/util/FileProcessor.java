package racingDrivers.util;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner; 
import java.io.File; 
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;


/**
 * @author Devina Dhuri
 */
 
public class FileProcessor 
{
	BufferedReader reader;
	FileInputStream fis;
	String line = null;
	private DebugLevel debugLevel;
	String inFile;
	int status=0;
	
	//Constructor getResultStr
	public FileProcessor(String inFile) 
	{
		this.inFile = inFile;
		try
		{
			MyLogger.writeMessage("FileProcessor constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
			fis = new FileInputStream(inFile);
			reader = new BufferedReader(new InputStreamReader(fis));
		}
		catch(Exception e)
		{
			System.err.println("Exit from File Processor : Exiting Program");
			System.err.println("Error Opening the Input File");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	* Read and return each live of given input file.
	* @param None
	* @return String single line read from file, else returns null
	*/
	
	public String readLine() throws IOException
	{
		try 
		{
			return reader.readLine();
		}
		catch (IOException e) 
		{
			System.err.println("Exit from File Processor : Exiting Program");
			System.err.println("Error Reading the Input File");
			e.printStackTrace();
			System.exit(1);
		}	
		return null;
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Input FileName:" + inFile + " \n " + "--------------------------" + "\n";
	}
}
