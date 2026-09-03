package no.uib.oop.grid;

/**
 * This represents a position on a grid
 */
public record CellPosition(int row, int col) {
	
	public CellPosition(CellPosition pos) {
		this(pos.row,pos.col);
	}
	
}
