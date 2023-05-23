package Exam;

import java.util.Arrays;

// Đếm số dương chia hết cho 7 trong mảng
public class Bt8 {
    public static void main(String[] args) {
        int[] numbers = {14, 21, -21, 30, -84, 35, 45, 75, -22, 42, 49, 56, 63, 70};
        System.out.println("Mảng bao gồm các phần tử là: ");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Các phần tử chia hết cho 7 trong mảng là:");
        divisibleBy7(numbers);
    }

    public static void divisibleBy7(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 7 == 0) {
                System.out.print(array[i] + "\t");
            }
        }
    }











}
