package myCLIHangman;

public class myRandom {

	public int randomIntegerNumber (int min, int max)
	{
		int randomInteger = (int)(Math.random()*((max-min)+1))+min;
		//System.out.println("TEST: randomInteger generated: " + randomInteger);
		
		return randomInteger;
	}
	
	public int randomIndex (int length)
	{
		int minimum = 2;
		int maximum = length - minimum;
		int randomIndex = randomIntegerNumber(minimum, maximum);
		
		//System.out.println("TEST: randomIndex: " + randomIndex + "generated from minimum of " + minimum + " and maximum of " + maximum);
		return randomIndex;
	}
}
