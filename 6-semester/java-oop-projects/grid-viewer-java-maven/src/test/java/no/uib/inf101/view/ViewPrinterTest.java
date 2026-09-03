package no.uib.this OOP course.view;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.Test;

public class ViewPrinterTest {
    
    @Test
    public void gridHasBeenPrinted() {
        String filename = "grid.png";
        File file = new File("grid.png");
        if (!file.exists())
            fail("There is no file on the specified path named: " + filename);
    }
}
