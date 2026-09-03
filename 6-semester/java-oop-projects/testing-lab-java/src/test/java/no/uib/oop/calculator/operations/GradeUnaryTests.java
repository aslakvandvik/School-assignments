package no.uib.oop.calculator.operations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Grading tests that verify the quality of student-written UnaryOperatorsTest.
 *
 * These tests swap in buggy operator implementations via OperatorProvider,
 * then invoke student test methods via reflection. If student tests fail
 * against the buggy operator, the student wrote good tests.
 */
public class GradeUnaryTests {

    private static final String STUDENT_TEST_CLASS =
            "no.uib.oop.calculator.operations.UnaryOperatorsTest";

    @AfterEach
    void resetProvider() {
        OperatorProvider.reset();
    }

    @Test
    void unaryOperatorsTestClassExists() {
        try {
            Class.forName(STUDENT_TEST_CLASS);
        } catch (ClassNotFoundException e) {
            fail("Could not find the class " + STUDENT_TEST_CLASS
                    + ". Did you create UnaryOperatorsTest in the correct package?");
        }
    }

//    @Test
//    void studentTestsPassOnCorrectCode() {
//        Class<?> testClass = loadStudentTestClass();
//        List<Method> testMethods = getTestMethods(testClass);
//        assertFalse(testMethods.isEmpty(),
//                "No @Test methods found in UnaryOperatorsTest");
//
//        List<Method> beforeEachMethods = getLifecycleMethods(testClass, BeforeEach.class);
//        List<Method> afterEachMethods = getLifecycleMethods(testClass, AfterEach.class);
//
//        Object instance = createInstance(testClass);
//        List<String> failures = new ArrayList<>();
//        for (Method m : testMethods) {
//            try {
//                invokeLifecycleMethods(instance, beforeEachMethods);
//                m.invoke(instance);
//                invokeLifecycleMethods(instance, afterEachMethods);
//            } catch (Exception e) {
//                failures.add(m.getName() + ": " + getRootCause(e).getMessage());
//            }
//        }
//        assertTrue(failures.isEmpty(),
//                "Student tests should pass with correct operators, but these failed:\n"
//                        + String.join("\n", failures));
//    }


    @Test
    void studentTestsUseOperatorProvider() throws IOException {
        Path sourcePath = Path.of(
                "src/test/java/no/uib/oop/calculator/operations/UnaryOperatorsTest.java");
        if (!Files.exists(sourcePath)) {
            // Source file not available (e.g. running on CodeGrade).
            // Skip gracefully — the mutation-injection tests still catch the mistake.
            return;
        }
        String source = Files.readString(sourcePath);
        String[] forbidden = {"new Factorial(", "new Log(", "new Ln(", "new Root("};
        List<String> violations = new ArrayList<>();
        for (String pattern : forbidden) {
            if (source.contains(pattern)) {
                violations.add(pattern.trim());
            }
        }
        assertTrue(violations.isEmpty(),
                "UnaryOperatorsTest must use OperatorProvider to obtain operators, "
                        + "but found direct constructor usage: " + String.join(", ", violations)
                        + ". Use e.g. OperatorProvider.getFactorial() instead of new Factorial().");
    }

    // --- Helper methods ---

    private static Class<?> loadStudentTestClass() {
        try {
            return Class.forName(STUDENT_TEST_CLASS);
        } catch (ClassNotFoundException e) {
            fail("Could not find the class " + STUDENT_TEST_CLASS
                    + ". Did you create UnaryOperatorsTest in the correct package?");
            return null; // unreachable
        }
    }

    private static List<Method> getTestMethods(Class<?> testClass) {
        List<Method> testMethods = new ArrayList<>();
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                m.setAccessible(true);
                testMethods.add(m);
            }
        }
        return testMethods;
    }

    private static Object createInstance(Class<?> testClass) {
        try {
            return testClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            fail("Could not instantiate " + testClass.getName() + ": " + e.getMessage());
            return null; // unreachable
        }
    }

    private static List<Method> getLifecycleMethods(Class<?> testClass, Class<? extends java.lang.annotation.Annotation> annotation) {
        List<Method> methods = new ArrayList<>();
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(annotation)) {
                m.setAccessible(true);
                methods.add(m);
            }
        }
        return methods;
    }

    private static void invokeLifecycleMethods(Object instance, List<Method> methods) throws Exception {
        for (Method m : methods) {
            m.invoke(instance);
        }
    }

    static void assertStudentTestsCatchMutant(String mutantDescription, String hint) {
        Class<?> testClass = loadStudentTestClass();
        List<Method> testMethods = getTestMethods(testClass);
        assertFalse(testMethods.isEmpty(),
                "No @Test methods found in UnaryOperatorsTest");

        List<Method> beforeEachMethods = getLifecycleMethods(testClass, BeforeEach.class);
        List<Method> afterEachMethods = getLifecycleMethods(testClass, AfterEach.class);

        Object instance = createInstance(testClass);
        boolean mutantCaught = false;
        for (Method m : testMethods) {
            try {
                invokeLifecycleMethods(instance, beforeEachMethods);
                m.invoke(instance);
                invokeLifecycleMethods(instance, afterEachMethods);
            } catch (Exception e) {
                // Any exception means the student test detected the mutant
                mutantCaught = true;
                break;
            }
        }
        assertTrue(mutantCaught,
                "None of your tests in UnaryOperatorsTest detected the "
                        + mutantDescription + ".\n"
                        + "Hint: " + hint + "\n"
                        + "Remember to use OperatorProvider (e.g. OperatorProvider.getFactorial()) "
                        + "to obtain operators — do NOT use 'new Factorial()' etc. directly.");
    }

//    private Throwable getRootCause(Throwable t) {
//        Throwable cause = t;
//        while (cause.getCause() != null) {
//            cause = cause.getCause();
//        }
//        return cause;
//    }
}
