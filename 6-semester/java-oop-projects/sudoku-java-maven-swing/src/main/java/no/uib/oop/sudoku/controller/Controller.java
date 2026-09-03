package no.uib.oop.sudoku.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import no.uib.oop.sudoku.grid.CellPosition;
import no.uib.oop.sudoku.grid.CellPositionToPixelConverter;
import no.uib.oop.sudoku.model.Model;
import no.uib.oop.sudoku.model.PuzzleLoader;
import no.uib.oop.sudoku.view.View;
import javax.swing.Timer;

/**
 * Controller connecting user input (mouse + keyboard) to the Sudoku model.
 * This class uses inheritance by extending {@link MouseAdapter}, which lets it
 * override only the mouse callbacks it needs.
 */
public class Controller extends MouseAdapter {

  private final Model model;
  private final View view;

  public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
    this.view.addMouseListener(this);
    this.view.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent event) {
        handleKeyPressed(event);
      }
    });
    this.view.setFocusable(true);
  }

  @Override
  public void mousePressed(MouseEvent event) {
    Point2D mouseCoordinate = event.getPoint();

    if (model.isStartScreen()) {
      handleStartScreenClick(mouseCoordinate);
      return;
    }

    if (model.isCompleted()) {
      Rectangle2D restartButton = view.getRestartButtonBounds();
      if (restartButton.contains(mouseCoordinate)) {
        model.showStartScreen();
        view.requestFocusInWindow();
        view.repaint();
      }
      return;
    }

    if (model.isPaused()) {
      if (view.getResumeButtonBounds().contains(mouseCoordinate)) {
        model.resumeGame();
        view.requestFocusInWindow();
        view.repaint();
        return;
      }

      if (view.getPauseDifficultyButtonBounds().contains(mouseCoordinate)) {
        model.showStartScreen();
        view.requestFocusInWindow();
        view.repaint();
        return;
      }

      if (view.getControlsButtonBounds().contains(mouseCoordinate)) {
        model.showControlsScreen();
        view.requestFocusInWindow();
        view.repaint();
      }
      return;
    }

    if (model.isShowingControls()) {
      if (view.getBackToPauseButtonBounds().contains(mouseCoordinate)) {
        model.returnToPauseScreen();
        view.requestFocusInWindow();
        view.repaint();
      }
      return;
    }

    if (model.isPlaying() && view.getPauseButtonBounds().contains(mouseCoordinate)) {
      model.pauseGame();
      view.repaint();
      return;
    }

    CellPositionToPixelConverter converter = this.view.getCellPositionToPixelConverter();
    CellPosition pos = converter.getCellPositionOfPoint(mouseCoordinate);
    this.model.setSelected(pos);
    this.view.requestFocusInWindow();
    this.view.repaint();
  }

  private void handleStartScreenClick(Point2D mouseCoordinate) {
    for (PuzzleLoader.Difficulty difficulty : PuzzleLoader.Difficulty.values()) {
      if (view.getDifficultyButtonBounds(difficulty).contains(mouseCoordinate)) {
        view.setPressedDifficulty(difficulty);
        Timer timer = new Timer(120, event -> {
          model.beginNewGame(difficulty);
          view.clearPressedDifficulty();
          view.requestFocusInWindow();
          view.repaint();
        });
        timer.setRepeats(false);
        timer.start();
        return;
      }
    }
  }

  private void handleKeyPressed(KeyEvent event) {
    int code = event.getKeyCode();

    if (code == KeyEvent.VK_N) {
      if (model.isCompleted()) {
        model.showStartScreen();
      } else if (model.isShowingControls()) {
        model.returnToPauseScreen();
      } else {
        this.model.restartGame();
      }
      this.view.repaint();
      return;
    }

    if (!model.isPlaying()) {
      return;
    }

    if (code >= KeyEvent.VK_1 && code <= KeyEvent.VK_9) {
      int value = code - KeyEvent.VK_0;
      this.model.setSelectedValue(value);
      this.view.repaint();
      return;
    }

    if (code == KeyEvent.VK_BACK_SPACE || code == KeyEvent.VK_DELETE || code == KeyEvent.VK_0) {
      this.model.clearSelected();
      this.view.repaint();
    }
  }
}