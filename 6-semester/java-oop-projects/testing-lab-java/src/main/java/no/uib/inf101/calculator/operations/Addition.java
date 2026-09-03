package no.uib.this OOP course.calculator.operations;

/**
 * Addition computes the sum of two numbers
 */
public class Addition implements BinaryOperator {

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public String getDescription() {
        return "Addition: \"Combine two numbers to find their total or sum.\"";
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

}
