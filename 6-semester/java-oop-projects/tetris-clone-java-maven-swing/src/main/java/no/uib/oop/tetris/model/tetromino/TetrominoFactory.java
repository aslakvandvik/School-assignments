package no.uib.oop.tetris.model.tetromino;

/**
 * Factory for creating tetrominoes.
 */
public interface TetrominoFactory {

  /**
   * Gets the next tetromino.
   *
   * @return the next tetromino
   */
  Tetromino getNext();
}
