package INF100labs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the methods removeRow and allRowsAndColsAreEqualSum.
 * These programming tasks was part of lab7 in INF100 fall 2022/2023. You can find
 * them here: https://inf100h22.stromme.me/lab/7/
 */
public class Lab7 {

    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
        grid1.add(new ArrayList<>(Arrays.asList(3, 0, 9)));
        grid1.add(new ArrayList<>(Arrays.asList(4, 5, 3)));
        grid1.add(new ArrayList<>(Arrays.asList(6, 8, 1)));

        boolean equalSums1 = allRowsAndColsAreEqualSum(grid1);
        System.out.println(equalSums1); // false


        ArrayList<ArrayList<Integer>> grid2 = new ArrayList<>();
        grid2.add(new ArrayList<>(Arrays.asList(3, 4, 6)));
        grid2.add(new ArrayList<>(Arrays.asList(0, 5, 8)));
        grid2.add(new ArrayList<>(Arrays.asList(9, 3, 1)));

        boolean equalSums2 = allRowsAndColsAreEqualSum(grid2);
        System.out.println(equalSums2); // false

        ArrayList<ArrayList<Integer>> grid3 = new ArrayList<>();
        grid3.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        grid3.add(new ArrayList<>(Arrays.asList(2, 3, 4, 1)));
        grid3.add(new ArrayList<>(Arrays.asList(3, 4, 1, 2)));
        grid3.add(new ArrayList<>(Arrays.asList(4, 1, 2, 3)));

        boolean equalSums3 = allRowsAndColsAreEqualSum(grid3);
        System.out.println(equalSums3); // true
    }

    public static void removeRow(ArrayList<ArrayList<Integer>> grid, int row) {
        grid.remove(row);
    }

    public static boolean allRowsAndColsAreEqualSum(ArrayList<ArrayList<Integer>> grid) {
        int n = grid.size();

        // Sjekk radsummer
        int rowSum = 0;
        for (int j = 0; j < grid.get(0).size(); j++) {
            rowSum += grid.get(0).get(j);
        }

        for (int i = 1; i < n; i++) {
            int currentRowSum = 0;
            for (int j = 0; j < grid.get(i).size(); j++) {
                currentRowSum += grid.get(i).get(j);
            }
            if (currentRowSum != rowSum) {
                return false;
            }
        }

        // Sjekk kolonnesummer
        int colSum = 0;
        for (int i = 0; i < n; i++) {
            colSum += grid.get(i).get(0);
        }

        for (int j = 1; j < grid.get(0).size(); j++) {
            int currentColSum = 0;
            for (int i = 0; i < n; i++) {
                currentColSum += grid.get(i).get(j);
            }
            if (currentColSum != colSum) {
                return false;
            }
        }

        return true;
}
    

}