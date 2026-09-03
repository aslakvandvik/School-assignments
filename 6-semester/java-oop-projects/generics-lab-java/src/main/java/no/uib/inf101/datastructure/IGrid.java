package no.uib.this OOP course.datastructure;

public interface IGrid<T> extends GridDimension, GridCellCollection<T> {

  /**
   * Get the element of the cell at the given position.
   *
   * @param pos the position
   * @return the element of the cell
   * @throws IndexOutOfBoundsException if the position is out of bounds
   */
  T get(CellPosition pos);

  /**
   * Set the element of the cell at the given position.
   *
   * @param pos  the position
   * @param elem the new element
   * @throws IndexOutOfBoundsException if the position is out of bounds
   */
  void set(CellPosition pos, T elem);

}
