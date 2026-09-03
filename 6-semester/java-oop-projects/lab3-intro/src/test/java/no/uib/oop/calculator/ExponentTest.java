package no.uib.oop.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.oop.calculator.operations.Exponent;
import no.uib.oop.calculator.operations.Operator;

public class ExponentTest {

    Operator operator;
    double num1 = 6;
    double num2 = 5;
    
    @Test
    public void calculateExponentTest() {
        operator = new Exponent();

        double actual = operator.calculate(num1, num2);
        double expected = Math.pow(num1, num2);
        assertEquals(expected, actual);
    }

    @Test
    public void additionSymbolTest() {
        operator = new Exponent();

        String actual = operator.getSymbol();
        String expected = "^";
        assertEquals(expected, actual);
    }

}
