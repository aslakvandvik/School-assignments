package no.uib.this OOP course.tetris.model;

import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.GridCell;
import no.uib.this OOP course.grid.GridDimension;
import no.uib.this OOP course.tetris.controller.ControllableTetrisModel;
import no.uib.this OOP course.tetris.model.tetromino.RandomTetrominoFactory;
import no.uib.this OOP course.tetris.model.tetromino.Tetromino;
import no.uib.this OOP course.tetris.model.tetromino.TetrominoFactory;
import no.uib.this OOP course.tetris.view.ViewableTetrisModel;

/**
 * Tetris model implementation backing the view and controller.
 */
public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel {

	private static final int BASE_TIMER_DELAY = 1000;
	private static final int TIMER_DELAY_DECREASE_PER_LEVEL = 100;
	private static final int MIN_TIMER_DELAY = 200;

	private final TetrisBoard board;
	private final TetrominoFactory tetrominoFactory;
	private Tetromino fallingTetromino;
	private GameState gameState;
	private int score;
	private int totalRowsCleared;

	/**
	 * Creates a new Tetris model with an empty board and one falling piece.
	 */
	public TetrisModel() {
		this(new RandomTetrominoFactory());
	}

	/**
	 * Creates a new Tetris model with the given tetromino factory.
	 *
	 * @param tetrominoFactory factory for new tetrominoes
	 */
	public TetrisModel(TetrominoFactory tetrominoFactory) {
		this(new TetrisBoard(15, 10), tetrominoFactory);
	}

	/**
	 * Creates a new Tetris model with the given board and tetromino factory.
	 *
	 * @param board the board used by the model
	 * @param tetrominoFactory factory for new tetrominoes
	 */
	public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory) {
		this.board = board;
		this.tetrominoFactory = tetrominoFactory;
		this.prepareNewGame();
		this.gameState = GameState.WELCOME_SCREEN;
	}

	@Override
	public GridDimension getDimension() {
		return this.board;
	}

	@Override
	public Iterable<GridCell> getTilesOnBoard() {
		return this.board;
	}

	@Override
	public Iterable<GridCell> getCurrentTetromino() {
		return this.fallingTetromino;
	}

	@Override
	public int getScore() {
		return this.score;
	}

	@Override
	public int getLevel() {
		return 1 + this.totalRowsCleared / 10;
	}

	@Override
	public int getLinesCleared() {
		return this.totalRowsCleared;
	}

	@Override
	public GameState getGameState() {
		return this.gameState;
	}

	@Override
	public int getTimerDelay() {
		return Math.max(
				MIN_TIMER_DELAY,
				BASE_TIMER_DELAY - (this.getLevel() - 1) * TIMER_DELAY_DECREASE_PER_LEVEL);
	}

	@Override
	public boolean moveTetromino(int deltaRow, int deltaCol) {
		if (this.gameState != GameState.ACTIVE_GAME) {
			return false;
		}
		Tetromino movedTetromino = this.fallingTetromino.shiftedBy(
				deltaRow,
				deltaCol);
		if (this.tetrominoIsValid(movedTetromino)) {
			this.fallingTetromino = movedTetromino;
			return true;
		}
		return false;
	}

	@Override
	public boolean rotateTetromino() {
		if (this.gameState != GameState.ACTIVE_GAME) {
			return false;
		}
		Tetromino rotatedTetromino = this.fallingTetromino.rotated();
		if (this.tetrominoIsValid(rotatedTetromino)) {
			this.fallingTetromino = rotatedTetromino;
			return true;
		}
		return false;
	}

	@Override
	public boolean rotateTetrominoCounterClockwise() {
		if (this.gameState != GameState.ACTIVE_GAME) {
			return false;
		}
		Tetromino rotatedTetromino = this.fallingTetromino.rotatedCounterClockwise();
		if (this.tetrominoIsValid(rotatedTetromino)) {
			this.fallingTetromino = rotatedTetromino;
			return true;
		}
		return false;
	}

	@Override
	public boolean dropTetromino() {
		if (this.gameState != GameState.ACTIVE_GAME) {
			return false;
		}
		while (this.moveTetromino(1, 0)) {
			// keep moving down while possible
		}
		this.placeTetromino();
		this.spawnNewTetromino();
		return true;
	}

	@Override
	public void clockTick() {
		if (this.gameState != GameState.ACTIVE_GAME) {
			return;
		}
		boolean moved = this.moveTetromino(1, 0);
		if (!moved) {
			this.placeTetromino();
			this.spawnNewTetromino();
		}
	}

	@Override
	public void startGame() {
		this.prepareNewGame();
		this.gameState = GameState.ACTIVE_GAME;
	}

	@Override
	public void returnToWelcomeScreen() {
		this.prepareNewGame();
		this.gameState = GameState.WELCOME_SCREEN;
	}

	@Override
	public void togglePause() {
		if (this.gameState == GameState.ACTIVE_GAME) {
			this.gameState = GameState.PAUSED_GAME;
		} else if (this.gameState == GameState.PAUSED_GAME) {
			this.gameState = GameState.ACTIVE_GAME;
		}
	}

	private boolean tetrominoIsValid(Tetromino tetromino) {
		for (GridCell cell : tetromino) {
			CellPosition pos = cell.pos();
			if (!this.board.positionIsOnGrid(pos)) {
				return false;
			}
			if (this.board.get(pos) != TetrisBoard.EMPTY) {
				return false;
			}
		}
		return true;
	}

	private void spawnNewTetromino() {
		this.fallingTetromino = this.tetrominoFactory.getNext()
				.shiftedToTopCenterOf(this.board);
		if (!this.tetrominoIsValid(this.fallingTetromino)) {
			this.gameState = GameState.GAME_OVER;
		}
	}

	private void placeTetromino() {
		this.board.addTetromino(this.fallingTetromino);
		this.updateScoreAndLevel(this.board.clearRows());
	}

	private void prepareNewGame() {
		this.board.clearBoard();
		this.score = 0;
		this.totalRowsCleared = 0;
		this.gameState = GameState.ACTIVE_GAME;
		this.spawnNewTetromino();
	}

	private void updateScoreAndLevel(int clearedRows) {
		if (clearedRows <= 0) {
			return;
		}
		int currentLevel = this.getLevel();
		this.totalRowsCleared += clearedRows;
		this.score += this.pointsForClearedRows(clearedRows) * currentLevel;
	}

	private int pointsForClearedRows(int clearedRows) {
		return switch (clearedRows) {
			case 1 -> 100;
			case 2 -> 300;
			case 3 -> 500;
			case 4 -> 800;
			default -> 0;
		};
	}

}
