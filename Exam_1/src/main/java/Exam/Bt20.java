package Exam;
import java.util.Arrays;

// Bài 20: Liệt kê các dòng có tổng lớn nhất
public class Bt20 {
    public static void main(String[] args) {
        int[][] matrix = {
                {8, 10, 6, 2, 4, 0},
                {2, 4, 8, 1112, 84, 1},
                {4, 2, 2, 918, 6, 6}
        };

        System.out.println("Ma trận có các phần tử là:");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        highestRowTotal(matrix);

    }

    public static void highestRowTotal(int[][] array) {
        int highestTotal = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            int total = 0;
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }

            if (total > highestTotal) {
                highestTotal = total;
                index = i;
            }
        }
        System.out.println("Hàng " + index + " có tổng lớn nhất là: " + highestTotal);
    }


}
