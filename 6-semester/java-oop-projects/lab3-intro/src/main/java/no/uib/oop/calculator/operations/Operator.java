package no.uib.oop.calculator.operations;

/**
 * Represents a mathematical operator that can perform calculations on two operands.
 */
public interface Operator {

    /**
     * Returns the symbol representing this operator (e.g., "+", "-", "*").
     *
     * @return a string containing the operator symbol
     */
    public String getSymbol();

    /**
     * Returns a description of the operator
     *
     * @return a string containing the operator description
     */
    public String getDescription();
    
    /**
     * Performs a calculation using two operands.
     *
     * @param num1 the first operand
     * @param num2 the second operand
     * @return the result of the calculation
     */
    public double calculate(double num1, double num2);
    
}
