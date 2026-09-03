package INF100labs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab3Test {

    private static ByteArrayOutputStream outputStream;
    
    @BeforeEach
	void setup() {
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
	}
	
	// ############ multiplesOfSevenUpTo ############
	@Test
	void multiplesOfSevenUpTo1() {
        Lab3.multiplesOfSevenUpTo(49);
        String[] output = outputStream.toString().split("\n");
        assertEquals("7", output[0].trim());
        assertEquals("14", output[1].trim());
        assertEquals("21", output[2].trim());
        assertEquals("28", output[3].trim());
        assertEquals("35", output[4].trim());
        assertEquals("42", output[5].trim());
        assertEquals("49", output[6].trim());
    }

    @Test
	void multiplesOfSevenUpTo2() {
        Lab3.multiplesOfSevenUpTo(35);
        String[] output = outputStream.toString().split("\n");
        assertEquals("7", output[0].trim());
        assertEquals("14", output[1].trim());
        assertEquals("21", output[2].trim());
        assertEquals("28", output[3].trim());
        assertEquals("35", output[4].trim());
    }

    @Test
	void multiplesOfSevenUpTo3() {
        Lab3.multiplesOfSevenUpTo(80);
        String[] output = outputStream.toString().split("\n");
        assertEquals("7", output[0].trim());
        assertEquals("14", output[1].trim());
        assertEquals("21", output[2].trim());
        assertEquals("28", output[3].trim());
        assertEquals("35", output[4].trim());
        assertEquals("42", output[5].trim());
        assertEquals("49", output[6].trim());
        assertEquals("56", output[7].trim());
        assertEquals("63", output[8].trim());
        assertEquals("70", output[9].trim());
        assertEquals("77", output[10].trim());
    }

    // ############ multiplicationTable ############
	@Test
	void multiplicationTable1() {
        Lab3.multiplicationTable(3);
        String[] output = outputStream.toString().split("\n");
        assertEquals("1: 1 2 3", output[0].trim());
        assertEquals("2: 2 4 6", output[1].trim());
        assertEquals("3: 3 6 9", output[2].trim());
    }

    @Test
	void multiplicationTable2() {
        Lab3.multiplicationTable(5);
        String[] output = outputStream.toString().split("\n");
        assertEquals("1: 1 2 3 4 5", output[0].trim());
        assertEquals("2: 2 4 6 8 10", output[1].trim());
        assertEquals("3: 3 6 9 12 15", output[2].trim());
        assertEquals("4: 4 8 12 16 20", output[3].trim());
        assertEquals("5: 5 10 15 20 25", output[4].trim());
    }

     // ############ crossSum ############
	@Test
	void crossSum1() {
        int num = 1;
        int sum = Lab3.crossSum(num);
        assertEquals(1, sum);
    }    

    @Test
	void crossSum2() {
        int num = 12;
        int sum = Lab3.crossSum(num);
        assertEquals(3, sum);
    }  
    
    @Test
	void crossSum3() {
        int num = 123;
        int sum = Lab3.crossSum(num);
        assertEquals(6, sum);
    }

    @Test
	void crossSum4() {
        int num = 1234;
        int sum = Lab3.crossSum(num);
        assertEquals(10, sum);
    }  
    
    @Test
	void crossSum5() {
        int num = 4321;
        int sum = Lab3.crossSum(num);
        assertEquals(10, sum);
    }  

}