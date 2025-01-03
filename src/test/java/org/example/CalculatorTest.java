package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private org.example.Calculator Calculator;

    @BeforeEach
    public void setUp() {
        Calculator = new Calculator();
    }

    @Test
    public void testPerformAddition() {
        Calculator.performAddition(2,3);
        assertEquals("5",Calculator.getDisplayText());

        Calculator.performAddition(-2,1);
        assertEquals("-1", Calculator.getDisplayText());
    }

    @Test
    public void testPerformASubtraction() {
        Calculator.performSubtraction(3,2);
        assertEquals("1",Calculator.getDisplayText());

        Calculator.performSubtraction(-2,1);
        assertEquals("-3", Calculator.getDisplayText());
    }

    @Test
    public void testPerformAMultiplication() {
        Calculator.performMultiplication(2,2);
        assertEquals("4",Calculator.getDisplayText());

        Calculator.performMultiplication(-2,1);
        assertEquals("-2", Calculator.getDisplayText());

    }

    @Test
    public void testPerformADivision() {
        Calculator.performDivision(6,3);
        assertEquals("2",Calculator.getDisplayText());

        Calculator.performDivision(-4,2);
        assertEquals("-2",Calculator.getDisplayText());
    }

    @Test

    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.performDivision(1, 0));
    }

}
