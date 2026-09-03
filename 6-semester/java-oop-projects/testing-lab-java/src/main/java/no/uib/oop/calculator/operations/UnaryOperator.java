package no.uib.oop.calculator.operations;

public interface UnaryOperator extends Operator {

    /**
     * Performs a calculation using one operand.
     *
     * @param num the operand
     * @return the result of the calculation
     */
    double calculate(double num);
}
