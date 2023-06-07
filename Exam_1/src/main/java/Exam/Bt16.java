package Exam;

import java.util.Arrays;

// Bài 16: Kiểm tra ma trận có tồn tại số lẻ hay không
public class Bt16 {

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

        if (checkOddNumber(matrix) == true) {
            System.out.println("Ma trận toàn số chẵn");
        } else if (checkOddNumber(matrix) == false) {
            System.out.println("Ma trận có chứa số lẻ");
        }
    }

    public static boolean checkOddNumber(int[][] array) {
        boolean flag = true;

        for (int i = 0; i < array.length; i++) {
            flag = true;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 != 0) {
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }


}


