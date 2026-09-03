package no.uib.oop.calculator.expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnaryExpressionTest {

    @Test
    void testConstructorWithValidExpression() {
        Number expr1 = new Number(5);
        UnaryExpression expr = new UnaryExpression(expr1, "!");

        assertEquals("!", expr.getOperator());
        assertEquals(5.0, expr.getOperand().getNumberValue());
    }

    @Test
    void testConstructorWithCompoundExpression() {
        Expression expr1 = new Number(2);
        UnaryExpression expr = new UnaryExpression(expr1, "!"); // 2!
        UnaryExpression compoundExpr = new UnaryExpression(expr, "!"); // 2!!

        assertEquals("!", compoundExpr.getOperator());
        assertEquals(expr, compoundExpr.getOperand());
    }

    @Test
    void testUnaryExpressionEquals() {
        UnaryExpression expr1 = new UnaryExpression(new Number(2), "!");
        UnaryExpression expr2 = new UnaryExpression(new Number(2), "!");

        assertEquals(expr1, expr2);
    }

    @Test
    void testEqualsForDifferentUnaryExpressions() {
        UnaryExpression expr1 = new UnaryExpression(new Number(2), "!");
        UnaryExpression expr2 = new UnaryExpression(new Number(3), "log");

        assertNotEquals(expr1, expr2, "Two different expressions should not be equal.");
    }

    @Test
    void numberIsNullInUnaryExpression() {
        UnaryExpression expression = new UnaryExpression(new Number(25),"√");

        assertFalse(expression.isNumber());
        assertThrows(IllegalStateException.class, () -> expression.getNumberValue());
    }

    @Test
    void testConstructorWithInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> new UnaryExpression(null, null));
        assertThrows(IllegalArgumentException.class, () -> new UnaryExpression(null, ""));
        assertThrows(IllegalArgumentException.class, () -> new UnaryExpression(null, "4"));
    }

    @Test
    void testOperatorCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UnaryExpression(new Number(2.0), "");
        }, "Operator cannot be empty.");
    }

    @Test
    void testOperatorCannotBeNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UnaryExpression(new Number(2.0), "5");
        }, "Operator cannot be a number.");
    }

}
