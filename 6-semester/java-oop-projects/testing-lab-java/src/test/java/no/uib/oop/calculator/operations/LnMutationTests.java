package no.uib.oop.calculator.operations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static no.uib.oop.calculator.operations.GradeUnaryTests.assertStudentTestsCatchMutant;

public class LnMutationTests {

    @AfterEach
    void resetProvider() {
        OperatorProvider.reset();
    }
    
    @Test
    void catchDifferentBase() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public double calculate(double num) {
                return Math.log10(num); // Bug: uses log10 instead of ln
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (uses Math.log10 instead of Math.log)",
                "Add a test that checks ln.calculate() returns correct values. Use values where ln and log10 give different results, e.g. assertEquals(1.0, ln.calculate(Math.E), 0.001)");
    }

    @Test
    void catchEmptySymbol() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public String getSymbol() { return ""; } // Bug: empty symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (symbol is empty)",
                "Add a test that checks ln.getSymbol() is not empty, e.g. assertFalse(ln.getSymbol().isEmpty())");
    }

    @Test
    void catchEmptyDescription() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public String getDescription() {
                return ""; // Bug: empty description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (description is empty)",
                "Add a test that checks ln.getDescription() is not empty, e.g. assertFalse(ln.getDescription().isEmpty())");
    }
    
    @Test
    void catchIdentityFunction() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public double calculate(double num) {
                return num; // Bug: returns num instead of ln(num)
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (returns num instead of ln(num))",
                "Add a test that verifies ln.calculate() actually computes a value, e.g. assertEquals(1.0, ln.calculate(Math.E), 0.001)");
    }

    @Test
    void testsOnNegative() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public double calculate(double num) {
                return Math.log(Math.abs(num)); // Bug: takes abs, so ln(-1) returns 0 instead of NaN
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (ln of negative number should return NaN, but returns a value)",
                "Add a test that checks ln.calculate(-1) returns NaN, e.g. assertTrue(Double.isNaN(ln.calculate(-1)))");
    }
    
    @Test
    void studentTestsCatchBuggyLnZero() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public double calculate(double num) {
                if (num == 0) return 0; // Bug: ln(0) should be -Infinity, not 0
                return Math.log(num);
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (ln(0) returns 0 instead of -Infinity)",
                "Add a test that checks ln.calculate(0) returns -Infinity, e.g. assertEquals(Double.NEGATIVE_INFINITY, ln.calculate(0))");
    }

    @Test
    void catchNullSymbol() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public String getSymbol() { return null; } // Bug: null symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (symbol is null)",
                "Add a test that checks ln.getSymbol() is not null, e.g. assertNotNull(ln.getSymbol())");
    }

    @Test
    void catchWhitespaceSymbol() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public String getSymbol() { return "   "; } // Bug: whitespace symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (symbol is only whitespace)",
                "Add a test that checks ln.getSymbol() is not blank, e.g. assertFalse(ln.getSymbol().isBlank())");
    }

    @Test
    void catchNullDescription() {
        OperatorProvider.setLn(new Ln() {
            @Override
            public String getDescription() {
                return null; // Bug: null description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Ln (description is null)",
                "Add a test that checks ln.getDescription() is not null, e.g. assertNotNull(ln.getDescription())");
    }

}
