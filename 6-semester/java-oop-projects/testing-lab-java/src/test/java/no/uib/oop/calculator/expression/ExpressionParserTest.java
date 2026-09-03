package no.uib.oop.calculator.expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParserTest {

    // ############# NUMBER #############

    @Test
    void testCorrectTypeAssignedNumber() {
        Expression exp = ExpressionParser.parse("5");
        assert exp != null;
        assertEquals(Number.class, exp.getClass(), "Expression should be parsed to Number.");
    }

    @Test
    void testParseNegativeNumber() {
        Expression exp = ExpressionParser.parse("-5");
        assert exp != null;
        assertTrue(exp.isNumber(), "Expression should be a number.");
        assertEquals(-5.0, exp.getNumberValue(), "Number value should be -5.0.");
    }

    // ############# UNARY EXPRESSION #############

    @Test
    void testCorrectTypeAssignedUnaryExpression() {
        Expression exp = ExpressionParser.parse("√3");
        assert exp != null;
        assertEquals(UnaryExpression.class, exp.getClass(), "Expression should be parsed to UnaryExpression.");
    }

    @Test
    void testParseValidUnaryExpressionLeft() {
        Expression exp = ExpressionParser.parse("3!");
        assert exp != null;
        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("!", exp.getOperator(), "Operator should be !");
        assertEquals(3.0, ((UnaryExpression) exp).getOperand().getNumberValue(), "Operand should be 3.0");

    }

    @Test
    void testParseValidUnaryExpressionRight() {
        Expression exp = ExpressionParser.parse("√3");
        assert exp != null;
        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("√", exp.getOperator(), "Operator should be √");
        assertEquals(3.0, ((UnaryExpression) exp).getOperand().getNumberValue(), "Operand should be 3.0");

    }

    @Test
    void testParseInvalidUnaryExpression() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExpressionParser.parse("3!3");
        }, "Parsing an invalid expression should throw an exception.");
    }

    @Test
    void testParseUnaryExpressionWithNegativeNumbers() {
        Expression expr = ExpressionParser.parse("-25!");
        assert expr != null;
        assertEquals("!", expr.getOperator());
        assertEquals(-25.0, ((UnaryExpression) expr).getOperand().getNumberValue(), 0.001);
    }

    @Test
    void testParseLog() {
        Expression exp = ExpressionParser.parse("log 10");
        assert exp != null;
        assertEquals("log", exp.getOperator());
        assertEquals(10, ((UnaryExpression) exp).getOperand().getNumberValue(), 0.001);
    }

    @Test
    void testParseLn() {
        Expression exp = ExpressionParser.parse("ln 10");
        assert exp != null;
        assertEquals("ln", exp.getOperator());
        assertEquals(10, ((UnaryExpression) exp).getOperand().getNumberValue(), 0.001);
    }


    // ############# BINARY EXPRESSION #############

    @Test
    void testCorrectTypeAssignedBinaryExpression() {
        Expression exp = ExpressionParser.parse("3 + 2");
        assert exp != null;
        assertEquals(BinaryExpression.class, exp.getClass(), "Expression should be parsed to BinaryExpression.");
    }

    @Test
    void testParseValidBinaryExpression() {
        Expression exp = ExpressionParser.parse("3 + 2");
        assert exp != null;
        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("+", exp.getOperator(), "Operator should be +");
        assertEquals(3.0, ((BinaryExpression) exp).getOperand1().getNumberValue(), "Left operand should be 3.0");
        assertEquals(2.0, ((BinaryExpression) exp).getOperand2().getNumberValue(), "Right operand should be 2.0");

    }

    @Test
    void testParseComplexBinaryExpression() {
        Expression exp = ExpressionParser.parse("3 + 2 * 5");

        assert exp != null;
        assertFalse(exp.isNumber(), "Expression should not be a number.");
        assertEquals("+", exp.getOperator(), "Operator should be +");

        Expression left = ((BinaryExpression) exp).getOperand1();
        assertEquals(3.0, left.getNumberValue(), "Left operand should be 3.0.");

        Expression right = ((BinaryExpression) exp).getOperand2();
        assertEquals("*", right.getOperator(), "Right operator should be *");
        assertEquals(2.0, ((BinaryExpression) right).getOperand1().getNumberValue(), "Left operand of multiplication should be 2.0.");
        assertEquals(5.0, ((BinaryExpression) right).getOperand2().getNumberValue(), "Right operand of multiplication should be 5.0.");
    }

    @Test
    void testParseInvalidBinaryExpression() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExpressionParser.parse("3 + ");
        }, "Parsing an invalid expression should throw an exception.");
    }

    @Test
    void testParseBinaryExpressionWithNegativeNumbers() {
        Expression expr = ExpressionParser.parse("-3+5");
        assert expr != null;
        assertEquals("+", expr.getOperator());
        assertEquals(-3.0, ((BinaryExpression) expr).getOperand1().getNumberValue(), 0.001);
        assertEquals(5.0, ((BinaryExpression) expr).getOperand2().getNumberValue(), 0.001);
    }

    @Test
    void testParseHandlesWhitespace() {
        Expression expr = ExpressionParser.parse("  1  +  2 ");
        assert expr != null;
        assertEquals("+", expr.getOperator());
        assertEquals(1.0, ((BinaryExpression) expr).getOperand1().getNumberValue(), 0.001);
        assertEquals(2.0, ((BinaryExpression) expr).getOperand2().getNumberValue(), 0.001);
    }

    @Test
    void testParseInvalidOperator() {
        assertThrows(IllegalArgumentException.class, () -> {
            ExpressionParser.parse("3 r 5 ");
        }, "Parsing an invalid expression should throw an exception.");
    }

    @Test
    void testSimpleParenthesesExpression() {
        Expression result = ExpressionParser.parse("(3 + 5)");
        assertEquals(new BinaryExpression(new Number(3), new Number(5), "+"), result);
    }

    @Test
    void testNestedParenthesesExpression() {
        Expression result = ExpressionParser.parse("((4 - 2) * 3) + 1");
        Expression expected = new BinaryExpression(
            new BinaryExpression(
                new BinaryExpression(new Number(4), new Number(2), "-"),
                new Number(3),
                "*"
            ),
            new Number(1),
            "+"
        );
        assertEquals(expected, result);
    }

    @Test
    void testParenthesesWithUnaryOperator() {
        Expression result = ExpressionParser.parse("√(9)");
        assertEquals(new UnaryExpression(new Number(9), "√"), result);
    }

    @Test
    void testParenthesesWithLogFunction() {
        Expression result = ExpressionParser.parse("log(100)");
        assertEquals(new UnaryExpression(new Number(100), "log"), result);
    }

    @Test
    void testParenthesesWithMixedOperators() {
        Expression result = ExpressionParser.parse("5 * (2 + (3 - 1))");
        Expression expected = new BinaryExpression(
            new Number(5),
            new BinaryExpression(
                new Number(2),
                new BinaryExpression(new Number(3), new Number(1), "-"),
                "+"
            ),
            "*"
        );
        assertEquals(expected, result);
    }

    @Test
    void testUnbalancedParenthesesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parse("(3 + 5"));
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parse("((4 - 2) * 3 + 1"));
        assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parse("5 * (2 + (3 - 1)"));
    }

}
