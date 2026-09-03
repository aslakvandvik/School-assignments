package no.uib.this OOP course.calculator.expression;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberExpressionTest {

    @Test
    void testConstructWithValidExpression() {
        Number expr = new Number(5);

        assertEquals(5.0, expr.getNumberValue());
    }

    @Test
    void testOperatorIsNullInNumber() {
        Number expression = new Number(5);

        assertTrue(expression.isNumber());
        assertThrows(IllegalStateException.class, () -> expression.getOperator());
    }

    @Test
    void testExpressionEquals() {
        Number expr1 = new Number(2);
        Number expr2 = new Number(2);

        assertEquals(expr1, expr2);
    }

    @Test
    void testEqualsForDifferentExpressions() {
        Number expr1 = new Number(3);
        Number expr2 = new Number(2);
        assertNotEquals(expr1, expr2, "Two different expressions should not be equal.");
    }
}
