package no.uib.oop.view;

import java.awt.geom.Rectangle2D;
import no.uib.oop.grid.CellPosition;
import no.uib.oop.grid.GridDimension;

public class CellPositionToPixelConverter {

    private final Rectangle2D box;
    private final GridDimension gd;
    private final double margin;

    public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
        this.box = box;
        this.gd = gd;
        this.margin = margin;
    }

    public Rectangle2D getBoundsForCell(CellPosition pos) {
        double totalInnerMarginX = Math.max(0, (gd.cols() - 1) * margin);
        double totalInnerMarginY = Math.max(0, (gd.rows() - 1) * margin);

        double cellWidth = (box.getWidth() - totalInnerMarginX) / gd.cols();
        double cellHeight = (box.getHeight() - totalInnerMarginY) / gd.rows();

        double x = box.getX() + pos.col() * (cellWidth + margin);
        double y = box.getY() + pos.row() * (cellHeight + margin);

        return new Rectangle2D.Double(x, y, cellWidth, cellHeight);
    }
}
