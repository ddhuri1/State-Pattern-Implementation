package racingDrivers.store;

import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;
import java.util.Collections;
import java.util.ArrayList;

/**
 * @author Devina Dhuri
 */
 
public class Store
{
	private String[] temp;
	private double distance[]; 
	public int driver;
	private int driverPositions[]; 
	private String[] pos;
	public ArrayList<String> ar = new ArrayList<String>();;
	private static Store single_instance = null;
	
	//constructor
	/**
	* @param driver number of drivers
	*/
	private Store(int driver)	
	{
		MyLogger.writeMessage("Store constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		this.driver=driver;
		distance = new double[driver];
		driverPositions = new int[driver]; 
		pos = new String[driver];
	}

	/**
	* This is used to access the singleton object outside the class
	* @param driver Number of drivers
	* @return single_instance Object reference of singleton
	*/
	//Source: https://www.geeksforgeeks.org/singleton-class-java/
	public static Store getInstance(int driver) 
    { 
        if (single_instance == null) 
            single_instance = new Store(driver); 
  
        return single_instance; 
    } 

	/**
	* This counts occurrences of the distance covered 
	* @param arr[] Distance array that holds the distances of the drivers
	* @param x the distance whose occurrence has to be calculated
	* @return res Occurrences of distances
	*/
	public int countOccurrences(double arr[], double x) 
    { 
        int res = 0; 
        for (int i=0; i<driver; i++) 
            if (x == arr[i]) 
              res++; 
        return res; 
    } 
	
	/**
	* This Function stores the distance of each driver
	* @param dist Distance covered by the driver
	* @param index driver number
	* @return None
	*/
	public void enterDistance(double dist, int index)
	{
		distance[index] += dist;
	}
	
	/**
	* This Function will set the rank of each driver based 
	* on the distance covered by each driver 
	* @param None
	* @return None
	*/
	public void rank()
	{
		for (int i = 0; i < driver; i++) 
		{ 
            double r = 0, s = 1; 
            for (int j = 0; j < driver; j++)  
            { 
				int amount = countOccurrences(distance, distance[j]);
                if (j != i && distance[i] < distance[j] && amount == 1) 
                {
					r += 1; 
				}
				else if (j != i && distance[i] < distance[j] && amount > 1)
				{
					r += (double)1/(double)amount; 
				}
			} 
			r++;
			driverPositions[i] = (int)r;
        }  
		findPosition(driverPositions);
	}
	
	/**
	* This Function will set the position of the driver based on his rank
	* @param driverPositions[] Current position of driver
	* @return None
	*/
	public void findPosition(int driverPositions[])
	{
		double upperBound = 0.3 * driver;
		int pos;
		double lowerBound = 0.7 * driver;
		for(int i=0;i < driverPositions.length; i++)
		{
			pos = driverPositions[i];
			if((double)pos < upperBound)
			{
				if(i >= ar.size())
					ar.add(i, "LEADING");
				else
					ar.set(i, "LEADING");
			}
			else if((Math.round(upperBound) <= pos ) && (pos < Math.round(lowerBound)))
			{
				if(i >= ar.size())
					ar.add(i, "HOLDING_ON");
				else
					ar.set(i, "HOLDING_ON");
			}
			else if(pos >= Math.round(lowerBound))
			{
				if(i >= ar.size())
					ar.add(i, "LOSING");
				else
					ar.set(i, "LOSING");
			}
		}
	}
	
	/**
	* Returns the position at given index
	* @param i Given driver number
	* @return String The position of the driver
	*/
	public String getData(int i)
	{
		return ar.get(i);
	}
	
	/**
	* Print the position array
	* @param None
	* @return None
	*/
	public void print()
	{
		System.out.println(ar);
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Number of divers:"  + driver ;
	}
	
	/**
	* Accessors and Mutators for the data members.
	*/
	
	/**
	* This Function will return total drivers
	* @param None
	* @return driver The number of drivers
	*/
	public int getDriver() 
	{
		return driver;
	}
	
	/**
	* This Function will set the no of drivers
	* @param driver Number of drivers
	* @return None
	*/
	public void setDriver(int driver) 
	{
		this.driver = driver;
	}
	
	/**
	* This Function will return the rank of all drivers
	* @param None
	* @return driverPositions integer array of driver rank
	*/
	public int[] getDriverPositions() 
	{
		return driverPositions;
	}
	
	/**
	* This Function will set the rank of all drivers
	* @param None
	* @return driverPositions integer array of driver rank
	*/
	public void setDriverPositions(int driverPositions[]) 
	{
		this.driverPositions = driverPositions;
	}
	
}
