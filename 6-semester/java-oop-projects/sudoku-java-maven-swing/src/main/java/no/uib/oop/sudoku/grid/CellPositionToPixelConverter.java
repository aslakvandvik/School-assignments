package no.uib.oop.sudoku.grid;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A CellPositionToPixelConverter is an object which can translate
 * between a location in a grid and its pixel locations on a grid.
 */
public class CellPositionToPixelConverter {
  private final Rectangle2D box;
  private final GridDimension gd;
  private final double margin;
  private double cellW;
  private double cellH;

  /**
   * Constructs a new CellPositionToPixelConverter.
   *
   * @param box bounding box surrounding the pixelated area in which to draw the grid.
   * @param gd number of rows and columns in the grid to draw.
   * @param margin distance in pixels between neighboring cells, and to the bounding box
   */
  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.gd = gd;
    this.margin = margin;
    this.cellW = (box.getWidth() - margin * gd.cols() - margin) / gd.cols();
    this.cellH = (box.getHeight() - margin * gd.rows() - margin) / gd.rows();
  }

  /**
   * Gets the pixelary bounding box for the given CellPosition
   *
   * @param pos position in grid
   * @return box indicating pixel coordinates where it should be drawn
   */
  public Rectangle2D getBoundsForCell(CellPosition pos) {
    double cellX = box.getX() + margin + (cellW + margin) * pos.col();
    double cellY = box.getY() + margin + (cellH + margin) * pos.row();
    return new Rectangle2D.Double(cellX, cellY, cellW, cellH);
  }

  /**
   * Gets the CellPosition of the grid corresponding to the given (x, y)
   * coordinate. Returns null if the point does not correspond to a cell
   * in the grid.
   *
   * @param point a non-null pixel location
   * @return the corresponding CellPosition, or null if none exist
   */
  public CellPosition getCellPositionOfPoint(Point2D point) {
    double col = (point.getX() - box.getX() - margin) / (cellW + margin);
    double row = (point.getY() - box.getY() - margin) / (cellH + margin);

    if (row < 0 || row >= gd.rows() || col < 0 || col >= gd.cols()) return null;

    CellPosition pos = new CellPosition((int) row, (int) col);
    if (getBoundsForCell(pos).contains(point)) {
      return pos;
    } else {
      return null;
    }
  }
}