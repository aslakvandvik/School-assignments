package no.uib.oop.calculator.operations;

public interface BinaryOperator extends Operator{

    /**
     * Performs a calculation using two operands.
     *
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of the calculation
     */
    double calculate(double num1, double num2);
}
