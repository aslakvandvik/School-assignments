package no.uib.this OOP course.grid;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing the class GridCell
 */
public class GridCellTest {

	@Test
	void sanityTest() {
		char item = 'x';
		CellPosition pos = new CellPosition(4, 2);
		GridCell gridCell = new GridCell(pos, item);

		assertEquals(pos, gridCell.pos());
		assertEquals(item, gridCell.symbol());
	}

	@Test
	void gridCellEqualityAndHashCodeTest() {
		char item1 = 'x';
		CellPosition pos1 = new CellPosition(4, 2);
		GridCell gridCell1 = new GridCell(pos1, item1);

		char item2 = 'x';
		CellPosition pos2 = new CellPosition(4, 2);
		GridCell gridCell2 = new GridCell(pos2, item2);

		assertTrue(gridCell2.equals(gridCell1));
		assertTrue(gridCell1.equals(gridCell2));
		assertTrue(Objects.equals(gridCell1, gridCell2));
		assertTrue(gridCell1.hashCode() == gridCell2.hashCode());
	}

	@Test
	void gridCellInequalityTest() {
		char item1 = 'x';
		CellPosition pos1 = new CellPosition(4, 2);
		GridCell gridCell1 = new GridCell(pos1, item1);

		char item2 = 'y';
		CellPosition pos2 = new CellPosition(2, 4);

		GridCell gridCell2 = new GridCell(pos2, item1);
		GridCell gridCell3 = new GridCell(pos1, item2);

		assertFalse(gridCell2.equals(gridCell1));
		assertFalse(gridCell1.equals(gridCell2));
		assertFalse(gridCell1.equals(gridCell3));
		assertFalse(gridCell2.equals(gridCell3));
		assertFalse(Objects.equals(gridCell1, gridCell2));
		assertFalse(Objects.equals(gridCell1, gridCell3));
		assertFalse(Objects.equals(gridCell2, gridCell3));
	}
	
}
