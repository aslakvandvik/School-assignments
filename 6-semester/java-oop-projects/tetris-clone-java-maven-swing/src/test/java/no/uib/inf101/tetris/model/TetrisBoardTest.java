package no.uib.this OOP course.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.Grid;
import no.uib.this OOP course.grid.GridCell;
import no.uib.this OOP course.tetris.model.tetromino.Tetromino;

/**
 * Tests for {@link TetrisBoard}.
 */
public class TetrisBoardTest {

  @Test
  void testConstructStartsWithEmpty() {
    int rows = 3;
    int cols = 5;
    Grid grid = new Grid(rows, cols, '-');
    TetrisBoard board = new TetrisBoard(grid);
    int countFree = 0;
    int countTaken = 0;

    for (GridCell cell : board) {
      if (board.isFree(cell.pos())) {
        countFree++;
      } else {
        countTaken++;
      }
    }

    assertEquals(rows * cols, countFree);
    assertEquals(0, countTaken);
  }

  @Test
  void boardReportsCorrectSizeFromRowsAndColsConstructor() {
    TetrisBoard board = new TetrisBoard(3, 4);

    assertEquals(3, board.rows());
    assertEquals(4, board.cols());
  }

  @Test
  void boardStoresAndReturnsValues() {
    TetrisBoard board = new TetrisBoard(3, 4);
    CellPosition pos = new CellPosition(1, 2);

    assertEquals(TetrisBoard.EMPTY, board.get(pos));

    board.set(pos, 'A');

    assertEquals('A', board.get(pos));
  }

  @Test
  void iteratorReturnsAllCells() {
    TetrisBoard board = new TetrisBoard(2, 3);
    List<GridCell> cells = new ArrayList<>();

    for (GridCell cell : board) {
      cells.add(cell);
    }

    assertEquals(6, cells.size());
    assertTrue(cells.contains(new GridCell(new CellPosition(0, 0), '-')));
    assertTrue(cells.contains(new GridCell(new CellPosition(1, 2), '-')));
  }

  @Test
  void positionIsOnGridMatchesBoardSize() {
    TetrisBoard board = new TetrisBoard(3, 4);

    assertTrue(board.positionIsOnGrid(new CellPosition(0, 0)));
    assertTrue(board.positionIsOnGrid(new CellPosition(2, 3)));
    assertFalse(board.positionIsOnGrid(new CellPosition(3, 3)));
    assertFalse(board.positionIsOnGrid(new CellPosition(2, 4)));
    assertFalse(board.positionIsOnGrid(new CellPosition(-1, 0)));
  }

  @Test
  void isFreeReturnsTrueOnlyForEmptyCells() {
    TetrisBoard board = new TetrisBoard(3, 4);
    CellPosition pos = new CellPosition(1, 1);

    assertTrue(board.isFree(pos));

    board.set(pos, 'L');

    assertFalse(board.isFree(pos));
  }

  @Test
  void addTetrominoWritesTetrominoToBoard() {
    TetrisBoard board = new TetrisBoard(5, 5);
    Tetromino tetromino = Tetromino.newTetromino('O').shiftedBy(0, -1);

    board.addTetromino(tetromino);

    assertEquals('O', board.get(new CellPosition(1, 0)));
    assertEquals('O', board.get(new CellPosition(1, 1)));
    assertEquals('O', board.get(new CellPosition(2, 0)));
    assertEquals('O', board.get(new CellPosition(2, 1)));
  }

  @Test
  public void testFullRowClears() {
    int row = 10;

    Grid grid = new Grid(15, 10, '-');
    for (CellPosition pos : grid.positions()) {
      if (pos.row() == 10) {
        grid.set(pos, 'I');
      }
      if (pos.row() > 10) {
        if ((pos.row() + pos.col()) % 2 == 0) {
          grid.set(pos, 'O');
        }
      }
    }
    TetrisBoard board = new TetrisBoard(grid);
    int cleared = board.clearRows();

    assertEquals(1, cleared);

    for (int col = 0; col < 10; col++) {
      assertTrue(board.isFree(new CellPosition(row, col)));
    }
  }

  @Test
  void bottomRowCanBeCleared() {
    Grid grid = new Grid(4, 4, '-');
    for (int col = 0; col < 4; col++) {
      grid.set(new CellPosition(3, col), 'T');
    }
    TetrisBoard board = new TetrisBoard(grid);

    int cleared = board.clearRows();

    assertEquals(1, cleared);
    for (int col = 0; col < 4; col++) {
      assertTrue(board.isFree(new CellPosition(3, col)));
    }
  }

  @Test
  void topRowCanBeCleared() {
    Grid grid = new Grid(4, 4, '-');
    for (int col = 0; col < 4; col++) {
      grid.set(new CellPosition(0, col), 'T');
    }
    TetrisBoard board = new TetrisBoard(grid);

    int cleared = board.clearRows();

    assertEquals(1, cleared);
    for (int col = 0; col < 4; col++) {
      assertTrue(board.isFree(new CellPosition(0, col)));
    }
  }
}
