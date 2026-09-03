package no.uib.this OOP course.calculator.operations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static no.uib.this OOP course.calculator.operations.GradeUnaryTests.assertStudentTestsCatchMutant;

class RootMutationTests {

    @AfterEach
    void resetProvider() {
        OperatorProvider.reset();
    }
    
    @Test
    void catchCubicRoot() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
                return Math.cbrt(num); // Bug: uses cube root instead of square root
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (uses Math.cbrt instead of Math.sqrt)",
                "Add a test that checks root.calculate() returns correct values. Use values where sqrt and cbrt give different results, e.g. assertEquals(3.0, root.calculate(9), 0.001)");
    }

    @Test
    void catchEmptySymbol() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public String getSymbol() { return ""; } // Bug: empty symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Root (symbol is empty)",
                "Add a test that checks root.getSymbol() is not empty, e.g. assertFalse(root.getSymbol().isEmpty())");
    }

    @Test
    void catchEmptyDescription() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public String getDescription() {
                return ""; // Bug: empty description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (description is empty)",
                "Add a test that checks root.getDescription() is not empty, e.g. assertFalse(root.getDescription().isEmpty())");
    }

    @Test
    void catchIdentityFunction() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
                return num; // Bug: returns num instead of sqrt(num)
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (returns num instead of sqrt(num))",
                "Add a test that verifies root.calculate() actually computes a value, e.g. assertEquals(3.0, root.calculate(9), 0.001)");
    }

    @Test
    void testsOnNegative() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
                return Math.sqrt(Math.abs(num)); // Bug: takes abs, so sqrt(-4) returns 2 instead of NaN
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (sqrt of negative number should return NaN, but returns a value)",
                "Add a test that checks root.calculate(-1) returns NaN, e.g. assertTrue(Double.isNaN(root.calculate(-1)))");
    }

    @Test
    void testsWithHighPrecision() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
            	double diffToInt = Math.abs(num-Math.round(num));
            	if(diffToInt<0.01) {
            		return Math.sqrt(num);
            	}
            	else {
            		return Math.sqrt(num+0.01);
            	}
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (sqrt of desimal numbers should return exact values)",
                "Add a test that checks the value of a decimal number, e.g. assertEqual(0.7071,root.calculate(0.5)))");
    }

    @Test
    void testsOnZero() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
                if (num == 0) return 1; // Bug: sqrt(0) should be 0, not 1
                return Math.sqrt(num);
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (sqrt(0) returns 1 instead of 0)",
                "Add a test that checks root.calculate(0) returns 0, e.g. assertEquals(0.0, root.calculate(0), 0.001)");
    }

    @Test
    void testsOnNegativeZero() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public double calculate(double num) {
                if (num == -0.0) return 0.0; // Bug: sqrt(-0.0) should be -0.0, not 0.0
                return Math.sqrt(num);
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (sqrt(-0.0) returns 0.0 instead of -0.0)",
                "Add a test that checks root.calculate(-0.0) returns -0.0, 0.0 == -0.0 will return true it is only when using Double.toString(num) that you notice they are different ");
    }

    @Test
    void catchWhitespaceSymbol() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public String getSymbol() { return "   "; } // Bug: whitespace symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Root (symbol is only whitespace)",
                "Add a test that checks root.getSymbol() is not blank, e.g. assertFalse(root.getSymbol().isBlank())");
    }

    @Test
    void catchNullDescription() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public String getDescription() {
                return null; // Bug: null description
            }
        });

        assertStudentTestsCatchMutant(
                "buggy Root (description is null)",
                "Add a test that checks root.getDescription() is not null, e.g. assertNotNull(root.getDescription())");
    }

    @Test
    void catchNullSymbol() {
        OperatorProvider.setRoot(new Root() {
            @Override
            public String getSymbol() { return null; } // Bug: null symbol
        });

        assertStudentTestsCatchMutant(
                "buggy Root (symbol is null)",
                "Add a test that checks root.getSymbol() is not null, e.g. assertNotNull(root.getSymbol())");
    }

}
