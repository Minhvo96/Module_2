package Exam;// Đếm số nguyên tố trong mảng

import java.util.Arrays;

public class Bt9 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 8, 4, 5, 24, 69, 45, 17, 32};
        System.out.println("Mảng bao gồm các phần tử là:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Số lượng số nguyên tố có trong mảng là:");
        primeNumbers(numbers);
    }

    public static void primeNumbers(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isPrime = true;

            if (array[i] <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime == true) {
                count++;
            }
        }
        System.out.println(count);
    }
}
