package no.uib.this OOP course.grid;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a simple 2D grid of Characters.
 */
public class Grid implements IGrid {

	private final int rows;
	private final int cols;
	private final Character[][] data;

	public Grid(int rows, int cols) {
		this(rows, cols, null);
	}

	public Grid(int rows, int cols, Character defaultValue) {
		if (rows < 0 || cols < 0) {
			throw new IllegalArgumentException("Can not have negative number of rows or cols");
		}
		this.rows = rows;
		this.cols = cols;
		data = new Character[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				data[r][c] = defaultValue;
			}
		}
	}

	@Override
	public int rows() {
		return rows;
	}

	@Override
	public int cols() {
		return cols;
	}

	private void requireNonNullPosition(CellPosition pos) {
		if (pos == null) {
			throw new IllegalArgumentException("Position is null");
		}
	}

	private void checkBounds(CellPosition pos) {
		if (pos.row() < 0 || pos.col() < 0 || pos.row() >= rows || pos.col() >= cols) {
			throw new IndexOutOfBoundsException("Position outside grid");
		}
	}

	@Override
	public void set(CellPosition pos, Character symbol) {
		requireNonNullPosition(pos);
		checkBounds(pos);
		data[pos.row()][pos.col()] = symbol;
	}

	@Override
	public Character get(CellPosition pos) {
		requireNonNullPosition(pos);
		checkBounds(pos);
		return data[pos.row()][pos.col()];
	}

	@Override
	public boolean positionIsOnGrid(CellPosition pos) {
		if (pos == null)
			return false;
		return pos.row() >= 0 && pos.col() >= 0 && pos.row() < rows && pos.col() < cols;
	}

	@Override
	public Iterator<GridCell> iterator() {
		return new Iterator<GridCell>() {
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < rows * cols;
			}

			@Override
			public GridCell next() {
				if (!hasNext())
					throw new NoSuchElementException();
				int r = index / cols;
				int c = index % cols;
				index++;
				return new GridCell(new CellPosition(r, c), data[r][c]);
			}
		};
	}

}
