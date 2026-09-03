package no.uib.this OOP course.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Testing the class Grid
 */
public class GridTest {

	@Test
	void gridTestGetRowsAndCols() {
		IGrid grid = new Grid(3, 2);
		assertEquals(3, grid.rows());
		assertEquals(2, grid.cols());
	}

	@Test
	void gridSanityTest() {
		char defaultValue = 'x';
		IGrid grid = new Grid(3, 2, defaultValue);

		assertEquals(3, grid.rows());
		assertEquals(2, grid.cols());

		assertEquals('x', grid.get(new CellPosition(0, 0)));
		assertEquals('x', grid.get(new CellPosition(2, 1)));

		grid.set(new CellPosition(1, 1), 'y');

		assertEquals('y', grid.get(new CellPosition(1, 1)));
		assertEquals('x', grid.get(new CellPosition(0, 1)));
		assertEquals('x', grid.get(new CellPosition(1, 0)));
		assertEquals('x', grid.get(new CellPosition(2, 1)));
	}

	@Test
	void gridCanHoldNull() {
		char defaultValue = 'x';
		IGrid grid = new Grid(3, 2, defaultValue);

		assertEquals('x', grid.get(new CellPosition(0, 0)));
		assertEquals('x', grid.get(new CellPosition(2, 1)));

		grid.set(new CellPosition(1, 1), null);

		assertEquals(null, grid.get(new CellPosition(1, 1)));
		assertEquals('x', grid.get(new CellPosition(0, 1)));
		assertEquals('x', grid.get(new CellPosition(1, 0)));
		assertEquals('x', grid.get(new CellPosition(2, 1)));
	}

	@Test
	void gridNullsInDefaultConstructor() {
		IGrid grid = new Grid(3, 2);

		assertEquals(null, grid.get(new CellPosition(0, 0)));
		assertEquals(null, grid.get(new CellPosition(2, 1)));

		grid.set(new CellPosition(1, 1), 'y');

		assertEquals('y', grid.get(new CellPosition(1, 1)));
		assertEquals(null, grid.get(new CellPosition(0, 1)));
		assertEquals(null, grid.get(new CellPosition(1, 0)));
		assertEquals(null, grid.get(new CellPosition(2, 1)));
	}

	@Test
	void GridConstructorTest() {
		assertThrows(IllegalArgumentException.class, ()-> {new Grid(3,-1);},"Can not have negative number of cols");
		assertThrows(IllegalArgumentException.class, ()-> {new Grid(-1,3);},"Can not have negative number of rows");
	}
	
	@Test
	void coordinateIsOnGridTest() {
		IGrid grid = new Grid(3, 2, 'z');

		assertTrue(grid.positionIsOnGrid(new CellPosition(2, 1)));
		assertFalse(grid.positionIsOnGrid(new CellPosition(3, 1)));
		assertFalse(grid.positionIsOnGrid(new CellPosition(2, 2)));

		assertTrue(grid.positionIsOnGrid(new CellPosition(0, 0)));
		assertFalse(grid.positionIsOnGrid(new CellPosition(-1, 0)));
		assertFalse(grid.positionIsOnGrid(new CellPosition(0, -1)));

		assertFalse(grid.positionIsOnGrid(null));
}

	@Test
	void throwsExceptionWhenGetCoordinateOffGrid() {
		IGrid grid = new Grid(3, 2, 'x');

		try {
			@SuppressWarnings("unused")
			Character x = grid.get(new CellPosition(3, 1));
			fail("No Exception was thrown when calling get() on position outside the grid.");
		} catch (IndexOutOfBoundsException e) {
			// Test passed
		}
	}
	
	@Test 
	void throwsExceptionOnNullInput(){
		IGrid grid = new Grid(3, 2, 'x');
		assertThrows(IllegalArgumentException.class, ()->{grid.get(null);},"null input to get() method should throw IllegalArgumentException");
		assertThrows(IllegalArgumentException.class, ()->{grid.set(null,'r');},"null input to set() method should throw IllegalArgumentException");
	}

	@Test
	void throwsExceptionWhenSetCoordinateOffGrid() {
		IGrid grid = new Grid(3, 2, 'x');

		try {
			grid.set(new CellPosition(2, 2), 'y');
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Test passed
		}
	}

	@Test
	void testIterator() {
		IGrid grid = new Grid(3, 2, 'x');
		grid.set(new CellPosition(0, 0), 'a');
		grid.set(new CellPosition(1, 1), 'b');
		grid.set(new CellPosition(2, 1), 'c');

		List<GridCell> items = new ArrayList<>();
		for (GridCell coordinateItem : grid) {
			items.add(coordinateItem);
		}

		assertEquals(3 * 2, items.size());
		assertTrue(items.contains(new GridCell(new CellPosition(0, 0), 'a')));
		assertTrue(items.contains(new GridCell(new CellPosition(1, 1), 'b')));
		assertTrue(items.contains(new GridCell(new CellPosition(2, 1), 'c')));
		assertTrue(items.contains(new GridCell(new CellPosition(0, 1), 'x')));
	}
	
}
