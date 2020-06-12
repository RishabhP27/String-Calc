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
			numbers = str[1];
			if(delimiter.startsWith("["))
				{
					if(!delimiter.contains("]["))
					{	
						delimiter = Pattern.quote(delimiter.substring(1, delimiter.length()-1));
					}
					else
					{
						String[] s = delimiter.split(("]\\["),2);
						String a = s[0].substring(1);
						String b = s[1].substring(0,1);
						if(a.length()==b.length())
							delimiter = "[\\"+a+"\\"+b+"]+";
					}
				}
			
			return StringCalculator.getSum(numbers,delimiter);
		}
		
		else if(numbers.length()==1)
		{
			return Integer.parseInt(numbers);
		}
		
		else
		{
		 	return StringCalculator.getSum(numbers,delimiter);
		}

	}
	
	static int getSum(String a,String del)
	{
		String[] num = a.split(del);
		String s = "";
		int i=0;
		for(String str : num)
			{	
				if(Integer.parseInt(str)<0)
					{
						s=s+str;
					}
				if(Integer.parseInt(str)>1000)
				{
					continue;
				}
				i += Integer.parseInt(str);
			}
			
		if(!s.isEmpty())
		{throw new RuntimeException("negetives not allowed "+s);}
		
		return i;
	}
	
	public int getCalledCount()
	{
		
		return c;
	}
	
}


