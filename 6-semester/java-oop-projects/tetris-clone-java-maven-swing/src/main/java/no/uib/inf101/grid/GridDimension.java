package no.uib.this OOP course.grid;

/**
 * Describes the dimensions of a rectangular grid.
 */
public interface GridDimension {

	/** Number of rows in the grid */
	int rows();

	/** Number of columns in the grid */
	int cols();

	/**
	 * Gets an iterable over all positions in the grid.
	 *
	 * @return all valid positions in row-major order
	 */
	default Iterable<CellPosition> positions(){
		return new Positions(this);
	}
	
	/**
	 * Reports whether the position is within bounds for this grid
	 * 
	 * @param pos position to check
	 * @return true if the coordinate is within bounds, false otherwise
	 */
	default boolean positionIsOnGrid(CellPosition pos) {
		if(pos==null)
			return false;
		boolean validRow = pos.row()>=0 && pos.row()<rows();
		boolean validCol = pos.col()>=0 && pos.col()<cols();
		return  validRow && validCol;
	}

}
