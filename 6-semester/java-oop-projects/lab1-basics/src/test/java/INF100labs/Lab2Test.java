package INF100labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab2Test {

    private static ByteArrayOutputStream outputStream;
    
    @BeforeEach
	void setup() {
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
	}
	
	// ############ findLongestWords ############
	@Test
	void findLongestWordsTest1() {
        Lab2.findLongestWords("Game", "Action", "Champion");
        String[] output = outputStream.toString().split("\n");
        assertEquals("Champion", output[0].trim());
    }

    @Test
	void findLongestWordsTest2() {
        Lab2.findLongestWords("apple", "carrot", "ananas");
        String[] output = outputStream.toString().split("\n");
        assertEquals("carrot", output[0].trim());
        assertEquals("ananas", output[1].trim());
    }

    @Test
	void findLongestWordsTest3() {
        Lab2.findLongestWords("Four", "Five", "Nine");
        String[] output = outputStream.toString().split("\n");
        assertEquals("Four", output[0].trim());
        assertEquals("Five", output[1].trim());
        assertEquals("Nine", output[2].trim());
    }

    // ############ isLeapYear ############
    @Test
	void isLeapYear1() {
        int year = 2022;
        boolean isLeapYear = Lab2.isLeapYear(year);
        assertFalse(isLeapYear);
    }

    @Test
	void isLeapYear2() {
        int year = 1996;
        boolean isLeapYear = Lab2.isLeapYear(year);
        assertTrue(isLeapYear);
    }

    @Test
	void isLeapYear3() {
        int year = 1900;
        boolean isLeapYear = Lab2.isLeapYear(year);
        assertFalse(isLeapYear);
    }

    @Test
	void isLeapYear4() {
        int year = 2000;
        boolean isLeapYear = Lab2.isLeapYear(year);
        assertTrue(isLeapYear);
    }

    // ############ isEvenPositiveInt ############
    @Test
	void isEvenPositiveInt1() {
        int num = 123456;
        boolean isEvenPositiveInt = Lab2.isEvenPositiveInt(num);
        assertTrue(isEvenPositiveInt);
    }

    @Test
	void isEvenPositiveInt2() {
        int num = -2;
        boolean isEvenPositiveInt = Lab2.isEvenPositiveInt(num);
        assertFalse(isEvenPositiveInt);
    }

    @Test
	void isEvenPositiveInt3() {
        int num = 123;
        boolean isEvenPositiveInt = Lab2.isEvenPositiveInt(num);
        assertFalse(isEvenPositiveInt);
    }
}
