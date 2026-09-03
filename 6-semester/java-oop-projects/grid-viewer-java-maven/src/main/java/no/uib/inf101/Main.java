package no.uib.this OOP course;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import no.uib.this OOP course.grid.Grid;
import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.IGrid;
import no.uib.this OOP course.view.GridView;
import no.uib.this OOP course.view.ViewPrinter;

public class Main {

    public static void main(String[] args) {
        // Create a small demo grid and save it to grid.png
        IGrid grid = new Grid(8, 8, '-');
        grid.set(new CellPosition(1, 1), 'r');
        grid.set(new CellPosition(1, 6), 'g');
        grid.set(new CellPosition(5, 1), 'y');
        grid.set(new CellPosition(5, 2), 'b');
        grid.set(new CellPosition(5, 3), 'y');
        grid.set(new CellPosition(5, 4), 'b');
        grid.set(new CellPosition(5, 5), 'b');
        grid.set(new CellPosition(5, 6), 'y');
        GridView view = new GridView(grid);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Grid View");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(view);
            frame.pack();
            frame.setVisible(true);

            ViewPrinter.savePanelAsImage(view, "grid.png");
        });
    }

}
