package io.myprac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest 
{
	StringCalculator cal;

	@BeforeEach
	void init()
	{
		cal = new StringCalculator();
	}
	
	@Test
	void whenEmptyString()
	{
		assertEquals(0, cal.Add(""), "When Empty should return zero");
	}
	
	@Test
	void whenSingleString()
	{
		assertEquals(1, cal.Add("1"), "When single string, should return the same string");
	}
}
