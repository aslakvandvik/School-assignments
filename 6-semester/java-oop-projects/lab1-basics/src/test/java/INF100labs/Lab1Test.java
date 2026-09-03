package INF100labs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Lab1Test {

    private static ByteArrayOutputStream outputStream;
    
    @BeforeEach
	void setup() {
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
	}
	
	// ############ task1 ############
	@Test
	void task1() {
        Lab1.task1();
        String[] output = outputStream.toString().split("\n");
        assertEquals("Hei, det er meg, datamaskinen.", output[0].trim());
        assertEquals("Hyggelig å se deg her.", output[1].trim());
        assertEquals("Lykke til med this OOP course!", output[2].trim());
    }

    // ############ task2 ############
	@Test
	void task2() {
        String input = "Kari Nordmann\nGateveien 1\n1234 Stedet\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Lab1.task2();
        
        String[] output = outputStream.toString().split("\n");
        assertEquals("Hva er ditt navn?", output[0].trim());
        assertEquals("Hva er din adresse?", output[1].trim());
        assertEquals("Hva er ditt postnummer og poststed?", output[2].trim());

        assertEquals("Kari Nordmanns adresse er:", output[3].trim());
        assertEquals("", output[4].trim());
        assertEquals("Kari Nordmann", output[5].trim());
        assertEquals("Gateveien 1", output[6].trim());
        assertEquals("1234 Stedet", output[7].trim());
    }
    
}
