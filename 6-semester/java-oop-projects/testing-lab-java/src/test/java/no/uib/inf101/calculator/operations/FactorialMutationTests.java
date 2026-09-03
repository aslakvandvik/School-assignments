package no.uib.this OOP course.calculator.operations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static no.uib.this OOP course.calculator.operations.GradeUnaryTests.assertStudentTestsCatchMutant;


/**
 * Tests that verify the quality of student-written tests for Factorial operator.
 *
 * These tests swap in buggy operator implementations via OperatorProvider,
 * then invoke student test methods via reflection. If student tests fail
 * against the buggy operator, the student wrote good tests.
 */
public class FactorialMutationTests {

	private Factorial correct = new Factorial();

    @AfterEach
    void resetProvider() {
        OperatorProvider.reset();
    }


    // --- Calculation bugs: ---
    @Test
    void catchReturningNum() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                return num; // Bug: returns num instead of n!
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (returns num instead of n!)",
                "Write a test that checks calculate() returns correct values, e.g. assertEquals(120, factorial.calculate(5))");
    }

    @Test
    void testsOnLargeNumber() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                return correct.calculate(Math.min(num, 9));
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (no test for large numbers)",
                "Write a test that tests for input >= 10");
    }

    @Test
    void studentTestsForZero() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                if (num == 0) return 0;

                return correct.calculate(num);
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (0! returns 0 instead of 1)",
                "Write a test that checks calculate(0) returns 1, e.g. assertEquals(1, factorial.calculate(0))");
    }

    @Test
    void studentTestsCatchBuggyFactorialOffByOne() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                if (num <= 1)
                    return correct.calculate(num);
                else
                	return correct.calculate(num-1);
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (off-by-one: 5! returns 24 instead of 120)",
                "Write tests that check calculate() with values >= 2, e.g. assertEquals(120, factorial.calculate(5))");
    }

    // --- Invalid inputs: ---
    @Test
    void testsOnDecimalNumbers() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                Factorial correct = new Factorial();
                return correct.calculate(Math.floor(num)); // Bug: accepts decimal numbers
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (accepts decimal input instead of throwing IllegalArgumentException)",
                "Write a test using assertThrows(IllegalArgumentException.class, () -> factorial.calculate(1.5)). NOTE: You may need to fix Factorial.java first to add this validation.");
    }

    @Test
    void testsOnNegative() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                Factorial correct = new Factorial();
                return correct.calculate(Math.abs(num)); // Bug: accepts negative input via Math.abs
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (accepts negative input instead of throwing IllegalArgumentException)",
                "Write a test using assertThrows(IllegalArgumentException.class, () -> factorial.calculate(-1))");
    }

    @Test
    void testsOnNaN() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public double calculate(double num) {
                Factorial correct = new Factorial();
                if(Double.isNaN(num))
                	return 1;
                else
                	return correct.calculate(num); // Bug: accepts NaN
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (on NaN input it returns a value rather than NaN)",
                "Write a test using factorial.calculate(Double.NaN)");
    }
    
    // --- Symbol bugs: ---

    @Test
    void studentTestsCatchEmptySymbol() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getSymbol() { return ""; }
        });

        assertStudentTestsCatchMutant("buggy Factorial (symbols can not be an empty string)",
                "Write a test that checks getSymbol() is not empty, e.g. assertFalse(factorial.getSymbol().isEmpty())");
    }

    @Test
    void studentTestsCatchBlankSymbol() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getSymbol() { return "    "; }
        });

        assertStudentTestsCatchMutant("buggy Factorial (symbols containing only whitespace characters can not be shown)",
                "Write a test that checks getSymbol() is not blank, e.g. assertFalse(factorial.getSymbol().isBlank())");
    }

    @Test
    void studentTestsCatchNullSymbol() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getSymbol() { return null; }
        });

        assertStudentTestsCatchMutant("buggy Factorial (symbols can not be null)",
                "Write a test that checks getSymbol() is not null, e.g. assertNotNull(factorial.getSymbol())");
    }

    // --- Description bugs: ---

    @Test
    void studentTestsCatchBuggyFactorialDescription() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getDescription() {
                return ""; // Bug: empty description
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (description is empty)",
                "Write a test that checks getDescription() is not empty, e.g. assertFalse(factorial.getDescription().isEmpty())");
    }

    @Test
    void studentTestsCatchBuggyFactorialNullDescription() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getDescription() {
                return null; // Bug: null description
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (description is null)",
                "Write a test that checks getDescription() is not null, e.g. assertNotNull(factorial.getDescription())");
    }

    @Test
    void studentTestsCatchBuggyFactorialWhitespaceDescription() {
        OperatorProvider.setFactorial(new Factorial() {
            @Override
            public String getDescription() {
                return "    "; // Bug: whitespace-only description
            }
        });

        assertStudentTestsCatchMutant("buggy Factorial (description is only whitespace)",
                "Write a test that checks getDescription() is not blank, e.g. assertFalse(factorial.getDescription().isBlank())");
    }
    
}
