package Exam;

import java.util.Arrays;

// Kiểm tra một cột ma trận có giảm dần hay không
public class Bt15 {
    public static void main(String[] args) {
        int[][] matrix = {
                {8, 7, 6, 5, 4, 0},
                {5, 4, 3, 2, 1, 5},
                {4, 1, 3, 1, 7, 6}
        };
        System.out.println("Ma trận có các phần tử là:");

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        checkMatrix(matrix);
//        checkMatrix1(matrix);
    }

    public static void checkMatrix(int[][] matrix) {
        boolean check = true;

        for (int j = 0; j < matrix[0].length; j++) {
            check = true;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][j] <= matrix[i + 1][j]) {
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("giảm");
            else
                System.out.println("k giảm");
        }

    }

    public static void checkMatrix1(int[][] matrix) {
        boolean check = true;

        for (int i = 0; i < matrix.length; i++) {
            check = true;

            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] <= matrix[i][j + 1]) {
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("giảm");
            else
                System.out.println("k giảm");
        }
    }
}
