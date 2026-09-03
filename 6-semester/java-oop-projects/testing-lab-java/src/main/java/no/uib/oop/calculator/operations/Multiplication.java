package no.uib.oop.calculator.operations;

public class Multiplication implements BinaryOperator {

    @Override
    public String getSymbol() {
        return "*";
    }
    
    @Override
    public String getDescription() {
        return "Multiplication: \"Calculate the result of multiplying one number by another.\"";
    }

    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
    
}
