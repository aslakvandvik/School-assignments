package no.uib.oop.datastructure;

import java.util.List;

/**
 * Objects in a class implementing GridCellCollection can assemble a list
 * of GridCell objects through the getCells() method.
 */
public interface GridCellCollection<T> {

  /**
   * Get a list containing the GridCell objects in this collection
   *
   * @return a list of all GridCell objects in this collection
   */
  List<GridCell<T>> getCells();

}
