package no.uib.oop.sudoku.model;

import no.uib.oop.sudoku.grid.CellPosition;

/**
 * Stores the Sudoku board state.
 * The board arrays are private, and access goes through methods like
 * {@link #getValue(CellPosition)} and {@link #setValue(CellPosition, int)}.
 */
public class SudokuBoard {

  private static final int SIZE = 9;

  private final int[][] values = new int[SIZE][SIZE];
  private final boolean[][] fixed = new boolean[SIZE][SIZE];

  /**
   * Creates a board from nine strings with nine digits each.
   * Digit 0 means an empty cell.
   *
   * @param rows nine strings describing the puzzle
   */
  public SudokuBoard(String... rows) {
    load(rows);
  }

  public int getValue(CellPosition pos) {
    return this.values[pos.row()][pos.col()];
  }

  public boolean isFixed(CellPosition pos) {
    return this.fixed[pos.row()][pos.col()];
  }

  public void setValue(CellPosition pos, int value) {
    ensureEditable(pos);
    this.values[pos.row()][pos.col()] = value;
  }

  public void clear(CellPosition pos) {
    setValue(pos, 0);
  }

  public boolean isSolved() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (values[row][col] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Clears all editable (non-fixed) cells.
   */
  public void resetEditableCells() {
    for (int row = 0; row < SIZE; row++) {
      for (int col = 0; col < SIZE; col++) {
        if (!fixed[row][col]) {
          values[row][col] = 0;
        }
      }
    }
  }

  private void load(String... rows) {
    if (rows.length != SIZE) {
      throw new IllegalArgumentException("A Sudoku board must contain exactly 9 rows.");
    }

    for (int row = 0; row < SIZE; row++) {
      String line = rows[row];
      if (line.length() != SIZE) {
        throw new IllegalArgumentException("Each Sudoku row must contain exactly 9 digits.");
      }

      for (int col = 0; col < SIZE; col++) {
        int value = line.charAt(col) - '0';
        values[row][col] = value;
        fixed[row][col] = value != 0;
      }
    }
  }

  private void ensureEditable(CellPosition pos) {
    if (isFixed(pos)) {
      throw new IllegalStateException("This cell is fixed and cannot be changed.");
    }
  }
}