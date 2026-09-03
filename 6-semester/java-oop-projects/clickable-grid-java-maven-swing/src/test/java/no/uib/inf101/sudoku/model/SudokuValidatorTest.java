package no.uib.this OOP course.sudoku.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.uib.this OOP course.sudoku.grid.CellPosition;

/**
 * Tests for the SudokuValidator rules.
 */
class SudokuValidatorTest {

  private final ISudokuValidator validator = new SudokuValidator();

  /**
   * Verifies that a move is accepted when row, column and box are free.
   */
  @Test
  void acceptsMoveWhenRowColAndBoxAreFree() {
    SudokuBoard board = new SudokuBoard(
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000");

    assertTrue(validator.isMoveValid(board, new CellPosition(0, 0), 5));
  }

  /**
   * Verifies that a move is rejected when the value already exists in the row.
   */
  @Test
  void rejectsMoveWhenValueAlreadyExistsInRow() {
    SudokuBoard board = new SudokuBoard(
        "500000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000");

    assertFalse(validator.isMoveValid(board, new CellPosition(0, 4), 5));
  }

  /**
   * Verifies that a move is rejected when the value already exists in the column.
   */
  @Test
  void rejectsMoveWhenValueAlreadyExistsInColumn() {
    SudokuBoard board = new SudokuBoard(
        "500000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000");

    assertFalse(validator.isMoveValid(board, new CellPosition(4, 0), 5));
  }

  /**
   * Verifies that a move is rejected when the value already exists in the 3x3 box.
   */
  @Test
  void rejectsMoveWhenValueAlreadyExistsInBox() {
    SudokuBoard board = new SudokuBoard(
        "500000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000",
        "000000000");

    assertFalse(validator.isMoveValid(board, new CellPosition(1, 1), 5));
  }
}