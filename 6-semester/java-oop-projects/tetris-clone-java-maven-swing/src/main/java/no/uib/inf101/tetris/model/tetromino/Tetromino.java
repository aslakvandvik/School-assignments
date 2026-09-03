package no.uib.this OOP course.tetris.model.tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import no.uib.this OOP course.grid.CellPosition;
import no.uib.this OOP course.grid.GridCell;
import no.uib.this OOP course.grid.GridDimension;

/**
 * Represents a tetromino with symbol, shape, and position.
 */
public class Tetromino implements Iterable<GridCell> {

  private final char symbol;
  private final boolean[][] shape;
  private final CellPosition pos;

  private Tetromino(char symbol, boolean[][] shape, CellPosition pos) {
    this.symbol = symbol;
    this.shape = copyShape(shape);
    this.pos = pos;
  }

  /**
   * Creates a tetromino of the given symbol at position (0, 0).
   *
   * @param symbol the tetromino symbol
   * @return a tetromino of the requested type
   */
  public static Tetromino newTetromino(char symbol) {
    return switch (symbol) {
      case 'L' -> new Tetromino('L', new boolean[][] {
          {false, false, false},
          {true, true, true},
          {true, false, false}
      }, new CellPosition(0, 0));
      case 'J' -> new Tetromino('J', new boolean[][] {
          {false, false, false},
          {true, true, true},
          {false, false, true}
      }, new CellPosition(0, 0));
      case 'S' -> new Tetromino('S', new boolean[][] {
          {false, false, false},
          {false, true, true},
          {true, true, false}
      }, new CellPosition(0, 0));
      case 'Z' -> new Tetromino('Z', new boolean[][] {
          {false, false, false},
          {true, true, false},
          {false, true, true}
      }, new CellPosition(0, 0));
      case 'T' -> new Tetromino('T', new boolean[][] {
          {false, false, false},
          {true, true, true},
          {false, true, false}
      }, new CellPosition(0, 0));
      case 'I' -> new Tetromino('I', new boolean[][] {
          {false, false, false, false},
          {true, true, true, true},
          {false, false, false, false},
          {false, false, false, false}
      }, new CellPosition(0, 0));
      case 'O' -> new Tetromino('O', new boolean[][] {
          {false, false, false},
          {false, true, true},
          {false, true, true}
      }, new CellPosition(0, 0));
      default -> throw new IllegalArgumentException("Unknown tetromino: " + symbol);
    };
  }

  /**
   * Creates a moved copy of this tetromino.
   *
   * @param deltaRow number of rows to move
   * @param deltaCol number of columns to move
   * @return a shifted tetromino
   */
  public Tetromino shiftedBy(int deltaRow, int deltaCol) {
    CellPosition newPos = new CellPosition(
        this.pos.row() + deltaRow,
        this.pos.col() + deltaCol);
    return new Tetromino(this.symbol, this.shape, newPos);
  }

  /**
   * Creates a copy centered at the top of the given grid.
   *
   * @param grid the grid to place the tetromino in
   * @return a top-centered tetromino
   */
  public Tetromino shiftedToTopCenterOf(GridDimension grid) {
    int centeredCol = grid.cols() / 2 - this.shape.length / 2;
    return new Tetromino(this.symbol, this.shape, new CellPosition(0, centeredCol));
  }

  /**
   * Creates a rotated copy of this tetromino.
   *
   * @return a clockwise rotated tetromino
   */
  public Tetromino rotated() {
    if (this.symbol == 'O') {
      return this;
    }
    boolean[][] rotatedShape = new boolean[this.shape.length][this.shape.length];
    for (int row = 0; row < rotatedShape.length; row++) {
      for (int col = 0; col < rotatedShape[row].length; col++) {
        int oldRow = this.shape.length - 1 - col;
        int oldCol = row;
        rotatedShape[row][col] = this.shape[oldRow][oldCol];
      }
    }
    return new Tetromino(this.symbol, rotatedShape, this.pos);
  }

  /**
   * Creates a counter-clockwise rotated copy of this tetromino.
   *
   * @return a counter-clockwise rotated tetromino
   */
  public Tetromino rotatedCounterClockwise() {
    if (this.symbol == 'O') {
      return this;
    }
    return this.rotated().rotated().rotated();
  }

  @Override
  public Iterator<GridCell> iterator() {
    List<GridCell> cells = new ArrayList<>();
    for (int row = 0; row < this.shape.length; row++) {
      for (int col = 0; col < this.shape[row].length; col++) {
        if (this.shape[row][col]) {
          CellPosition cellPos = new CellPosition(
              this.pos.row() + row,
              this.pos.col() + col);
          cells.add(new GridCell(cellPos, this.symbol));
        }
      }
    }
    return cells.iterator();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Tetromino other)) {
      return false;
    }
    return this.symbol == other.symbol
        && Objects.equals(this.pos, other.pos)
        && Arrays.deepEquals(this.shape, other.shape);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.symbol, this.pos, Arrays.deepHashCode(this.shape));
  }

  private static boolean[][] copyShape(boolean[][] shape) {
    boolean[][] copy = new boolean[shape.length][];
    for (int row = 0; row < shape.length; row++) {
      copy[row] = Arrays.copyOf(shape[row], shape[row].length);
    }
    return copy;
  }
}