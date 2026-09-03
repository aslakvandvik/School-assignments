package no.uib.oop.calculator.expression;

/**
 * Represents a unary mathematical expression that can consist of a number or a nested expression and an operator.
 * This class supports parsing mathematical expressions
 * from strings and building expressions programmatically.
 */
public class UnaryExpression implements Expression {
    private final Expression expression;
    private final String operator;

    /**
     * Constructs a UnaryExpression from one sub-expression and an operator.
     *
     * @param expression the operand of the expression
     * @param operator   the operator (e.g., "+", "-", "*", "/")
     * @throws IllegalArgumentException if the operator is null or empty
     */
    public UnaryExpression(Expression expression, String operator) {
        if (operator == null || operator.isEmpty())
            throw new IllegalArgumentException("Operator cannot be null or empty.");
        if (isNumeric(operator))
            throw new IllegalArgumentException("Operator cannot be number such as: " + operator);

        this.expression = expression;
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

    /**
     * Retrieves the operand of the expression.
     *
     * @return the operand
     */
    public Expression getOperand() {
        return expression;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public double getNumberValue() {
        throw new IllegalStateException("This expression is not a number.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        UnaryExpression other = (UnaryExpression) obj;

        // If the main operators are different
        if (!this.getOperator().equals(other.getOperator()))
            return false;

        Expression thisExpr1 = this.getOperand();
        Expression otherExpr1 = other.getOperand();
        // If the operands are different
        return thisExpr1.equals(otherExpr1);
    }
}
