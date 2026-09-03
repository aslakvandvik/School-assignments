package no.uib.this OOP course.calculator.operations;

/**
 * Computes the factorial of a non-negative integer.
 *
 * <p>The factorial of n (written n!) is the product of all positive integers
 * from 1 to n:
 * <pre>
 *   n! = 1 * 2 * 3 * ... * n
 * </pre>
 *
 * <h3>Expected behavior</h3>
 * <ul>
 *   <li>{@code calculate(0)} returns {@code 1} (by definition, 0! = 1)</li>
 *   <li>{@code calculate(1)} returns {@code 1}</li>
 *   <li>{@code calculate(5)} returns {@code 120} (5 * 4 * 3 * 2 * 1)</li>
 *   <li>{@code calculate(10)} returns {@code 3628800}</li>
 * </ul>
 *
 * <h3>Edge cases / invalid input</h3>
 * <ul>
 *   <li>Negative input: {@code calculate(-1)} throws
 *       {@link IllegalArgumentException}.</li>
 *   <li>Non-integer input (e.g. 0.5): behaviour is unspecified.</li>
 * </ul>
 *
 * <h3>Operator metadata</h3>
 * <ul>
 *   <li>{@link #getSymbol()} returns {@code "!"}</li>
 *   <li>{@link #getDescription()} returns a non-empty description string</li>
 * </ul>
 */
class Factorial implements UnaryOperator {

    @Override
    public String getSymbol() {
        return "!";
    }

    @Override
    public String getDescription() {
        return "Factorial: \"The product of an integer and all the integers below it\"";
    }

    @Override
    public double calculate(double num) {
    	if(Double.isNaN(num))
    		return Double.NaN;
        if (num < 0)
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    	if(Double.isInfinite(num))
    		return num;
    	if(num>170)
    		return Double.POSITIVE_INFINITY;
        if (num != Math.floor(num))
            throw new IllegalArgumentException("Factorial is not defined for non-integer numbers");
        double result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
