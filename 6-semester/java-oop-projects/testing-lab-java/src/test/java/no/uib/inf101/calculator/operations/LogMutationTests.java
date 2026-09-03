package no.uib.this OOP course.calculator.operations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static no.uib.this OOP course.calculator.operations.GradeUnaryTests.assertStudentTestsCatchMutant;


public class LogMutationTests {

	Log correct = new Log();
	
    @AfterEach
    void resetProvider() {
        OperatorProvider.reset();
    }
    
    // --- Calculation bugs: ---
    @Test
    void catchBuggyLog() {
        OperatorProvider.setLog(new Log() {
            @Override
            public double calculate(double num) {
                return Math.log(num); // Bug: uses ln instead of log10
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (uses Math.log instead of Math.log10)",
                "Add a test that checks log.calculate() returns correct values. Use values where log10 and ln give different results, e.g. assertEquals(2.0, log.calculate(100), 0.001)");
    }
    
    @Test
    void catchIdentityFunction() {
        OperatorProvider.setLog(new Log() {
            @Override
            public double calculate(double num) {
                return num; // Bug: returns num instead of log10(num)
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (returns num instead of log10(num))",
                "Add a test that verifies log.calculate() actually computes a value, e.g. assertEquals(2.0, log.calculate(100), 0.001)");
    }

    @Test
    void testsOnNegative() {
        OperatorProvider.setLog(new Log() {
            @Override
            public double calculate(double num) {
                return correct.calculate(Math.abs(num)); // Bug: takes abs, so log(-1) returns 0 instead of NaN
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (log of negative number should return NaN, but returns a value)",
                "Add a test that checks log.calculate(-1) returns NaN, e.g. assertTrue(Double.isNaN(log.calculate(-1)))");
    }
    
    @Test
    void testsOnZero() {
        OperatorProvider.setLog(new Log() {
            @Override
            public double calculate(double num) {
                if (num == 0) return 0; // Bug: log(0) should be -Infinity, not 0
                return correct.calculate(num);
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (log(0) returns 0 instead of -Infinity)",
                "Add a test that checks log.calculate(0) returns -Infinity, e.g. assertEquals(Double.NEGATIVE_INFINITY, log.calculate(0))");
    }

    @Test
    void testsOnPositiveInfinity() {
        OperatorProvider.setLog(new Log() {
            @Override
            public double calculate(double num) {
                if (num == Double.POSITIVE_INFINITY) return Double.NaN; // Bug: log(Infinity) should be Infinity, not NaN
                return correct.calculate(num);
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (log(Infinity) returns NaN instead of Infinity)",
                "Add a test that checks log.calculate(Infinity) returns Infinity, e.g. assertEquals(Double.POSITIVE_INFINITY, log.calculate(Double.POSITIVE_INFINITY))");
    }

    // --- Symbol bugs: ---
    @Test
    void catchEmptySymbol() {
        OperatorProvider.setLog(new Log() {
            @Override
            public String getSymbol() { return ""; } // Bug: empty symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Log (symbol is empty)",
                "Add a test that checks log.getSymbol() is not empty, e.g. assertFalse(log.getSymbol().isEmpty())");
    }

    @Test
    void catchNullSymbol() {
        OperatorProvider.setLog(new Log() {
            @Override
            public String getSymbol() { return null; } // Bug: null symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Log (symbol is null)",
                "Add a test that checks log.getSymbol() is not null, e.g. assertNotNull(log.getSymbol())");
    }

    @Test
    void catchWhitespaceSymbol() {
        OperatorProvider.setLog(new Log() {
            @Override
            public String getSymbol() { return "   "; } // Bug: whitespace symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Log (symbol is only whitespace)",
                "Add a test that checks log.getSymbol() is not blank, e.g. assertFalse(log.getSymbol().isBlank())");
    }

    // --- Description bugs: ---

    @Test
    void catchNullDescription() {
        OperatorProvider.setLog(new Log() {
            @Override
            public String getDescription() {
                return null; // Bug: null description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (description is null)",
                "Add a test that checks log.getDescription() is not null, e.g. assertNotNull(log.getDescription())");
    }
    
    @Test
    void catchEmptyDescription() {
        OperatorProvider.setLog(new Log() {
            @Override
            public String getDescription() {
                return ""; // Bug: empty description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Log (description is empty)",
                "Add a test that checks log.getDescription() is not empty, e.g. assertFalse(log.getDescription().isEmpty())");
    }

}
