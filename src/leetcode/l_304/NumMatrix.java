package leetcode.l_304;

import java.util.Arrays;

/**
 * Created by 81929 on 2018/7/20.
 */
public class NumMatrix {


    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        };
        NumMatrix matrix1 = new NumMatrix(matrix);
        System.out.println(matrix1.sumRegion(2, 1, 4, 3));
        System.out.println(matrix1.sumRegion(1, 1, 2, 2));
        System.out.println(matrix1.sumRegion(1, 2, 2, 4));

    }

    private static int[][] matrixSum = new int[1000][1000];

    public NumMatrix(int[][] matrix) {
        int lineLen = matrix.length;
        for(int i = 0; i < lineLen; i++){


            int[] perLine = matrix[i];
            int colLen = perLine.length;
            int sum = 0;
            for(int j = 0; j < colLen; j++){
                sum += perLine[j];
                matrixSum[i][j] = sum;

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++){
            sum += matrixSum[i][col2];
            if(col1 != 0){
                sum -= matrixSum[i][col1-1];
            }

        }
        return sum;
    }
}
