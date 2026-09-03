package no.uib.oop.tetris.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme {

    @Override
    public Color getCellColor(Character c) {
        Color color = switch(c) {
            case 'r' -> Color.RED;
            case 'g' -> Color.GREEN;
            case 'y' -> Color.YELLOW;
            case 'b' -> Color.BLUE;
            case 'w' -> Color.WHITE;

            case 'L' -> Color.ORANGE;
            case 'J' -> Color.BLUE;
            case 'S' -> Color.GREEN;
            case 'Z' -> Color.RED;
            case 'T' -> Color.PINK;
            case 'I' -> Color.MAGENTA;
            case 'O' -> Color.YELLOW;
            case '-' -> Color.BLACK;
            default -> throw new IllegalArgumentException(
                    "No available color for '" + c + "'");
        };
        return color;
    }

    @Override
    public Color getFrameColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getBackgroundColor() {
        return null;
    }

	@Override
	public Color getPopUpColor() {
		return new Color(0, 0, 0, 128);
	}

}
