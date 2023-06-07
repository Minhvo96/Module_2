package Exam;

// Kiểm tra mảng có đối xứng không? Có trả về 1, không có trả về 0

import java.util.Arrays;

public class Bt11 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println("Các phần tử có trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        if (symmetricArray(numbers) == true) {
            System.out.println("1. Mảng này đối xứng");
        } else {
            System.out.println("0. Mảng này không đối xứng");
        }
    }

    public static boolean symmetricArray(int[] array) {
        boolean flag = true;

        for (int i = 0; i < array.length / 2; i++) {
             int j = array.length - 1 - i;
                if (array[i] != array[j]) {
                    flag = false;
                    return flag;
                }
            }
        return flag;
    }
}
