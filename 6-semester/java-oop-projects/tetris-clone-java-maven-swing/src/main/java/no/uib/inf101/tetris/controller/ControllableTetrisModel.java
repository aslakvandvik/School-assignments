package no.uib.this OOP course.tetris.controller;

import no.uib.this OOP course.tetris.model.GameState;

/**
 * Interface exposing the minimal control operations the controller needs from the model.
 */
public interface ControllableTetrisModel {

	/**
	 * Gets the delay between timer ticks in milliseconds.
	 *
	 * @return the timer delay in milliseconds
	 */
	int getTimerDelay();

	/**
	 * Attempt to move the currently falling tetromino by the given row/col delta.
	 *
	 * @param deltaRow rows to move (positive = down)
	 * @param deltaCol columns to move (positive = right)
	 * @return true if the move was applied, false otherwise
	 */
	boolean moveTetromino(int deltaRow, int deltaCol);

	/**
	 * Attempts to rotate the current tetromino.
	 *
	 * @return true if the rotation was applied, false otherwise
	 */
	boolean rotateTetromino();

	/**
	 * Attempts to rotate the current tetromino counter-clockwise.
	 *
	 * @return true if the rotation was applied, false otherwise
	 */
	boolean rotateTetrominoCounterClockwise();

	/**
	 * Drops the current tetromino to its final position.
	 *
	 * @return true if the game state changed visually, false otherwise
	 */
	boolean dropTetromino();

	/**
	 * Handles one clock tick from the timer.
	 */
	void clockTick();

	/**
	 * Starts a new active game.
	 */
	void startGame();

	/**
	 * Returns to the welcome screen.
	 */
	void returnToWelcomeScreen();

	/**
	 * Toggles pause state.
	 */
	void togglePause();

	/**
	 * Gets the current game state.
	 *
	 * @return the current game state
	 */
	GameState getGameState();

}
