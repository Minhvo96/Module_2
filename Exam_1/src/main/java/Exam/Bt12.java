package Exam;

import java.util.Arrays;
import java.util.Scanner;

// Kiểm tra mảng có tăng dần hay không
public class Bt12 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhập kích thước của mảng:");
        int size = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) Math.floor(Math.random() * 100);
//            numbers[i] = (int) Math.ceil(Math.random()*(50-20)+20);
        }
        System.out.println(Arrays.toString(numbers));


        if (checkArray(numbers)){
            System.out.println("Mảng này tăng dần");
        } else {
            System.out.println("Mảng này không tăng dần");
        }

    }

    public static boolean checkArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

}