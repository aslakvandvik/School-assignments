package no.uib.this OOP course.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.Grid;
import no.uib.this OOP course.grid.GridCell;

/**
 * Tests for {@link Tetromino}.
 */
public class TestTetromino {

  @Test
  void equalTetrominoesHaveEqualHashCode() {
    Tetromino a = Tetromino.newTetromino('T');
    Tetromino b = Tetromino.newTetromino('T');

    assertEquals(a, b);
    assertEquals(a.hashCode(), b.hashCode());
  }

  @Test
  void shiftedTetrominoIsNotEqualToOriginal() {
    Tetromino original = Tetromino.newTetromino('L');
    Tetromino shifted = original.shiftedBy(1, 2);

    assertNotEquals(original, shifted);
  }

  @Test
  void iteratorReturnsOnlyTetrominoCells() {
    Tetromino tetromino = Tetromino.newTetromino('O');
    List<GridCell> cells = toList(tetromino);

    assertEquals(4, cells.size());
    assertTrue(cells.contains(new GridCell(new CellPosition(1, 1), 'O')));
    assertTrue(cells.contains(new GridCell(new CellPosition(2, 2), 'O')));
  }

  @Test
  void shiftedToTopCenterPlacesTetrominoAtTopCenter() {
    Tetromino tetromino = Tetromino.newTetromino('O')
        .shiftedToTopCenterOf(new Grid(15, 10));
    List<GridCell> cells = toList(tetromino);

    assertTrue(cells.contains(new GridCell(new CellPosition(1, 5), 'O')));
    assertTrue(cells.contains(new GridCell(new CellPosition(2, 6), 'O')));
  }

  @Test
  void shiftedByMovesTetrominoCells() {
    Tetromino tetromino = Tetromino.newTetromino('O').shiftedBy(2, 3);
    List<GridCell> cells = toList(tetromino);

    assertTrue(cells.contains(new GridCell(new CellPosition(3, 4), 'O')));
    assertTrue(cells.contains(new GridCell(new CellPosition(4, 5), 'O')));
  }

  @Test
  void rotatedTetrominoMatchesExpectedTShape() {
    Tetromino tetromino = Tetromino.newTetromino('T').rotated();
    List<GridCell> cells = toList(tetromino);

    assertEquals(4, cells.size());
    assertTrue(cells.contains(new GridCell(new CellPosition(0, 1), 'T')));
    assertTrue(cells.contains(new GridCell(new CellPosition(1, 0), 'T')));
    assertTrue(cells.contains(new GridCell(new CellPosition(1, 1), 'T')));
    assertTrue(cells.contains(new GridCell(new CellPosition(2, 1), 'T')));
  }

  @Test
  void fourRotationsReturnOriginalTetromino() {
    Tetromino tetromino = Tetromino.newTetromino('L');

    Tetromino rotated = tetromino.rotated()
        .rotated()
        .rotated()
        .rotated();

    assertEquals(tetromino, rotated);
  }

  @Test
  void oTetrominoDoesNotMoveWhenRotated() {
    Tetromino tetromino = Tetromino.newTetromino('O');

    assertEquals(tetromino, tetromino.rotated());
  }

  private List<GridCell> toList(Tetromino tetromino) {
    List<GridCell> cells = new ArrayList<>();
    for (GridCell cell : tetromino) {
      cells.add(cell);
    }
    return cells;
  }
}