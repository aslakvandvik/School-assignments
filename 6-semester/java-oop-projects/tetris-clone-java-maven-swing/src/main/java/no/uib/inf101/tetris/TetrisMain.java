package no.uib.this OOP course.tetris;

import javax.swing.JFrame;

import no.uib.this OOP course.tetris.controller.TetrisController;
import no.uib.this OOP course.tetris.model.TetrisModel;
import no.uib.this OOP course.tetris.model.tetromino.RandomTetrominoFactory;
import no.uib.this OOP course.tetris.model.tetromino.TetrominoFactory;
import no.uib.this OOP course.tetris.view.TetrisView;

/**
 * Starts the Tetris application.
 */
public class TetrisMain {

  public static final String WINDOW_TITLE = "this OOP course Tetris";

  /**
   * Creates and shows the main game window.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    TetrominoFactory tetrominoFactory = new RandomTetrominoFactory();
    TetrisModel model = new TetrisModel(tetrominoFactory);
    TetrisView view = new TetrisView(model);
    new TetrisController(model, view);

    JFrame frame = new JFrame(WINDOW_TITLE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setContentPane(view);

    frame.pack();
    frame.setVisible(true);
    view.requestFocusInWindow();
  }

}
