package no.uib.oop.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CalculatorOperatorTest {

	private Calculator calculator = new Calculator();

	@Test
    void testGetOperatorSymbols() {
        List<String> operators = calculator.getOperatorSymbols();
        assertTrue(3 <= operators.size());
        assertTrue(operators.contains("+"));
        assertTrue(operators.contains("-"));
        assertTrue(operators.contains("*"));
    }

    @Test
    void testEvaluateSimpleAddition() {
		String operator = "+";
		double num1 = 5.0;
		double num2 = 3.0;

        assertEquals(8.0, calculator.evaluate(num1, num2, operator), 0.001);
    }

    @Test
    void testEvaluateSimpleSubtraction() {
        String operator = "-";
		double num1 = 10.0;
		double num2 = 4.0;

        assertEquals(6.0, calculator.evaluate(num1, num2, operator), 0.001);
    }

    @Test
    void testEvaluateSimpleMultiplication() {
        String operator = "*";
		double num1 = 7.0;
		double num2 = 3.0;

        assertEquals(21.0, calculator.evaluate(num1, num2, operator), 0.001);
    }

}
