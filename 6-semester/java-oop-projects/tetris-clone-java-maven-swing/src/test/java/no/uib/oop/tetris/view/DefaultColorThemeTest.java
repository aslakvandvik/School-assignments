package no.uib.oop.tetris.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class DefaultColorThemeTest {

    @Test
    public void sanityDefaultColorThemeTest() {
        ColorTheme colors = new DefaultColorTheme();
        assertEquals(null, colors.getBackgroundColor());
        assertEquals(Color.DARK_GRAY, colors.getFrameColor());
        assertEquals(Color.BLACK, colors.getCellColor('-'));
        assertEquals(Color.WHITE, colors.getCellColor('w'));
        assertEquals(Color.ORANGE, colors.getCellColor('L'));
        assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));
    }

}
