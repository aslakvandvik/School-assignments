package no.uib.oop.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.oop.grid.CellPosition;
import no.uib.oop.grid.GridCell;
import no.uib.oop.tetris.model.tetromino.PatternedTetrominoFactory;

/**
 * Tests for {@link TetrisModel}.
 */
public class TetrisModelTest {

  @Test
  void modelHasExpectedBoardSize() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));

    assertEquals(15, model.getDimension().rows());
    assertEquals(10, model.getDimension().cols());
  }

  @Test
  void modelStartsWithBoardAndTetrominoTiles() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));

    assertEquals(15 * 10, countTiles(model.getTilesOnBoard()));
    assertEquals(4, countTiles(model.getCurrentTetromino()));
  }

  @Test
  void movingTetrominoLeftChangesVisiblePositions() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));
    model.startGame();

    boolean changed = model.moveTetromino(0, -1);
    List<GridCell> tiles = toList(model.getCurrentTetromino());

    assertTrue(changed);
    assertTrue(tiles.contains(new GridCell(new CellPosition(1, 4), 'O')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(2, 5), 'O')));
  }

  @Test
  void tetrominoStopsAtBottom() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));
    model.startGame();
    boolean changed = true;

    while (changed) {
      changed = model.moveTetromino(1, 0);
    }

    assertFalse(model.moveTetromino(1, 0));
  }

  @Test
  void tetrominoCannotMoveOutOfLeftWall() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));
    model.startGame();

    while (model.moveTetromino(0, -1)) {
      // move as far left as possible
    }

    List<GridCell> before = toList(model.getCurrentTetromino());
    boolean changed = model.moveTetromino(0, -1);
    List<GridCell> after = toList(model.getCurrentTetromino());

    assertFalse(changed);
    assertEquals(before, after);
  }

  @Test
  void tetrominoCannotMoveIntoOccupiedCell() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("O"));
    model.startGame();
    board.set(new CellPosition(1, 4), 'X');

    List<GridCell> before = toList(model.getCurrentTetromino());
    boolean changed = model.moveTetromino(0, -1);
    List<GridCell> after = toList(model.getCurrentTetromino());

    assertFalse(changed);
    assertEquals(before, after);
  }

  @Test
  void rotatingTetrominoChangesVisiblePositions() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("T"));
    model.startGame();

    boolean changed = model.rotateTetromino();
    List<GridCell> tiles = toList(model.getCurrentTetromino());

    assertTrue(changed);
    assertTrue(tiles.contains(new GridCell(new CellPosition(0, 5), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(1, 4), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(1, 5), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(2, 5), 'T')));
  }

  @Test
  void tetrominoCannotRotateIntoOccupiedCell() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("T"));
    model.startGame();
    board.set(new CellPosition(0, 5), 'X');

    List<GridCell> before = toList(model.getCurrentTetromino());
    boolean changed = model.rotateTetromino();
    List<GridCell> after = toList(model.getCurrentTetromino());

    assertFalse(changed);
    assertEquals(before, after);
  }

  @Test
  void dropTetrominoLocksPieceToBoardAndSpawnsNewOne() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("OO"));
    model.startGame();

    boolean changed = model.dropTetromino();

    assertTrue(changed);
    assertEquals('O', valueAt(model.getTilesOnBoard(), 13, 5));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 13, 6));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 14, 5));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 14, 6));
    assertEquals(4, countTiles(model.getCurrentTetromino()));
  }

  @Test
  void gameStateStartsActive() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));

    assertEquals(GameState.WELCOME_SCREEN, model.getGameState());
  }

  @Test
  void timerDelayStartsAtOneSecond() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));

    assertEquals(1000, model.getTimerDelay());
  }

  @Test
  void startGameChangesStateToActiveGame() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));

    model.startGame();

    assertEquals(GameState.ACTIVE_GAME, model.getGameState());
  }

  @Test
  void gameOverWhenNewTetrominoCannotSpawn() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("OO"));
    model.startGame();

    model.dropTetromino();
    board.set(new CellPosition(1, 5), 'X');
    model.dropTetromino();

    assertEquals(GameState.GAME_OVER, model.getGameState());
  }

  @Test
  void cannotMoveAfterGameOver() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("OO"));
    model.startGame();

    model.dropTetromino();
    board.set(new CellPosition(1, 5), 'X');
    model.dropTetromino();

    assertFalse(model.moveTetromino(0, -1));
    assertFalse(model.rotateTetromino());
    assertFalse(model.dropTetromino());
  }

  @Test
  void canPauseAndResumeGame() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));
    model.startGame();

    model.togglePause();
    assertEquals(GameState.PAUSED_GAME, model.getGameState());
    assertFalse(model.moveTetromino(0, -1));

    model.togglePause();
    assertEquals(GameState.ACTIVE_GAME, model.getGameState());
  }

  @Test
  void clockTickMovesTetrominoDownOneRow() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("O"));
    model.startGame();

    model.clockTick();

    assertTrue(toList(model.getCurrentTetromino())
        .contains(new GridCell(new CellPosition(2, 5), 'O')));
    assertTrue(toList(model.getCurrentTetromino())
        .contains(new GridCell(new CellPosition(3, 6), 'O')));
  }

  @Test
  void clockTickLocksTetrominoWhenItCannotMoveFurther() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("OO"));
    model.startGame();

    while (model.moveTetromino(1, 0)) {
      // move piece to resting position
    }

    model.clockTick();

    assertEquals('O', valueAt(model.getTilesOnBoard(), 13, 5));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 13, 6));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 14, 5));
    assertEquals('O', valueAt(model.getTilesOnBoard(), 14, 6));
    assertEquals(4, countTiles(model.getCurrentTetromino()));
  }

  @Test
  void droppingCanClearFilledRow() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("O"));
    model.startGame();
    fillBottomRowWithGap(board);

    boolean changed = model.dropTetromino();

    assertTrue(changed);
    assertEquals(100, model.getScore());
    assertEquals(1, model.getLinesCleared());
    assertEquals(1, model.getLevel());
    for (int col = 0; col < 10; col++) {
      assertEquals('-', valueAt(model.getTilesOnBoard(), 13, col));
    }
    for (int col = 0; col < 10; col++) {
	      Character expected = (col == 5 || col == 6) ? 'O' : '-';
	      assertEquals(expected, valueAt(model.getTilesOnBoard(), 14, col));
    }
  }

  @Test
  void levelAndTimerIncreaseAfterTenClearedRows() {
    TetrisBoard board = new TetrisBoard(15, 10);
    TetrisModel model = new TetrisModel(board, new PatternedTetrominoFactory("OOOOOOOOOOO"));
    model.startGame();

    for (int cleared = 0; cleared < 10; cleared++) {
      fillBottomRowWithGap(board);
      model.dropTetromino();
    }

    assertEquals(10, model.getLinesCleared());
    assertEquals(2, model.getLevel());
    assertEquals(1000, model.getScore());
    assertEquals(900, model.getTimerDelay());
  }

  @Test
  void canRotateTetrominoCounterClockwise() {
    TetrisModel model = new TetrisModel(new PatternedTetrominoFactory("T"));
    model.startGame();

    boolean changed = model.rotateTetrominoCounterClockwise();
    List<GridCell> tiles = toList(model.getCurrentTetromino());

    assertTrue(changed);
    assertTrue(tiles.contains(new GridCell(new CellPosition(0, 5), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(1, 5), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(1, 6), 'T')));
    assertTrue(tiles.contains(new GridCell(new CellPosition(2, 5), 'T')));
  }

  private void fillBottomRowWithGap(TetrisBoard board) {
    board.clearBoard();
    for (int col = 0; col < 10; col++) {
      if (col != 5 && col != 6) {
        board.set(new CellPosition(14, col), 'X');
      }
    }
  }

  private int countTiles(Iterable<GridCell> tiles) {
    int count = 0;
    for (@SuppressWarnings("unused") GridCell tile : tiles) {
      count++;
    }
    return count;
  }

  private List<GridCell> toList(Iterable<GridCell> tiles) {
    List<GridCell> list = new ArrayList<>();
    for (GridCell tile : tiles) {
      list.add(tile);
    }
    return list;
  }

  private Character valueAt(Iterable<GridCell> tiles, int row, int col) {
    for (GridCell tile : tiles) {
      if (tile.pos().equals(new CellPosition(row, col))) {
        return tile.value();
      }
    }
    return null;
  }
}