package no.uib.oop.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.uib.oop.calculator.operations.Operator;
import no.uib.oop.calculator.operations.Subtraction;
import no.uib.oop.calculator.operations.Addition;
import no.uib.oop.calculator.operations.Multiplication;

public class OperatorsTest {

    Operator operator;
    double num1 = 6;
    double num2 = 5;
    
    // ############# ADDITION #############
    @Test
    public void calculateAdditionTest() {
        operator = new Addition();

        double actual = operator.calculate(num1, num2);
        double expected = num1 + num2;
        assertEquals(expected, actual);
    }

    @Test
    public void additionSymbolTest() {
        operator = new Addition();

        String actual = operator.getSymbol();
        String expected = "+";
        assertEquals(expected, actual);
    }

    // ############# SUBTRACTION #############
    @Test
    public void calculateSubtractionTest() {
        operator = new Subtraction();

        double actual = operator.calculate(num1, num2);
        double expected = num1 - num2;
        assertEquals(expected, actual);
    }

    @Test
    public void subtractionSymbolTest() {
        operator = new Subtraction();

        String actual = operator.getSymbol();
        String expected = "-";
        assertEquals(expected, actual);
    }

    // ############# MULTIPLICATION #############
    @Test
    public void calculateMultiplicationTest() {
        operator = new Multiplication();

        double actual = operator.calculate(num1, num2);
        double expected = num1 * num2;
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicationSymbolTest() {
        operator = new Multiplication();

        String actual = operator.getSymbol();
        String expected = "*";
        assertEquals(expected, actual);
    }


}
