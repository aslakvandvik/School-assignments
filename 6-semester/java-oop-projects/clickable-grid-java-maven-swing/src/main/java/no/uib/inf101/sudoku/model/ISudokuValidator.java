package no.uib.this OOP course.sudoku.model;

import no.uib.this OOP course.sudoku.grid.CellPosition;

/**
 * Contract for Sudoku move validators.
 * The model depends on this interface instead of a concrete validator class.
 */
public interface ISudokuValidator {

  /**
   * Checks whether a candidate value can be placed at a given position.
   *
   * @param board current board state
   * @param pos position to validate
   * @param value value from 1-9
   * @return true if move is valid
   */
  boolean isMoveValid(SudokuBoard board, CellPosition pos, int value);
}