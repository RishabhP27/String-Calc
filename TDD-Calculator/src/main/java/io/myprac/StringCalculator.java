package io.myprac;

import java.util.regex.Pattern;

public class StringCalculator 
{

	static int c;
	static String delimiter;

	public int Add(String numbers)
	{
		c++;
		if(numbers.isEmpty())
		{
			return 0;
		}
		delimiter = ",|\n";
		if(numbers.startsWith("//"))
		{
			String[] str = numbers.split("\n", 2);
			delimiter = str[0].substring(2);
			if(delimiter.startsWith("["))
			{
				delimiter = Pattern.quote(delimiter.substring(1, delimiter.length()-1));
			}
			numbers = str[1];
			
			return StringCalculator.getSum(numbers);
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
		String s = "";
		for(String str : num)
			{	
				if(Integer.parseInt(str)<0)
					{
						s=s+str;
					}
			}
		if(!s.isEmpty())
		{throw new RuntimeException("negetives not allowed "+s);}
		
		int i=0;
		for(String str : num)
		{
			if(Integer.parseInt(str)>1000)
			{
				continue;
			}
			i += Integer.parseInt(str);
		}
		return i;
	}
	
	public int getCalledCount()
	{
		
		return c;
	}
	
}


