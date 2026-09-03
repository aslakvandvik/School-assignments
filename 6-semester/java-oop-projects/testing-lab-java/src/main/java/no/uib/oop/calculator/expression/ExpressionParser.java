package no.uib.oop.calculator.expression;

import java.util.Arrays;
import java.util.List;

public class ExpressionParser {

    public static List<String> binaryOperators = Arrays.asList("+", "-", "*", "^");
    public static List<String> unaryOperators = Arrays.asList("!", "√", "log", "ln");

    /**
     * Parses a string into an Expression object.
     *
     * @param text the input string representing a mathematical expression
     * @return an Expression object corresponding to the parsed input
     * @throws IllegalArgumentException if the input is empty, invalid or contains
     *                                  unbalanced parentheses
     */
    public static Expression parse(String text) {
        // Remove whitespace
        text = text.replaceAll("\\s+", "");
    
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }
    
        // Base case: If it's just a number, return an Expression representing that number
        if (text.matches("-?\\d+(\\.\\d+)?")) {
            return new Number(Double.parseDouble(text));
        }
    
        // Validate parentheses balance
        if (!areParenthesesBalanced(text)) {
            throw new IllegalArgumentException("Unbalanced parentheses in expression: " + text);
        }
    
        // Handle expressions fully enclosed in parentheses
        if (text.startsWith("(") && text.endsWith(")") && areParenthesesBalanced(text.substring(1, text.length() - 1))) {
            return parse(text.substring(1, text.length() - 1)); // Recurse into the inner expression
        }
    
        // Find the main operator, respecting parentheses
        int index = findMainOperator(text);
    
        if (index == -1) {
            throw new IllegalArgumentException("Invalid expression: " + text);
        }
    
        // Split the expression around the main operator
        String operator = String.valueOf(text.charAt(index));
        
        // Handle multiple-character operators
        if (text.startsWith("log", index)) {
            operator = "log";
        } else if (text.startsWith("ln", index)) {
            operator = "ln";
        }
        String leftPart = text.substring(0, index);
        String rightPart = text.substring(index + operator.length());
    
        // Parse binary expression
        if (binaryOperators.contains(operator)) {
            // Handle negative numbers at the start
            if (operator.equals("-") && leftPart.isEmpty()) {
                leftPart = "0"; 
            }
            if (leftPart.isEmpty() || rightPart.isEmpty()) {
                throw new IllegalArgumentException("Invalid expression: " + text);
            }
    
            Expression leftExpression = parse(leftPart);
            Expression rightExpression = parse(rightPart);
            return new BinaryExpression(leftExpression, rightExpression, operator);
        }
    
        // Parse unary expression
        if (unaryOperators.contains(operator)) {
            if (operator.equals("!")) {
                if (!rightPart.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression: " + text);
                } else {
                    Expression leftExpression = parse(leftPart);
                    return new UnaryExpression(leftExpression, operator);
                }
            } else {
                if(!leftPart.isEmpty() || rightPart.isEmpty()) {
                    throw new IllegalArgumentException("Invalid expression: " + text);
                } else {
                    Expression rightExpression = parse(rightPart);
                    return new UnaryExpression(rightExpression, operator);
                }
            }
        }
    
        return null;
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
            } else if ((c == '!' || c == '√') && level == 0) {
                if (operatorIndex == -1) {
                    operatorIndex = i; // Save index for higher precedence
                }
            } else if (i + 2 < text.length() && (text.startsWith("log", i)
                                                 || text.startsWith("ln", i))) {
                String operator = text.startsWith("log", i) ? "log" : "ln";
                if (operatorIndex == -1) {
                    operatorIndex = i;
                }
                i += operator.length() - 1; // Skip the rest of the operator characters

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

}
