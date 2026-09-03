package no.uib.this OOP course.sudoku;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import no.uib.this OOP course.sudoku.controller.Controller;
import no.uib.this OOP course.sudoku.model.Model;
import no.uib.this OOP course.sudoku.view.View;

/**
 * Main class showing the Sudoku game.
 */
public class Main {
  public static void main(String[] args) {
    Model model = new Model();
    View view = new View(model);
    new Controller(model, view);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("this OOP course Sudoku");
    frame.setLayout(new BorderLayout());
    frame.add(view, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    view.requestFocusInWindow();
  }
}
