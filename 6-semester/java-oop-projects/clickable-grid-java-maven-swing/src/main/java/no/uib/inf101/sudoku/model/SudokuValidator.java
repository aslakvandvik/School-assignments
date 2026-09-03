package no.uib.this OOP course.sudoku.model;

import no.uib.this OOP course.sudoku.grid.CellPosition;

/**
 * Validates Sudoku moves.
 * The validator checks row, column and 3x3 box rules.
 */
public final class SudokuValidator implements ISudokuValidator {

  @Override
  public boolean isMoveValid(SudokuBoard board, CellPosition pos, int value) {
    int row = pos.row();
    int col = pos.col();

    for (int c = 0; c < 9; c++) {
      if (c != col && board.getValue(new CellPosition(row, c)) == value) {
        return false;
      }
    }

    for (int r = 0; r < 9; r++) {
      if (r != row && board.getValue(new CellPosition(r, col)) == value) {
        return false;
      }
    }

    int boxStartRow = (row / 3) * 3;
    int boxStartCol = (col / 3) * 3;
    for (int r = boxStartRow; r < boxStartRow + 3; r++) {
      for (int c = boxStartCol; c < boxStartCol + 3; c++) {
        if ((r != row || c != col) && board.getValue(new CellPosition(r, c)) == value) {
          return false;
        }
      }
    }

    return true;
  }
}