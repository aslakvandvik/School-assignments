package no.uib.this OOP course.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GridCellTest {

	@Test
	public void sanityTest() {
	    GridCell<Integer> integerCell = new GridCell<Integer>(new CellPosition(5, 2), 40);
	    assertEquals(40, integerCell.elem(), "element is null or not equal");
	    CellPosition expectedPosition = new CellPosition(5, 2);
	    assertEquals(expectedPosition, integerCell.pos(), "position is null or not equal");
	}

}
