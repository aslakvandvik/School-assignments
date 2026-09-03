package no.uib.this OOP course.calculator;
import no.uib.this OOP course.calculator.operations.Operator;
import no.uib.this OOP course.calculator.operations.Addition;
import no.uib.this OOP course.calculator.operations.Subtraction;
import no.uib.this OOP course.calculator.operations.Multiplication;
import no.uib.this OOP course.calculator.operations.Exponent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Represents a calculator that can evaluate mathematical expressions.
 * The calculator supports various operations through the use of
 * <code>Operator</code>
 * implementations, which define the behavior for specific mathematical
 * operators.
 */
public class Calculator {
    
    private Map<String, Operator> operators;
    
    public Calculator() {
        operators = new HashMap<>();
        addOperators();
    }

    private void addOperators() {
        Operator addition = new Addition();
        Operator subtraction = new Subtraction();
        Operator multiplication = new Multiplication();
        Operator exponent = new Exponent();

        operators.put(addition.getSymbol(), addition);
        operators.put(subtraction.getSymbol(), subtraction);
        operators.put(multiplication.getSymbol(), multiplication);
        operators.put(exponent.getSymbol(), exponent);
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
     * @throws NullPointerException if the operator is not found in the calculator
     */
    public String getOperatorDescription(String operatorSymbol) {
    Operator op = operators.get(operatorSymbol);
    if (op == null) {
        throw new NullPointerException("This operator is not supported by the calculator: " + operatorSymbol);
    }
    return op.getDescription();
    }

    /**
     * Performs a calculation between two numbers using a specified operator.
     *
     * @param num1           the first operand
     * @param num2           the second operand
     * @param operatorSymbol the symbol of the operator to use
     * @return the result of the calculation
     * @throws NullPointerException if the operator is not found in the calculator
     */
    public double evaluate(double num1, double num2, String operatorSymbol) {
        Operator op = operators.get(operatorSymbol);
        if (op == null) {
            throw new NullPointerException("This operator is not supported by the calculator: " + operatorSymbol);
        }
        return op.calculate(num1, num2);
    }



    
    // ################# NO NEED TO LOOK AT THIS METHOD #################
    /**
     * Evaluates a mathematical expression represented as an <code>Expression</code>
     * object.
     *
     * @param expression the expression to evaluate
     * @return the result of the evaluation as a double
     * @throws NullPointerException if the operator in the expression is not
     *                              supported
     */
    public double evaluate(Expression expression) {
        if (expression.isNumber())
            return expression.getNumberValue();

        Expression operand1 = expression.getOperand1();
        Expression operand2 = expression.getOperand2();
        String operatorSymbol = expression.getOperator();
        if (!getOperatorSymbols().contains(operatorSymbol))
            throw new IllegalArgumentException("The operator is not supported by the caluclator: " + operatorSymbol);

        return evaluate(evaluate(operand1), evaluate(operand2), operatorSymbol);
    }

}
