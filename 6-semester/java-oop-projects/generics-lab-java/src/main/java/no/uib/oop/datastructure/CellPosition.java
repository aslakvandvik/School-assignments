package no.uib.oop.datastructure;

// Les om records her: https://oop.ii.uib.no/notat/mutabilitet/#record

/**
 * A CellPosition consists of a row and a column.
 *
 * @param row  the row of the cell
 * @param col  the column of the cell
 */
public record CellPosition(int row, int col) {}
