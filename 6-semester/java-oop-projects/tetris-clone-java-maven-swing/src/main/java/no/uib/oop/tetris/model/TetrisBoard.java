package no.uib.oop.tetris.model;

import java.util.Iterator;

import no.uib.oop.grid.CellPosition;
import no.uib.oop.grid.GridCell;
import no.uib.oop.grid.GridDimension;
import no.uib.oop.grid.IGrid;
import no.uib.oop.grid.Grid;
import no.uib.oop.tetris.model.tetromino.Tetromino;

/**
 * Represents the Tetris board backed by an IGrid.
 */
public class TetrisBoard implements Iterable<GridCell>, GridDimension {

  public static final char EMPTY = '-';

	private final IGrid grid;

  /**
   * Creates a board backed by the given grid.
   *
   * @param grid the underlying grid
   */
  public TetrisBoard(IGrid grid) {
    this.grid = grid;
  }

  /**
   * Creates an empty board with the given size.
   *
   * @param rows number of rows
   * @param cols number of columns
   */
  public TetrisBoard(int rows, int cols) {
    this(new Grid(rows, cols, EMPTY));
  }

  @Override
  public Iterator<GridCell> iterator() {
    return this.grid.iterator();
  }

  @Override
  public int rows() {
    return this.grid.rows();
  }

  @Override
  public int cols() {
    return this.grid.cols();
  }

  /**
   * Stores a value at the given board position.
   *
   * @param pos the position to write to
   * @param value the value to store
   */
  public void set(CellPosition pos, Character value) {
    this.grid.set(pos, value);
  }

	/**
	 * Gets the value at the given board position.
	 *
	 * @param pos the position to read from
	 * @return the value stored at the position
	 */
	public Character get(CellPosition pos) {
		return this.grid.get(pos);
	}

	/**
	 * Reports whether the given position is empty on the board.
	 *
	 * @param pos the position to check
	 * @return true if the position stores the empty symbol
	 */
	public boolean isFree(CellPosition pos) {
		return this.get(pos) == EMPTY;
	}

  /**
   * Writes all cells from the given tetromino into the board.
   *
   * @param tetromino the tetromino to place
   */
  public void addTetromino(Tetromino tetromino) {
    for (GridCell cell : tetromino) {
      this.set(cell.pos(), cell.value());
    }
  }

  /**
   * Clears all filled rows and returns the number of cleared rows.
   *
   * @return number of cleared rows
   */
  public int clearRows() {
    int clearedRows = 0;
    for (int row = this.rows() - 1; row >= 0; row--) {
      if (this.isRowFilled(row)) {
        this.removeRow(row);
        clearedRows++;
        row++;
      }
    }
    return clearedRows;
  }

  /**
   * Clears the entire board.
   */
  public void clearBoard() {
    for (int row = 0; row < this.rows(); row++) {
      for (int col = 0; col < this.cols(); col++) {
        this.set(new CellPosition(row, col), EMPTY);
      }
    }
  }

  private boolean isRowFilled(int row) {
    for (int col = 0; col < this.cols(); col++) {
      if (this.isFree(new CellPosition(row, col))) {
        return false;
      }
    }
    return true;
  }

  private void removeRow(int row) {
    for (int moveRow = row; moveRow > 0; moveRow--) {
      this.copyRowTo(moveRow - 1, moveRow);
    }
    this.fillTopRowWithEmpty();
  }

  private void copyRowTo(int originalRow, int targetRow) {
    for (int col = 0; col < this.cols(); col++) {
      CellPosition from = new CellPosition(originalRow, col);
      CellPosition to = new CellPosition(targetRow, col);
      this.set(to, this.get(from));
    }
  }

  private void fillTopRowWithEmpty() {
    for (int col = 0; col < this.cols(); col++) {
      this.set(new CellPosition(0, col), EMPTY);
    }
  }

}
