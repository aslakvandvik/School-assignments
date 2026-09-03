package no.uib.this OOP course.calculator.operations;

/**
 * Computes the natural logarithm (base e) using {@link Math#log(double)}.
 *
 * <p>ln(x) answers the question: "e raised to what power equals x?"
 * (where e ≈ 2.71828)
 *
 * <h3>Expected behavior</h3>
 * <ul>
 *   <li>{@code calculate(1)} returns {@code 0.0} (e^0 = 1)</li>
 *   <li>{@code calculate(Math.E)} returns {@code 1.0} (e^1 = e)</li>
 *   <li>{@code calculate(Math.E * Math.E)} returns approximately {@code 2.0}</li>
 * </ul>
 *
 * <h3>Important: this is base-e, not base-10</h3>
 * <p>This operator uses {@link Math#log(double)} (natural logarithm),
 * <em>not</em> {@link Math#log10(double)} (base-10 logarithm).
 * For example, {@code Math.log(100) ≈ 4.605} while
 * {@code Math.log10(100) == 2.0}. Tests should use input values that
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
 *   <li>{@link #getSymbol()} returns {@code "ln"}</li>
 *   <li>{@link #getDescription()} returns a non-empty description string</li>
 * </ul>
 */
public class Ln implements UnaryOperator {

    @Override
    public String getSymbol() {
        return "ln";
    }

    @Override
    public String getDescription() {
        return "Logarithm: \"The power to which e must be raised to produce a given number\"";
    }

    @Override
    public double calculate(double num) {
        return Math.log(num);
    }

}
