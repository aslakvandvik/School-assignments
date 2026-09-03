package no.uib.oop.tetris.model.tetromino;

/**
 * Test factory that returns tetrominoes in a repeating pattern.
 */
public class PatternedTetrominoFactory implements TetrominoFactory {

  private final String pattern;
  private int index;

  /**
   * Creates a patterned tetromino factory.
   *
   * @param pattern the repeating tetromino symbol pattern
   */
  public PatternedTetrominoFactory(String pattern) {
    this.pattern = pattern;
    this.index = 0;
  }

  @Override
  public Tetromino getNext() {
    char symbol = this.pattern.charAt(this.index);
    this.index = (this.index + 1) % this.pattern.length();
    return Tetromino.newTetromino(symbol);
  }
}
