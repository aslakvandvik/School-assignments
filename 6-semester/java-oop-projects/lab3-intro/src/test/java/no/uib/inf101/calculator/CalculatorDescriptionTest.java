package no.uib.this OOP course.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CalculatorDescriptionTest {

    private Calculator calculator = new Calculator();

    @Test
    void testGetOperatorDescriptions() {
        List<String> operators = calculator.getOperatorSymbols();
        for (String operatorSymbol : operators) {
            if (operatorSymbol.equals("+"))
                assertEquals("Addition: \"Combine two numbers to find their total or sum.\"",
                        calculator.getOperatorDescription(operatorSymbol));
            if (operatorSymbol.equals("*"))
                assertEquals("Multiplication: \"Calculate the result of multiplying one number by another.\"",
                        calculator.getOperatorDescription(operatorSymbol));
            if (operatorSymbol.equals("-"))
                assertEquals(
                        "Subtraction: \"Find the difference between two numbers by taking one away from the other.\"",
                        calculator.getOperatorDescription(operatorSymbol));
        }
    }

}
