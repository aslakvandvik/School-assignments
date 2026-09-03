package no.uib.oop.calculator.operations;

/**
 * Provides access to unary operator instances.
 *
 * <p>Use the static getter methods (e.g. {@link #getFactorial()},
 * {@link #getLog()}) to obtain operator instances in your tests.
 * Do <em>not</em> construct operators directly with {@code new Factorial()} etc.
 *
 * <p>Example usage in a test:
 * <pre>
 *   UnaryOperator factorial = OperatorProvider.getFactorial();
 *   double result = factorial.calculate(5);
 *   assertEquals(120.0, result);
 * </pre>
 */
public class OperatorProvider {

    private OperatorProvider() {
        // Utility class — not meant to be instantiated
    }

    private static UnaryOperator factorial = new Factorial();
    private static UnaryOperator log = new Log();
    private static UnaryOperator ln = new Ln();
    private static UnaryOperator root = new Root();

    public static UnaryOperator getFactorial() { return factorial; }
    public static UnaryOperator getLog() { return log; }
    public static UnaryOperator getLn() { return ln; }
    public static UnaryOperator getRoot() { return root; }

    // Package-private — only grading tests (same package) can call these
    static void setFactorial(UnaryOperator op) { factorial = op; }
    static void setLog(UnaryOperator op) { log = op; }
    static void setLn(UnaryOperator op) { ln = op; }
    static void setRoot(UnaryOperator op) { root = op; }

    static void reset() {
        factorial = new Factorial();
        log = new Log();
        ln = new Ln();
        root = new Root();
    }
}
