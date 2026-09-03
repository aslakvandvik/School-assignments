package no.uib.this OOP course.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    @Test
    void testNumberConstructor() {
        Expression exp = new Expression(5.0);
        assertTrue(exp.isNumber(), "Expression should be a number.");
        assertEquals(5.0, exp.getNumberValue(), "Number value should be 5.0.");
    }

    @Test
    void testConstructorWithValidExpression() {
        Expression expr1 = new Expression(2);
        Expression expr2 = new Expression(3);
        Expression expr = new Expression(expr1, expr2, "+");

        assertEquals("+", expr.getOperator());
        assertEquals(2.0, expr.getOperand1().getNumberValue());
        assertEquals(3.0, expr.getOperand2().getNumberValue());
    }

    @Test
    void testConstructorWithCompoundExpression() {
        Expression expr1 = new Expression(2);
        Expression expr2 = new Expression(3);
        Expression expr = new Expression(expr1, expr2, "+"); // 2 + 3
        Expression compoundExpr = new Expression(expr, expr2, "+"); // 2 + 3 + 3

        assertEquals("+", compoundExpr.getOperator());
        assertEquals(expr, compoundExpr.getOperand1());
        assertEquals(expr2, compoundExpr.getOperand2());
    }

    @Test
    void testExpressionEquals() {
        Expression expr1 = new Expression(new Expression(2), new Expression(3), "+");
        Expression expr2 = new Expression(new Expression(2), new Expression(3), "+");

        assertEquals(expr1, expr2);
    }

    @Test
    void testEqualsForDifferentExpressions() {
        Expression left1 = new Expression(3.0);
        Expression right1 = new Expression(2.0);
        Expression exp1 = new Expression(left1, right1, "+");

        Expression left2 = new Expression(5.0);
        Expression right2 = new Expression(1.0);
        Expression exp2 = new Expression(left2, right2, "-");

        assertNotEquals(exp1, exp2, "Two different expressions should not be equal.");
    }

    @Test
    void testConstructorWithInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> new Expression(null, null, null));
        assertThrows(IllegalArgumentException.class, () -> new Expression(null, null, ""));
        assertThrows(IllegalArgumentException.class, () -> new Expression(null, null, "4"));
    }

    @Test
    void testParseValidExpression() {
        Expression exp = Expression.parse("3 + 2");

        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("+", exp.getOperator(), "Operator should be +");
        assertEquals(3.0, exp.getOperand1().getNumberValue(), "Left operand should be 3.0.");
        assertEquals(2.0, exp.getOperand2().getNumberValue(), "Right operand should be 2.0.");
    }

    @Test
    void numberIsNullInExpression() {
        Expression expression = Expression.parse("42 + 23");
        assertFalse(expression.isNumber());
        assertThrows(IllegalStateException.class, () -> expression.getNumberValue());
    }

    @Test
    void testParseComplexExpression() {
        Expression exp = Expression.parse("3 + 2 * 5");

        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("+", exp.getOperator(), "Operator should be +");

        Expression left = exp.getOperand1();
        assertEquals(3.0, left.getNumberValue(), "Left operand should be 3.0.");

        Expression right = exp.getOperand2();
        assertEquals("*", right.getOperator(), "Right operator should be *");
        assertEquals(2.0, right.getOperand1().getNumberValue(), "Left operand of multiplication should be 2.0.");
        assertEquals(5.0, right.getOperand2().getNumberValue(), "Right operand of multiplication should be 5.0.");
    }

    @Test
    void testParseNegativeNumber() {
        Expression exp = Expression.parse("-5");

        assertTrue(exp.isNumber(), "Expression should be a number.");
        assertEquals(-5.0, exp.getNumberValue(), "Number value should be -5.0.");
    }

    @Test
    void testParseInvalidExpression() {
        assertThrows(IllegalArgumentException.class, () -> {
            Expression.parse("3 + ");
        }, "Parsing an invalid expression should throw an exception.");
    }

    @Test
    void testParseExpressionWithNegativeNumbers() {
        Expression expr = Expression.parse("-3+5");
        assertEquals("+", expr.getOperator());
        assertEquals(-3.0, expr.getOperand1().getNumberValue(), 0.001);
        assertEquals(5.0, expr.getOperand2().getNumberValue(), 0.001);
    }

    @Test
    void testParseHandlesWhitespace() {
        Expression expr = Expression.parse("  1  +  2 ");
        assertEquals("+", expr.getOperator());
        assertEquals(1.0, expr.getOperand1().getNumberValue(), 0.001);
        assertEquals(2.0, expr.getOperand2().getNumberValue(), 0.001);
    }

    @Test
    void testOperatorCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Expression(new Expression(3.0), new Expression(2.0), "");
        }, "Operator cannot be empty.");
    }

    @Test
    void testOperatorCannotBeNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Expression(new Expression(3.0), new Expression(2.0), "5");
        }, "Operator cannot be a number.");
    }
    
}
