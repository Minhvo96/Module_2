package Exam;

import java.util.Arrays;

// Bài 18: Tìm số chẵn đầu tiên trong ma trận
public class Bt18 {
    public static void main(String[] args) {
        int[][] matrix = {
                {8, 6, 6, 2, 4, 0},
                {2, 4, 8, 2, 4, 1},
                {4, 2, 2, 8, 6, 6}
        };

        System.out.println("Ma trận có các phần tử là:");

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        if (findFirstEvenNumber(matrix) == false) {
            System.out.println("Ma trận này không có số chẵn.");
        }
    }


    public static boolean findFirstEvenNumber(int[][] array) {
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            flag = false;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    System.out.println("Đây là số chẵn đầu tiên trong ma trận: " + array[i][j]);
                    flag = true;
                    return flag;
                }
            }
        }
        return flag;
    }
}
