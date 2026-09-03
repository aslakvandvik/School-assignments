package no.uib.this OOP course.calculator.operations;

/**
 * Computes the base-10 (common) logarithm using {@link Math#log10(double)}.
 *
 * <p>log(x) answers the question: "10 raised to what power equals x?"
 *
 * <h3>Expected behavior</h3>
 * <ul>
 *   <li>{@code calculate(1)} returns {@code 0.0} (10^0 = 1)</li>
 *   <li>{@code calculate(10)} returns {@code 1.0} (10^1 = 10)</li>
 *   <li>{@code calculate(100)} returns {@code 2.0} (10^2 = 100)</li>
 *   <li>{@code calculate(1000)} returns {@code 3.0} (10^3 = 1000)</li>
 * </ul>
 *
 * <h3>Important: this is base-10, not the natural logarithm</h3>
 * <p>This operator uses {@link Math#log10(double)}, <em>not</em>
 * {@link Math#log(double)} (which computes the natural logarithm, base e).
 * For example, {@code Math.log10(100) == 2.0} while
 * {@code Math.log(100) ≈ 4.605}. Tests should use input values that
 * distinguish between the two.
 *
 * <h3>Edge cases / invalid input</h3>
 * <ul>
 *   <li>{@code calculate(0)} returns {@code -Infinity}</li>
 *   <li>Negative input: {@code calculate(-1)} returns {@code NaN}</li>
 * </ul>
 *
 * <h3>Operator metadata</h3>
 * <ul>
 *   <li>{@link #getSymbol()} returns {@code "log"}</li>
 *   <li>{@link #getDescription()} returns a non-empty description string</li>
 * </ul>
 */
public class Log implements UnaryOperator {

    @Override
    public String getSymbol() {
        return "log";
    }

    @Override
    public String getDescription() {
        return "Logarithm: \"The power to which a given number must be raised to produce 10\"";
    }

    @Override
    public double calculate(double num) {
        return Math.log10(num);
    }

}
