package no.uib.this OOP course.sudoku.model;

import no.uib.this OOP course.sudoku.grid.CellPosition;
import no.uib.this OOP course.sudoku.grid.GridDimension;

/**
 * Model for a simple Sudoku game.
 * Keeps track of the selected cell, status text and the board.
 * The model keeps its game state private and stores the validator through
 * {@link ISudokuValidator}.
 */
public class Model {

  public enum GamePhase {
    START_SCREEN,
    PLAYING,
    PAUSED,
    CONTROLS,
    COMPLETED
  }

  private final GridDimension gd = new GridDimension.Record(9, 9);
  private SudokuBoard board;
  private final ISudokuValidator validator;
  private PuzzleLoader.Difficulty difficulty;
  private GamePhase gamePhase = GamePhase.START_SCREEN;
  private CellPosition selectedPosition = null;
  private String statusMessage = "Velg vanskelighetsgrad for å starte.";

  public Model() {
    this.validator = new SudokuValidator();
    this.difficulty = PuzzleLoader.Difficulty.EASY;
  }

  /**
   * Creates a model with selected puzzle difficulty.
   *
   * @param difficulty difficulty to load puzzles from
   */
  public Model(PuzzleLoader.Difficulty difficulty) {
    this.validator = new SudokuValidator();
    this.difficulty = difficulty;
    beginNewGame(difficulty);
  }

  public GamePhase getGamePhase() {
    return this.gamePhase;
  }

  public boolean isStartScreen() {
    return this.gamePhase == GamePhase.START_SCREEN;
  }

  public boolean isPlaying() {
    return this.gamePhase == GamePhase.PLAYING;
  }

  public boolean isPaused() {
    return this.gamePhase == GamePhase.PAUSED;
  }

  public boolean isShowingControls() {
    return this.gamePhase == GamePhase.CONTROLS;
  }

  public boolean isCompleted() {
    return this.gamePhase == GamePhase.COMPLETED;
  }

  public void beginNewGame(PuzzleLoader.Difficulty difficulty) {
    this.difficulty = difficulty;
    this.board = PuzzleLoader.loadPuzzle(difficulty);
    this.gamePhase = GamePhase.PLAYING;
    this.selectedPosition = null;
    this.statusMessage = "Velg en rute og skriv 1-9.";
  }

  public void showStartScreen() {
    this.board = null;
    this.gamePhase = GamePhase.START_SCREEN;
    this.selectedPosition = null;
    this.statusMessage = "Velg vanskelighetsgrad for å starte.";
  }

  public void pauseGame() {
    if (!isPlaying()) {
      return;
    }

    this.gamePhase = GamePhase.PAUSED;
    this.statusMessage = "Spillet er pauset.";
  }

  public void showControlsScreen() {
    if (!isPaused()) {
      return;
    }

    this.gamePhase = GamePhase.CONTROLS;
    this.statusMessage = "Kontroller for Sudoku.";
  }

  public void returnToPauseScreen() {
    if (!isShowingControls()) {
      return;
    }

    this.gamePhase = GamePhase.PAUSED;
    this.statusMessage = "Spillet er pauset.";
  }

  public void resumeGame() {
    if (!isPaused()) {
      return;
    }

    this.gamePhase = GamePhase.PLAYING;
    this.statusMessage = "Velg en rute og skriv 1-9.";
  }

  public void setSelected(CellPosition selectedPosition) {
    if (!isPlaying()) {
      return;
    }

    this.selectedPosition = selectedPosition;
    if (selectedPosition != null) {
      this.statusMessage = "Valgt: rad " + (selectedPosition.row() + 1) + ", kolonne " + (selectedPosition.col() + 1);
    }
  }

  public GridDimension getDimension() {
    return this.gd;
  }

  public CellPosition getSelected() {
    return this.selectedPosition;
  }

  public int getValue(CellPosition pos) {
    if (this.board == null) {
      return 0;
    }
    return this.board.getValue(pos);
  }

  public boolean isFixed(CellPosition pos) {
    if (this.board == null) {
      return false;
    }
    return this.board.isFixed(pos);
  }

  public String getStatusMessage() {
    return this.statusMessage;
  }

  /**
   * Checks whether the current board has been solved.
   *
   * @return true if there are no empty cells left
   */
  public boolean isSolved() {
    return board != null && board.isSolved();
  }

  /**
    * Starts a new round using the current difficulty.
   */
  public void restartGame() {
    if (this.gamePhase == GamePhase.START_SCREEN) {
      return;
    }

    beginNewGame(difficulty);
    statusMessage = "Nytt spill startet. Velg en rute og skriv 1-9.";
  }

  public void clearSelected() {
    if (!isPlaying()) {
      return;
    }

    if (selectedPosition == null) {
      statusMessage = "Velg en rute først.";
      return;
    }

    if (board.isFixed(selectedPosition)) {
      statusMessage = "Du kan ikke slette en låst rute.";
      return;
    }

    board.clear(selectedPosition);
    statusMessage = "Rute tømt.";
  }

  public void setSelectedValue(int value) {
    if (!isPlaying()) {
      return;
    }

    if (selectedPosition == null) {
      statusMessage = "Velg en rute først.";
      return;
    }

    if (board.isFixed(selectedPosition)) {
      statusMessage = "Denne ruten er låst.";
      return;
    }

    if (validator.isMoveValid(board, selectedPosition, value)) {
      board.setValue(selectedPosition, value);
      if (board.isSolved()) {
        gamePhase = GamePhase.COMPLETED;
        selectedPosition = null;
        statusMessage = "Gratulerer, Sudoku er løst!";
      } else {
        statusMessage = "Gyldig trekk.";
      }
    } else {
      statusMessage = "Ugyldig trekk: tallet finnes allerede i rad, kolonne eller boks.";
    }
  }
}