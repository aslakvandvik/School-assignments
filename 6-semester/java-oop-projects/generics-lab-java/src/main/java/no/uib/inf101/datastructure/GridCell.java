package no.uib.this OOP course.datastructure;

// Les om records her: https://this OOP course.ii.uib.no/notat/mutabilitet/#record

/**
 * A GridCell contains a CellPosition and an element of type T.
 *
 * @param pos  the position of the cell
 * @param elem the element of the cell
 */
public record GridCell<T>(CellPosition pos, T elem) { }
