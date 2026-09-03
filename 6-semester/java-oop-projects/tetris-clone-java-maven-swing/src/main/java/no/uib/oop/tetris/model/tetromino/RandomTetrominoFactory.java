package no.uib.oop.tetris.model.tetromino;

import java.util.Random;

/**
 * Factory that creates random tetrominoes.
 */
public class RandomTetrominoFactory implements TetrominoFactory {

  private static final String SYMBOLS = "LJSZTIO";

  private final Random random;

  /**
   * Creates a random tetromino factory.
   */
  public RandomTetrominoFactory() {
    this.random = new Random();
  }

  @Override
  public Tetromino getNext() {
    int index = this.random.nextInt(SYMBOLS.length());
    return Tetromino.newTetromino(SYMBOLS.charAt(index));
  }
}
