package Exam;

import java.util.Arrays;

// Kiểm tra ma trận 2 chiều có toàn số dương hay không
public class Bt14 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, -4, 5, 0},
                {5, 4, 3, 2, 1}
        };
        System.out.println("Ma trận có các phần tử là:");
//        showMatrix(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        if (checkPositiveNumber(matrix) == true) {
            System.out.println("Ma trận toàn số dương");
        } else if (checkPositiveNumber(matrix) == false) {
            System.out.println("Ma trận có chứa số âm");
        }
    }

    public static boolean checkPositiveNumber(int[][] array) {
        boolean flag = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }


//    public static void showMatrix(int[][] matrix) {
//        for(int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}