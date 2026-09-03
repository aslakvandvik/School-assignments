package no.uib.this OOP course.tetris.view;

import java.awt.Color;

public interface ColorTheme {
    
    /**
     * The color of a given character
     *
     * @param c the character to find the color of
     * @return  a color
     */
    Color getCellColor(Character c);

    /**
     * The color of the frame
     *
     * @return a color
     */
    Color getFrameColor();

    /**
     * The color of the background
     *
     * @return background color
     */
    Color getBackgroundColor();

    /**
     * The color of text in pop up
     *
     * @return a color
     */
    Color getPopUpColor();


}
