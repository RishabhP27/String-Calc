package io.myprac;

public class StringCalculator 
{
	public int Add(String numbers)
	{
		if(numbers.isEmpty())
		{
			return 0;
		}
		
		else if(numbers.length()==1)
		{
			return Integer.parseInt(numbers);
		}
		
		else
		{
			String[] num = numbers.split(",");
			return Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
		}

	}
	
}


