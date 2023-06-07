package Exam;

import java.util.Arrays;

// Bài 19: Tìm số chẵn lớn nhất trong ma trận
public class Bt19 {

    public static void main(String[] args) {
        int[][] matrix = {
                {8, 10, 6, 2, 4, 0},
                {2, 4, 8, 112, 84, 1},
                {4, 2, 2, 918, 6, 6}
        };

        System.out.println("Ma trận có các phần tử là:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int maxEvenNumber = findMaxEvenNumber(matrix);
        System.out.println("Số chẵn lớn nhất trong ma trận là: " + maxEvenNumber);
    }

    public static int findMaxEvenNumber(int[][] array) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] % 2 == 0 && array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
}