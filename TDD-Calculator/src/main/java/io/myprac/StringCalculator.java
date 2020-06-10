package io.myprac;

public class StringCalculator 
{
	
	static String delimiter;

	public int Add(String numbers)
	{
	
		delimiter = ",|\n";
		if(numbers.startsWith("//"))
		{
			String[] str = numbers.split("\n", 2);
			delimiter = str[0].substring(2);
			numbers = str[1];
			
			return StringCalculator.getSum(numbers);
		}
		else if(numbers.isEmpty())
		{
			return 0;
		}
		
		else if(numbers.length()==1)
		{
			return Integer.parseInt(numbers);
		}
		
		else
		{
			
		 	return StringCalculator.getSum(numbers);
		}

	}
	
	static int getSum(String a) 
	{
		
		
		String[] num = a.split(delimiter);
		int i=0;
		for(String str : num)
		{
			i += Integer.parseInt(str);
		}
		return i;
	}
	
}


