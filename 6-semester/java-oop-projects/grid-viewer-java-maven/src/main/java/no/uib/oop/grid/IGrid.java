package no.uib.oop.grid;

public interface IGrid extends GridDimension, Iterable<GridCell> {

	/**
	 * Sets the value of a position in the grid. A subsequent call to {@link #get}
	 * with an equal position as argument will return the value which was set. The
	 * method will overwrite any previous value that was stored at the location.
	 * 
	 * @param pos   the position in which to store the value
	 * @param symbol the new value
	 * @throws IndexOutOfBoundsException if the position does not exist in the grid
	 */
	public void set(CellPosition pos, Character symbol);

	/**
	 * Gets the current value at the given coordinate.
	 * 
	 * @param pos the position to get
	 * @return the value stored at the position
	 * @throws IndexOutOfBoundsException if the position does not exist in the grid
	 */
	public Character get(CellPosition pos);

	/**
	 * Reports whether the position is within bounds for this grid
	 * 
	 * @param pos position to check
	 * @return true if the coordinate is within bounds, false otherwise
	 */
	public boolean positionIsOnGrid(CellPosition pos);

}
