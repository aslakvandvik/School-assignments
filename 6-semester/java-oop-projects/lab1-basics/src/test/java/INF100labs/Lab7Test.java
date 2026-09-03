package INF100labs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;


public class Lab7Test {
	
	// ############ removeRow ############
	@Test
	void removeRow1() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
        grid.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
        grid.add(new ArrayList<>(Arrays.asList(31, 32, 33)));

        Lab7.removeRow(grid, 2);

        ArrayList<ArrayList<Integer>> expectedGrid = new ArrayList<>();
        expectedGrid.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
        expectedGrid.add(new ArrayList<>(Arrays.asList(21, 22, 23)));

        assertEquals(expectedGrid, grid);
    }

    @Test
	void removeRow2() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
        grid.add(new ArrayList<>(Arrays.asList(21, 22, 23)));
        grid.add(new ArrayList<>(Arrays.asList(31, 32, 33)));
        Lab7.removeRow(grid, 1);

        ArrayList<ArrayList<Integer>> expectedGrid = new ArrayList<>();
        expectedGrid.add(new ArrayList<>(Arrays.asList(11, 12, 13)));
        expectedGrid.add(new ArrayList<>(Arrays.asList(31, 32, 33)));

        assertEquals(expectedGrid, grid);
    }

    // ############ allRowsAndColsAreEqualSum ############
    @Test
	void allRowsAndColsAreEqualSum1() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(3, 0, 9)));
        grid.add(new ArrayList<>(Arrays.asList(4, 5, 3)));
        grid.add(new ArrayList<>(Arrays.asList(6, 8, 1)));

        assertFalse(Lab7.allRowsAndColsAreEqualSum(grid));
    }

    @Test
	void allRowsAndColsAreEqualSum2() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
        grid.add(new ArrayList<>(Arrays.asList(0, 5, 8)));
        grid.add(new ArrayList<>(Arrays.asList(9, 3, 1)));
        
        assertFalse(Lab7.allRowsAndColsAreEqualSum(grid));
    }

    @Test
	void allRowsAndColsAreEqualSum3() {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        grid.add(new ArrayList<>(Arrays.asList(2, 3, 4, 1)));
        grid.add(new ArrayList<>(Arrays.asList(3, 4, 1, 2)));
        grid.add(new ArrayList<>(Arrays.asList(4, 1, 2, 3)));
        
        assertTrue(Lab7.allRowsAndColsAreEqualSum(grid));
    }
}
