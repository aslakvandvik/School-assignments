package no.uib.this OOP course.calculator.operations;

/**
 * Represents a mathematical operator that can perform calculations on two operands.
 */
public interface Operator {

    /**
     * Returns the symbol representing this operator (e.g., "+", "-", "*").
     *
     * @return a string containing the operator symbol
     */
    String getSymbol();

    /**
     * Returns a description of the operator
     *
     * @return a string containing the operator description
     */
    String getDescription();
    
}
