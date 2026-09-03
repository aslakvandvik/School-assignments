package no.uib.oop.calculator.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * Tests for all binary operators (Addition, Subtraction, Multiplication, Exponent).
 *
 * <p>For each operator we test three aspects:
 * <ol>
 *   <li><strong>calculate()</strong> — does it return the correct result?</li>
 *   <li><strong>getSymbol()</strong> — does it return the expected symbol string?</li>
 *   <li><strong>getDescription()</strong> — does it return a non-empty description?</li>
 * </ol>
 *
 * <p><strong>Students:</strong> use this class as a reference when writing
 * {@code UnaryOperatorsTest}. Your unary tests should follow the same pattern
 * but use {@link OperatorProvider} to obtain operator instances instead of
 * calling constructors directly.
 */
public class BinaryOperatorsTest {

    BinaryOperator operator;
    double num1 = 0.2;
    double num2 = 0.3;

    // ############# ADDITION #############

    // Verify that 6 + 5 == 11
    @Test
    void calculateAdditionTest() {
        operator = new Addition();

        double actual = operator.calculate(num1, num2);
        double expected = num1 + num2;
        assertEquals(expected, actual);
        
        double a = 1.99;
        double b = 2.49;
        double c = 0.99;
        assertEquals(operator.calculate(a, operator.calculate(b, c)), 5.47,0.0001);
    }

    // Verify the symbol is set and equals "+"
    @Test
    void additionSymbolTest() {
        operator = new Addition();

        assertNotNull(operator.getSymbol());
        assertFalse(operator.getSymbol().isBlank());
        assertEquals("+", operator.getSymbol());
    }

    // Verify the description is set (not null, not empty, not just whitespace)
    @Test
    void additionDescriptionNotEmptyTest() {
        operator = new Addition();

        assertNotNull(operator.getDescription());
        assertFalse(operator.getDescription().isBlank());
    }


    // ############# SUBTRACTION #############
    @Test
    void calculateSubtractionTest() {
        operator = new Subtraction();

        double actual = operator.calculate(num1, num2);
        double expected = num1 - num2;
        assertEquals(expected, actual);
    }

    @Test
    void subtractionSymbolTest() {
        operator = new Subtraction();

        assertNotNull(operator.getSymbol());
        assertFalse(operator.getSymbol().isBlank());
        assertEquals("-", operator.getSymbol());
    }

    @Test
    void subtractionDescriptionNotEmptyTest() {
        operator = new Subtraction();

        assertNotNull(operator.getDescription());
        assertFalse(operator.getDescription().isBlank());
    }

    // ############# MULTIPLICATION #############
    @Test
    void calculateMultiplicationTest() {
        operator = new Multiplication();

        double actual = operator.calculate(num1, num2);
        double expected = num1 * num2;
        assertEquals(expected, actual);
    }

    @Test
    void multiplicationSymbolTest() {
        operator = new Multiplication();

        assertNotNull(operator.getSymbol());
        assertFalse(operator.getSymbol().isBlank());
        assertEquals("*", operator.getSymbol());
    }

    @Test
    void multiplicationDescriptionNotEmptyTest() {
        operator = new Multiplication();

        assertNotNull(operator.getDescription());
        assertFalse(operator.getDescription().isBlank());
    }

    // ############# EXPONENT #############
    @Test
    void calculateExponentTest() {
        operator = new Exponent();

        double actual = operator.calculate(num1, num2);
        double expected = Math.pow(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    void exponentSymbolTest() {
        operator = new Exponent();

        assertNotNull(operator.getSymbol());
        assertFalse(operator.getSymbol().isBlank());
        assertEquals("^", operator.getSymbol());
    }

    @Test
    void exponentDescriptionNotEmptyTest() {
        operator = new Exponent();

        assertNotNull(operator.getDescription());
        assertFalse(operator.getDescription().isBlank());
    }


}
