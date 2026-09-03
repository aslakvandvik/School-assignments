package no.uib.oop.calculator.operations;

/**
 * Computes the square root of a number using {@link Math#sqrt(double)}.
 *
 * <p>The square root of x is the value y such that y * y = x.
 *
 * <h3>Expected behavior</h3>
 * <ul>
 *   <li>{@code calculate(0)} returns {@code 0.0}</li>
 *   <li>{@code calculate(1)} returns {@code 1.0}</li>
 *   <li>{@code calculate(4)} returns {@code 2.0}</li>
 *   <li>{@code calculate(9)} returns {@code 3.0}</li>
 *   <li>{@code calculate(2)} returns approximately {@code 1.4142} (irrational result)</li>
 * </ul>
 *
 * <h3>Edge cases / invalid input</h3>
 * <ul>
 *   <li>Negative input: {@code calculate(-1)} returns {@code NaN}
 *       (square root of a negative number is not a real number).</li>
 * </ul>
 *
 * <h3>Operator metadata</h3>
 * <ul>
 *   <li>{@link #getSymbol()} returns {@code "√"}</li>
 *   <li>{@link #getDescription()} returns a non-empty description string</li>
 * </ul>
 */
public class Root implements UnaryOperator {

    @Override
    public String getSymbol() {
        return "√";
    }

    @Override
    public String getDescription() {
        return "Square root: \"A number which produces a specified quantity when multiplied by itself.\"";
    }

    @Override
    public double calculate(double num) {
        return Math.sqrt(num);
    }

}
