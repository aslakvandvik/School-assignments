package no.uib.this OOP course.sudoku.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.uib.this OOP course.sudoku.grid.CellPosition;

/**
 * Tests for the SudokuBoard class.
 */
class SudokuBoardTest {

  private SudokuBoard testBoard() {
    return new SudokuBoard(
        "103000089",
        "000789100",
        "089100056",
        "214005897",
        "300897204",
        "807204065",
        "501040978",
        "040978030",
        "978001042");
  }

  /**
   * Verifies that fixed cells in the puzzle cannot be modified.
   */
  @Test
  void fixedCellsCannotBeChanged() {
    SudokuBoard board = testBoard();
    assertThrows(IllegalStateException.class, () -> board.setValue(new CellPosition(0, 0), 9));
  }

  /**
   * Verifies that editable cells can be updated and cleared again.
   */
  @Test
  void editableCellCanBeSetAndCleared() {
    SudokuBoard board = testBoard();
    CellPosition editable = new CellPosition(0, 1);

    board.setValue(editable, 5);
    assertEquals(5, board.getValue(editable));

    board.clear(editable);
    assertEquals(0, board.getValue(editable));
  }

  /**
   * Verifies that an incomplete board is not reported as solved.
   */
  @Test
  void solvedIsFalseWhenBoardHasEmptyCells() {
    SudokuBoard board = testBoard();
    assertFalse(board.isSolved());
  }

  /**
   * Verifies that a fully filled valid board is reported as solved.
   */
  @Test
  void solvedIsTrueWhenNoEmptyCellsExist() {
    SudokuBoard board = new SudokuBoard(
        "123456789",
        "456789123",
        "789123456",
        "214365897",
        "365897214",
        "897214365",
        "531642978",
        "642978531",
        "978531642");

    assertTrue(board.isSolved());
  }
}