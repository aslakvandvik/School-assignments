package no.uib.this OOP course.calculator.expression;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryExpressionTest {

    @Test
    void testConstructorWithValidBinaryExpression() {
        Expression expr1 = new Number(2);
        Expression expr2 = new Number(3);
        BinaryExpression expr = new BinaryExpression(expr1, expr2, "+");

        assertEquals("+", expr.getOperator());
        assertEquals(2.0, expr.getOperand1().getNumberValue());
        assertEquals(3.0, expr.getOperand2().getNumberValue());
    }

    @Test
    void testConstructorWithCompoundBinaryExpression() {
        Expression expr1 = new Number(2);
        Expression expr2 = new Number(3);
        BinaryExpression expr = new BinaryExpression(expr1, expr2, "+"); // 2 + 3
        BinaryExpression compoundExpr = new BinaryExpression(expr, expr2, "+"); // 2 + 3 + 3

        assertEquals("+", compoundExpr.getOperator());
        assertEquals(expr, compoundExpr.getOperand1());
        assertEquals(expr2, compoundExpr.getOperand2());
    }

    @Test
    void testBinaryExpressionEquals() {
        BinaryExpression expr1 = new BinaryExpression(new Number(2), new Number(3), "+");
        BinaryExpression expr2 = new BinaryExpression(new Number(2), new Number(3), "+");

        assertEquals(expr1, expr2);
    }

    @Test
    void testEqualsForDifferentBinaryExpressions() {
        Expression left1 = new Number(3);
        Expression right1 = new Number(2);
        BinaryExpression expr1 = new BinaryExpression(left1, right1, "+");

        Expression left2 = new Number(5);
        Expression right2 = new Number(1);
        BinaryExpression expr2 = new BinaryExpression(left2, right2, "-");

        assertNotEquals(expr1, expr2, "Two different expressions should not be equal.");
    }

    @Test
    void numberIsNullInBinaryExpression() {
        Expression expression = new BinaryExpression(new Number(42), new Number(23), "+");

        assertFalse(expression.isNumber());
        assertThrows(IllegalStateException.class, () -> expression.getNumberValue());
    }


    @Test
    void testConstructorWithInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> new BinaryExpression(null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new BinaryExpression(null, null, ""));
        assertThrows(IllegalArgumentException.class, () -> new BinaryExpression(null, null, "4"));
    }

    @Test
    void testOperatorCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BinaryExpression(new Number(3.0), new Number(2.0), "");
        }, "Operator cannot be empty.");
    }

    @Test
    void testOperatorCannotBeNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BinaryExpression(new Number(3.0), new Number(2.0), "5");
        }, "Operator cannot be a number.");
    }
    
}
