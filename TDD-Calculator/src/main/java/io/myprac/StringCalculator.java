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
		 	return StringCalculator.getSum(numbers);
		}

	}
	
	static int getSum(String a)
	{
		String[] num = a.split(",|\n");
		int i=0;
		for(String str : num)
		{
			i += Integer.parseInt(str);
		}
		return i;
	}
	
}


