package io.myprac;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StringCalculatorTest 
{
	static StringCalculator cal;

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
	
	@Test
	void whenTwoString()
	{
		assertEquals(1+2, cal.Add("1,2"), "When two strings, should return their sum");
	}
	
	@Test
	void whenUnknownAmountString()
	{
		assertEquals(1+2+3+4, cal.Add("1,2,3,4"), "When unknown amount of strings, should return their sum");
	}
	
	@Test
	void whenNewLineBetweenString()
	{
		assertEquals(6, cal.Add("1\n2,3"), "When new line between strings, should return their sum ");
	}
	
	@Test
	void whenDifferentDelimitersInString()
	{
		assertEquals(3, cal.Add("//;\n1;2"), "When new delimiter introduced, support the delimiter");
	}
	
	@Test 
	void whenNegetiveInString()
	{
		try 
		{
		cal.Add("-3");
		fail("Exception");
		}
		catch(RuntimeException ex)
		{assertEquals("negetives not allowed -3", ex.getMessage());}
	}
	
	@Test 
	void whenMultipleNegetiveInString()
	{
		try 
		{
		cal.Add("-3,1,-2,-7");
		fail("Exception");
		}
		catch(RuntimeException ex)
		{assertEquals("negetives not allowed -3-2-7", ex.getMessage());}
	}
	
	@Test
	void whenNumberGreaterThan1000()
	{
		assertEquals(2,cal.Add("2,1001"),"Numbers greater than 1000 should be ignored");
	}
	
	@Test
	void whenDelimiterOfAnyLength()
	{
		assertEquals(6,cal.Add("//[***]\\n1***2***3"), "Delimiters can be of any length");
	}
	
	@AfterAll
	static void numberOfTimesAddInvoked()
	{
		assertEquals(10,cal.getCalledCount(),"Return the number of times Add() invoked");
		System.out.print("Add() method called "+cal.getCalledCount()+" times.");
	}
}
