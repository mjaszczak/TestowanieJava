package com.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KalkulatorTest {

    private Kalkulator calc = new Kalkulator();

    @Test
    public void addCheck(){
        System.out.println("AddCheck: " + calc);
        assertEquals(5,calc.add(3,2)); //==?
    }

    @Test
    public void subCheck(){
        System.out.println("SubCheck: " + calc);
        assertEquals(1,calc.sub(3,2)); //==?
    }

    @Test
    public void multiCheck(){
        assertEquals(6,calc.multi(3,2)); //==?
    }

    @Test(expected = ArithmeticException.class)
    public void div2Check(){
        assertEquals(6,calc.div(3,0)); //==?
    }

    @Test
    public void divCheck(){
        assertEquals(1,calc.div(3,2)); //==?
    }

    @Test
    public void greaterCheck(){
        assertEquals(true,calc.greater(3,2)); //==?
    }
}
