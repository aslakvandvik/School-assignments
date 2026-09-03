package no.uib.oop.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.uib.oop.calculator.expression.BinaryExpression;
import no.uib.oop.calculator.expression.Expression;
import no.uib.oop.calculator.expression.UnaryExpression;
import no.uib.oop.calculator.operations.*;

/**
 * Represents a calculator that can evaluate mathematical expressions.
 * The calculator supports various operations through the use of <code>Operator</code> 
 * implementations, which define the behavior for specific mathematical operators.
 */
public class Calculator {

    private final Map<String, Operator> operators;

    public Calculator() {
        operators = new HashMap<>();
        addOperators();
    }

    private void addOperators() {
        addOperator(new Addition());
        addOperator(new Subtraction());
        addOperator(new Multiplication());
        addOperator(new Exponent());
        addOperator(OperatorProvider.getFactorial());
        addOperator(OperatorProvider.getLog());
        addOperator(OperatorProvider.getLn());
        addOperator(OperatorProvider.getRoot());
    }

    private void addOperator(Operator operator) {
        operators.put(operator.getSymbol(), operator);
    }

    /**
     * Retrieves a list of all operator symbols supported by the calculator.
     *
     * @return a list of operator symbols
     */
    public List<String> getOperatorSymbols() {
        return new ArrayList<>(operators.keySet());
    }

    /**
     * Retrieves the operators description.
     *
     * @return a string of the operator's description
     */
    public String getOperatorDescription(String operatorSymbol) {
        return operators.get(operatorSymbol).getDescription();
    }
    
    /**
     * Performs a calculation between two numbers using a specified binary operator.
     *
     * @param num            the operand
     * @param operatorSymbol the symbol of the operator to use
     * @return the result of the calculation
     * @throws NullPointerException if the operator is not found in the calculator
     */
    public double evaluate(double num, String operatorSymbol) {
        return ((UnaryOperator) operators.get(operatorSymbol)).calculate(num);
    }

    /**
     * Performs a calculation between two numbers using a specified binary operator.
     *
     * @param num1           the first operand
     * @param num2           the second operand
     * @param operatorSymbol the symbol of the operator to use
     * @return the result of the calculation
     * @throws NullPointerException if the operator is not found in the calculator
     */
    public double evaluate(double num1, double num2, String operatorSymbol) {
        return ((BinaryOperator) operators.get(operatorSymbol)).calculate(num1, num2);
    }

    /**
     * Evaluates a mathematical expression represented as an <code>Expression</code> object.
     *
     * @param expression the expression to evaluate
     * @return the result of the evaluation as a double
     * @throws IllegalArgumentException if the operator in the expression or the type of Expression  is not supported
     */
    public double evaluate(Expression expression) {
        // Evaluate number
        if (expression.isNumber())
            return expression.getNumberValue();

        // Evaluate UnaryExpression
        if (expression.getClass().equals(UnaryExpression.class)) {
            Expression operand = ((UnaryExpression) expression).getOperand();
            String operatorSymbol = expression.getOperator();
            if (!getOperatorSymbols().contains(operatorSymbol))
                throw new IllegalArgumentException("The operator is not supported by the calculator: " + operatorSymbol);
            return evaluate(evaluate(operand), operatorSymbol);
        }

        // Evaluate BinaryExpression
        if (expression.getClass().equals(BinaryExpression.class)) {
            Expression operand1 = ((BinaryExpression) expression).getOperand1();
            Expression operand2 = ((BinaryExpression) expression).getOperand2();
            String operatorSymbol = expression.getOperator();
            if (!getOperatorSymbols().contains(operatorSymbol))
                throw new IllegalArgumentException("The operator is not supported by the calculator: " + operatorSymbol);
            return evaluate(evaluate(operand1), evaluate(operand2), operatorSymbol);
        }

        throw new IllegalArgumentException("The Expression type is not supported by the calculator: " + expression.getClass());
    }
    
}
