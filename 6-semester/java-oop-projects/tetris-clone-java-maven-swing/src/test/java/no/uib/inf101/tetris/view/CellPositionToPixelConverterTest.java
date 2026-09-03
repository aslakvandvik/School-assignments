package no.uib.this OOP course.tetris.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.geom.Rectangle2D;

import org.junit.jupiter.api.Test;

import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.GridDimension;
import no.uib.this OOP course.grid.Grid;
import no.uib.this OOP course.tetris.view.CellPositionToPixelConverter;

public class CellPositionToPixelConverterTest {

    @Test
    public void sanityTest() {
        GridDimension gd = new Grid(3, 4);
        CellPositionToPixelConverter converter = new CellPositionToPixelConverter(
                new Rectangle2D.Double(29, 29, 340, 240), gd, 30);
        Rectangle2D expected = new Rectangle2D.Double(214, 129, 47.5, 40);
        assertEquals(expected, converter.getBoundsForCell(new CellPosition(1, 2)));
    }

}
