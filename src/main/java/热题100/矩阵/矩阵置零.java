package 热题100.矩阵;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        // 依靠 set 集合记录
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i : row) {
            if (row.contains(i)) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j : column) {
            for (int m = 0; m < matrix.length; m++) {
                matrix[m][j] = 0;
            }
        }
    }
}
