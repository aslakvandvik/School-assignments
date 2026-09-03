package no.uib.oop.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.oop.grid.GridCell;

/**
 * Tests for {@link PatternedTetrominoFactory}.
 */
public class TestPatternedTetrominoFactory {

  @Test
  void factoryRepeatsPattern() {
    PatternedTetrominoFactory factory = new PatternedTetrominoFactory("OI");

    assertEquals('O', firstValue(factory.getNext()));
    assertEquals('I', firstValue(factory.getNext()));
    assertEquals('O', firstValue(factory.getNext()));
  }

  private char firstValue(Tetromino tetromino) {
    List<GridCell> cells = new ArrayList<>();
    for (GridCell cell : tetromino) {
      cells.add(cell);
    }
    return cells.get(0).value();
  }
}
