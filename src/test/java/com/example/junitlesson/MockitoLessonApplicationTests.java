package com.example.junitlesson;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoLessonApplicationTests {

	@InjectMocks
	CalculatorServiceImpl calculatorServiceImpl;

	@Test
	public void multiplyNormal()
	{
		//test
		int multiplyingResult = calculatorServiceImpl.multiply(6, 2);
		assertEquals(12, multiplyingResult);
	}

	@Test
	public void multiplyZero()
	{
		//test
		int multiplyingResult = calculatorServiceImpl.multiply(0, 0);
		assertEquals(0, multiplyingResult);
	}

	@Test
	public void multiplyxZero()
	{
		//test
		int multiplyingResult = calculatorServiceImpl.multiply(05, 5);
		assertEquals(25, multiplyingResult);
	}

	@Test
	public void multiplyxMinus()
	{
		//test
		int multiplyingResult = calculatorServiceImpl.multiply(-30, 4);
		assertEquals(-120, multiplyingResult);
	}

	@Test
	public void multiplyMinus()
	{
		//test
		int multiplyingResult = calculatorServiceImpl.multiply(-3, -3);
		assertEquals(9, multiplyingResult);
	}

	@Test
	public void divideNormal1() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(9, 3);
		assertEquals(3, dividingResult,0);
	}

	@Test
	public void divideNormal2() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(20, 30);
		assertEquals(0.66, dividingResult, 0.5);
	}

	@Test
	public void divideyMinus() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(4, -2);
		assertEquals(-2, dividingResult, 0);
	}

	@Test
	public void divideMinus() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(-9, -2);
		assertEquals(2, dividingResult, 2);
	}

	@Test
	public void dividexZero() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(0, 9);
		assertEquals(0, dividingResult, 0);
	}

	@Test
	public void dividexDecimal() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(9.0, 2);
		assertEquals(4.5, dividingResult, 1.0);
	}

	@Test
	public void divideDecimal() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(4.2, 2.2);
		assertEquals(1.9, dividingResult, 0);
	}

	@Test
	public void divideNormal3() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(07, 2);
		assertEquals(2, dividingResult, 2);
	}

	@Test
	public void divideNormal4() throws CalculatorException
	{
		//test
		double dividingResult = calculatorServiceImpl.divide(4, 02);
		assertEquals(2, dividingResult, 2);
	}

	@Test
	public void divideyZero() throws CalculatorException
	{
		//test
		Assertions.assertThrows(CalculatorException.class, () -> {
			calculatorServiceImpl.divide(4, 0);
	    });
	}
}

