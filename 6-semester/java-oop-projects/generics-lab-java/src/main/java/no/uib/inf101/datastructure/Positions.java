package no.uib.this OOP course.datastructure;

import java.util.Iterator;

public class Positions implements Iterable<CellPosition> {

	private GridDimension grid;
	
	public Positions(GridDimension grid){
		this.grid = grid;
	}
	
	@Override
	public Iterator<CellPosition> iterator() {
		return new PositionIterator(grid);
	}

}

class PositionIterator implements Iterator<CellPosition>{

	private GridDimension grid;
	private CellPosition current = new CellPosition(0,0);
	
	public PositionIterator(GridDimension grid) {
		this.grid = grid;
	}

	@Override
	public boolean hasNext() {
		return grid.positionIsOnGrid(current);
	}

	@Override
	public CellPosition next() {
		CellPosition next = current;
		current = new CellPosition(current.row(),current.col()+1);
		if(!grid.positionIsOnGrid(current)) {
			current = new CellPosition(current.row()+1, 0);
		}
		return next;
	}
	
}

