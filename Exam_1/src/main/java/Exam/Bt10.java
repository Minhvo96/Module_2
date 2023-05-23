package Exam;
// Hãy xác định số lượng phần tử kề nhau mà cả 2 đều chẵn

import java.util.Arrays;

public class Bt10 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 8, 4, 5, 24, 69, 45, 18, 32};
        System.out.println("Các phần tử có trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Số lượng phần tử kề nhau mà cả 2 đều chẵn là:");
        evenNumbers(numbers);
    }

    public static void evenNumbers(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 0 && array[i+1] % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
