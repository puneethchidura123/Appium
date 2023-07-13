package com.org.saib.genericjavautilites;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sample {

	static int i;
	static
	{
		System.out.println("in static block");
	}
	
	{
		System.out.println("in instance block");
		i = 998;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(" in main method");
		new Sample();
		System.out.println("value of i is :: "+i);
	}
	
	
	public int getXCoordinatesDifference(String bounds)
	{
		int difference = 0;
		int x1 = Integer.parseInt(bounds.substring(1, bounds.indexOf(',')));
		int x2 = Integer.parseInt(bounds.substring(bounds.indexOf(']')+2, bounds.lastIndexOf(',')));
		difference = x2-x1;
		return difference;
	}
}
