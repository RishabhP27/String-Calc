package io.myprac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest 
{

	@Test
	void whenEmptyString()
	{
		StringCalculator cal = new StringCalculator();
		assertEquals(0, cal.Add(""), "When Empty should return zero");
	}
	
	@Test
	void whenSingleString()
	{
		StringCalculator cal = new StringCalculator();
		assertEquals(1, cal.Add("1"), "When single string, should return the same string");
	}
}
