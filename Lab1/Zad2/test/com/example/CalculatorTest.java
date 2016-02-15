package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
private Calculator calc = new Calculator();
	
	@Test
	public void addCheck(){
		System.out.println("AddCheck: " + calc);
		assertEquals(5.3,calc.add(3.3,2.0),0); //==?
	}

	@Test
	public void subCheck(){
		System.out.println("SubCheck: " + calc);
		assertEquals(1,calc.sub(3.2,2.2),0); //==?
	}
	
	@Test
	public void multiCheck(){
			assertEquals(6.4,calc.multi(3.2,2.0),0); //==?
	}
	
	@Test//(expected = ArithmeticException.class)
	public void div2Check(){
			assertEquals(6,calc.div(3.2,0),0); //==?
	}
	
	@Test
	public void divCheck(){
			assertEquals(2.0,calc.div(6.4,3.2),0); //==?
	}
	
	@Test
	public void greaterCheck(){
			assertEquals(true,calc.greater(3.4,2.1)); //==?
	}

}
