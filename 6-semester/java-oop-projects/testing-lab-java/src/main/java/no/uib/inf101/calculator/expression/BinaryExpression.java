package no.uib.this OOP course.calculator.expression;

/**
 * Represents a mathematical expression that can consist of numbers, operators,
 * or nested expressions. This class supports parsing mathematical expressions
 * from strings and building expressions programmatically.
 */
public class BinaryExpression implements Expression {

    private final Expression expression1;
    private final Expression expression2;
    private final String operator;

    /**
     * Constructs an Expression object from two sub-expressions and an operator.
     *
     * @param expression1 the left operand of the expression
     * @param expression2 the right operand of the expression
     * @param operator    the operator (e.g., "+", "-", "*", "/")
     * @throws IllegalArgumentException if the operator is null or empty
     */
    public BinaryExpression(Expression expression1, Expression expression2, String operator) {
        if (operator == null || operator.isEmpty())
            throw new IllegalArgumentException("Operator cannot be null or empty.");
        if (isNumeric(operator))
            throw new IllegalArgumentException("Operator cannot be number such as: " + operator);

        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operator = operator;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public double getNumberValue() {
        throw new IllegalStateException("This expression is not a number.");
    }

    /**
     * Retrieves the left operand of the expression.
     *
     * @return the left operand
     */
    public Expression getOperand1() {
        return expression1;
    }

    /**
     * Retrieves the right operand of the expression.
     *
     * @return the right operand
     */
    public Expression getOperand2() {
        return expression2;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        BinaryExpression other = (BinaryExpression) obj;

        // If the main operators are different
        if (!this.getOperator().equals(other.getOperator()))
            return false;

        Expression thisExpr1 = this.getOperand1();
        Expression otherExpr1 = other.getOperand1();
        // If the first operands are different
        if (!thisExpr1.equals(otherExpr1))
            return false;

        Expression thisExpr2 = this.getOperand2();
        Expression otherExpr2 = other.getOperand2();
        // If the second operands are different
        return thisExpr2.equals(otherExpr2);
    }

}
