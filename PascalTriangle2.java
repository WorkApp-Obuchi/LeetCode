package LeetCode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        row.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            for(int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args) {
        PascalTriangle2 solution = new PascalTriangle2();

        int rowIndex = 3; // output: [1,3,3,1]
        int rowIndex2 = 0; // output: [1]
        int rowIndex3 = 1; // output: [1,1]

        List<Integer> result = solution.getRow(rowIndex);
        System.out.println("rowIndex = 3のとき " + result);

        List<Integer> result2 = solution.getRow(rowIndex2);
        System.out.println("rowIndex = 0のとき " + result2);

        List<Integer> result3 = solution.getRow(rowIndex3);
        System.out.println("rowIndex = 1のとき " + result3);
    }

}
