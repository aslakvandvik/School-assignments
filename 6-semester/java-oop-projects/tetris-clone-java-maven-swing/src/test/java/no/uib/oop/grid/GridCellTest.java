package no.uib.oop.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.Test;

/**
 * Testing the class GridCell
 */
public class GridCellTest {

  @Test
  void sanityTest() {
    Character item = 'C';
    CellPosition pos = new CellPosition(4, 2);
    GridCell gridCell = new GridCell(pos, item);

    assertEquals(pos, gridCell.pos());
    assertEquals(item, gridCell.value());
  }

  @Test
  void gridCellEqualityAndHashCodeTest() {
	  Character item = 'C';
    CellPosition pos = new CellPosition(4, 2);
    GridCell gridCell = new GridCell(pos, item);

    Character item2 = 'C';
    CellPosition pos2 = new CellPosition(4, 2);
    GridCell gridCell2 = new GridCell(pos2, item2);

    assertTrue(gridCell2.equals(gridCell));
    assertTrue(gridCell.equals(gridCell2));
    assertTrue(Objects.equals(gridCell, gridCell2));
    assertTrue(gridCell.hashCode() == gridCell2.hashCode());
  }

  @Test
  void gridCellInequalityTest() {
	Character item = 'C';
    CellPosition pos = new CellPosition(4, 2);
    GridCell gridCell = new GridCell(pos, item);

    Character item2 = 'D';
    CellPosition pos2 = new CellPosition(2, 4);

    GridCell gridCell2 = new GridCell(pos2, item);
    GridCell gridCell3 = new GridCell(pos, item2);

    assertFalse(gridCell2.equals(gridCell));
    assertFalse(gridCell.equals(gridCell2));
    assertFalse(gridCell.equals(gridCell3));
    assertFalse(gridCell2.equals(gridCell3));
    assertFalse(Objects.equals(gridCell, gridCell2));
    assertFalse(Objects.equals(gridCell, gridCell3));
    assertFalse(Objects.equals(gridCell2, gridCell3));
  }
}
