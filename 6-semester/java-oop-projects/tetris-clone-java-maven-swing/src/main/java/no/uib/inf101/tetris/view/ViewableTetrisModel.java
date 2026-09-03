package no.uib.this OOP course.tetris.view;

import no.uib.this OOP course.grid.GridCell;
import no.uib.this OOP course.grid.GridDimension;
import no.uib.this OOP course.tetris.model.GameState;

/**
 * Read-only interface for views to observe the Tetris model.
 */
public interface ViewableTetrisModel {

    /**
     * Gets the board dimensions.
     *
     * @return the dimensions of the board
     */
    GridDimension getDimension();

    /**
     * Gets all cells currently stored on the board.
     *
     * @return an iterable over the board cells
     */
    Iterable<GridCell> getTilesOnBoard();

    /**
     * Gets the currently falling tetromino.
     *
     * @return an iterable over the tetromino cells
     */
    Iterable<GridCell> getCurrentTetromino();

    /**
     * Gets the current score.
     *
     * @return the score
     */
    int getScore();

    /**
     * Gets the current level.
     *
     * @return the level
     */
    int getLevel();

    /**
     * Gets the total number of cleared lines.
     *
     * @return cleared line count
     */
    int getLinesCleared();

    /**
     * Gets the current game state.
     *
     * @return the game state
     */
    GameState getGameState();

}
