package no.uib.oop.view;

import java.awt.Color;

public class ColorTheme {

    public Color getCellColor(Character c) {
        if (c == null) {
            return Color.BLACK;
        }
        switch (c.charValue()) {
            case 'r':
                return Color.RED;
            case 'g':
                return Color.GREEN;
            case 'y':
                return Color.YELLOW;
            case 'b':
                return Color.BLUE;
            case '-':
                return Color.BLACK;
            default:
                throw new IllegalArgumentException("Ingen tilgjengelig farge for dette tegnet: " + c);
        }
    }
}
