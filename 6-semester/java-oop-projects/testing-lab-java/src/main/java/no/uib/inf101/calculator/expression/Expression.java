package no.uib.this OOP course.calculator.expression;

public interface Expression {

    boolean isNumber();

    /**
     * @return the main operator of the Expression, or null if
     *         the expression is a number.
     * @throws IllegalStateException if this Expression is a number.
     */
    String getOperator();

    /**
     * Retrieves the numeric value of the expression if it is a number.
     *
     * @return the numeric value
     * @throws IllegalStateException if this Expression is not a number
     */
    double getNumberValue();
}
