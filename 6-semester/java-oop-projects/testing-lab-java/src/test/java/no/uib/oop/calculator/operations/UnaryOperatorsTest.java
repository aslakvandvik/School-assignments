package no.uib.oop.calculator.operations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnaryOperatorsTest {
    UnaryOperator factorial = OperatorProvider.getFactorial();
    UnaryOperator log = OperatorProvider.getLog();
    UnaryOperator ln = OperatorProvider.getLn();
    UnaryOperator root = OperatorProvider.getRoot();

    // Tests for factorial operator
    @Test
    void factorialCalculate() {
        assertEquals(1, factorial.calculate(0));
        assertEquals(1, factorial.calculate(1));
        assertEquals(120, factorial.calculate(5));
        assertEquals(3628800, factorial.calculate(10));
        assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-1));// Factorial is not defined for negative numbers
        assertThrows(IllegalArgumentException.class, () -> factorial.calculate(1.5));// Factorial is not defined for non-integer numbers
        assertTrue(Double.isNaN(factorial.calculate(Double.NaN)));// Factorial of NaN should be NaN
    }

    @Test
    void factorialGetSymbol() {
        assertNotNull(factorial.getSymbol());
        assertFalse(factorial.getSymbol().isBlank());
    }

    @Test
    void factorialGetDescription() {
        assertNotNull(factorial.getDescription());
        assertFalse(factorial.getDescription().isBlank());
    }
    // Tests for  Log operator
    @Test
    void logCalculate() {
        assertEquals(0.0, log.calculate(1));
        assertEquals(1.0, log.calculate(10));
        assertEquals(2.0, log.calculate(100));
        assertEquals(3.0, log.calculate(1000));

    }
    @Test
    void logGetSymbol() {
        assertNotNull(log.getSymbol());
        assertFalse(log.getSymbol().isBlank());
    }

    @Test
    void logGetDescription() {
        assertNotNull(log.getDescription());
        assertFalse(log.getDescription().isBlank());
    }

    @Test
    void logSpecialCases() {
        // negative input should return NaN
        assertTrue(Double.isNaN(log.calculate(-1)));

        // log(0) should be -Infinity
        assertEquals(Double.NEGATIVE_INFINITY, log.calculate(0));

        // log(+Infinity) should be +Infinity
        assertEquals(Double.POSITIVE_INFINITY, log.calculate(Double.POSITIVE_INFINITY));
    }
    // Tests for Ln operator
    @Test
    void lnCalculate() {
        assertEquals(0.0, ln.calculate(1));
        assertEquals(1.0, ln.calculate(Math.E));
        assertTrue(Double.isNaN(ln.calculate(-1))); // negative -> NaN
        assertEquals(Double.NEGATIVE_INFINITY, ln.calculate(0)); // log(0) = -Infinity
    }
    @Test
    void lnGetSymbol() {
        assertNotNull(ln.getSymbol());
        assertFalse(ln.getSymbol().isBlank());
    }

    @Test
    void lnGetDescription() {
        assertNotNull(ln.getDescription());
        assertFalse(ln.getDescription().isBlank());
    }
    // Tests for Root operator
    @Test
    void rootCalculate() {
        assertEquals(0.0, root.calculate(0));
        assertEquals(1.0, root.calculate(1));
        assertEquals(2.0, root.calculate(4));
        assertEquals(3.0, root.calculate(9));
        assertEquals(0.7071, root.calculate(0.5), 0.001);
        assertTrue(Double.isNaN(root.calculate(-1))); // negative -> NaN
    }

    @Test
    void rootNegativeZero() {
        double res = root.calculate(-0.0);
        assertEquals(Double.doubleToLongBits(-0.0), Double.doubleToLongBits(res));
    }
    
    @Test
    void rootGetSymbol() {
        assertNotNull(root.getSymbol());
        assertFalse(root.getSymbol().isBlank());
    }

    @Test
    void rootGetDescription() {
        assertNotNull(root.getDescription());
        assertFalse(root.getDescription().isBlank());
    }
}
