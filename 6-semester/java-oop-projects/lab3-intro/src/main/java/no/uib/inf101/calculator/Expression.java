package no.uib.this OOP course.calculator;

/**
 * Represents a mathematical expression that can consist of numbers, operators,
 * or nested expressions. This class supports parsing mathematical expressions
 * from strings and building expressions programmatically.
 */
public class Expression {

    private Expression expression1;
    private Expression expression2;
    private String operator;
    private Double number; // Holds the value if this is a number

    /**
     * Constructs an Expression object from two sub-expressions and an operator.
     *
     * @param expression1 the left operand of the expression
     * @param expression2 the right operand of the expression
     * @param operator    the operator (e.g., "+", "-", "*", "/")
     * @throws IllegalArgumentException if the operator is null or empty
     */
    public Expression(Expression expression1, Expression expression2, String operator) {
        if (operator == null || operator.isEmpty())
            throw new IllegalArgumentException("Operator cannot be null or empty.");
        if (isNumeric(operator))
            throw new IllegalArgumentException("Operator cannot be number such as: " + operator);

        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operator = operator;
        this.number = null; // Not a number
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
     * Constructs an Expression object representing a single number.
     *
     * @param value the numeric value of the expression
     */
    public Expression(double value) {
        this.number = value;
        this.expression1 = null;
        this.expression2 = null;
        this.operator = null;
    }

    /**
     * Factory method to create an Expression representing a single number.
     *
     * @param value the numeric value of the expression
     * @return an Expression object representing the given number
     */
    public static Expression number(double value) {
        return new Expression(value);
    }

    /**
     * Checks if this Expression represents a single number.
     *
     * @return true if the Expression is a number, false otherwise
     */
    public boolean isNumber() {
        return number != null;
    }

    /**
     * Retrieves the numeric value of the expression if it is a number.
     *
     * @return the numeric value
     * @throws IllegalStateException if this Expression is not a number
     */
    public double getNumberValue() {
        if (!isNumber()) {
            throw new IllegalStateException("This expression is not a number.");
        }
        return number;
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

    /**
     * Retrieves the operator of the expression.
     *
     * @return the operator as a string, or null if this Expression is a number
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Parses a string into an Expression object.
     *
     * @param text the input string representing a mathematical expression
     * @return an Expression object corresponding to the parsed input
     * @throws IllegalArgumentException if the input is empty, invalid, or contains
     *                                  unbalanced parentheses
     */
    public static Expression parse(String text) {
        // Remove whitespace
        text = text.replaceAll("\\s+", "");

        if (text.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        // Base case: If it's just a number, return an Expression representing that
        // number
        if (text.matches("-?\\d+(\\.\\d+)?")) {
            return number(Double.parseDouble(text));
        }

        // Validate parentheses balance
        if (!areParenthesesBalanced(text)) {
            throw new IllegalArgumentException("Unbalanced parentheses in expression: " + text);
        }

        // Find the main operator, handling negative numbers correctly
        int index = findMainOperator(text);

        if (index == -1) {
            throw new IllegalArgumentException("Invalid expression: " + text);
        }

        // Split the expression around the main operator
        String operator = String.valueOf(text.charAt(index));
        String leftPart = text.substring(0, index);
        String rightPart = text.substring(index + 1);

        if (leftPart.isEmpty() || rightPart.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: " + text);
        }

        // Handle negative numbers by checking if the operator is '-' and if the left
        // part is a valid number
        if (operator.equals("-") && leftPart.isEmpty()) {
            leftPart = "0"; // Handle case where negative number is at the start
        }

        Expression leftExpression = parse(leftPart);
        Expression rightExpression = parse(rightPart);

        return new Expression(leftExpression, rightExpression, operator);
    }

    /**
     * Finds the main operator in the expression, respecting parentheses and
     * operator precedence.
     *
     * @param text the input string representing a mathematical expression
     * @return the index of the main operator, or -1 if no operator is found
     */
    private static int findMainOperator(String text) {
        int level = 0;
        int operatorIndex = -1;
        int lastExponentIndex = -1; // To handle exponentiation (higher precedence)

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == '(') {
                level++;
            } else if (c == ')') {
                level--;
            } else if ((c == '+' || c == '-') && level == 0) {
                if (i == 0 || text.charAt(i - 1) == '(') {
                    // Skip if it's a unary minus or plus
                    continue;
                }
                return i; // Return immediately for lowest-precedence operators
            } else if ((c == '*' || c == '/') && level == 0) {
                if (operatorIndex == -1) {
                    operatorIndex = i; // Save index for higher precedence
                }
            } else if (c == '^' && level == 0) {
                lastExponentIndex = i; // Save the last seen exponentiation operator
            }
        }

        // Return the highest-precedence operator index
        return lastExponentIndex != -1 ? lastExponentIndex : operatorIndex;
    }

    /**
     * Checks if the parentheses in the expression are balanced.
     *
     * @param text the input string representing a mathematical expression
     * @return true if the parentheses are balanced, false otherwise
     */
    private static boolean areParenthesesBalanced(String text) {
        int balance = 0;
        for (char c : text.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Expression other = (Expression) obj;
        // If both are numbers
        if (this.isNumber() && other.isNumber())
            return this.getNumberValue() == other.getNumberValue();

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
        if (!thisExpr2.equals(otherExpr2))
            return false;
    
        return true;
    }

}
