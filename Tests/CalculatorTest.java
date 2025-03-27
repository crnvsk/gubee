package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public boolean isEven(int numero) {
        return numero % 2 == 0;
    }
}

public class CalculatorTest {

    @Test
    public void testSomar() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.sum(2, 3));
        assertEquals(0, calc.sum(-2, 2));
    }

    @Test
    public void testMultiplicar() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(0, calc.multiply(0, 5));
    }

    @Test
    public void testEhPar() {
        Calculator calc = new Calculator();
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(5));
    }
}
