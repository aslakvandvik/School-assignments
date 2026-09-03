package no.uib.this OOP course.sudoku.grid;

/**
 * A GridDimension is the dimension of a grid. It has methods for
 * retrieving the number of rows and the number of columns.
 */
public interface GridDimension {

  /** Number of rows in the grid */
  int rows();

  /** Number of columns in the grid */
  int cols();

  record Record(int rows, int cols) implements GridDimension {}
}