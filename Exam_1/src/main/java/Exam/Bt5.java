package Exam;
// Hãy liệt kê các số trong mảng 1 chiều các số thực thuộc đoạn [x, y] cho trước

import java.util.Arrays;
import java.util.Scanner;

public class Bt5 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {41, 76, 17, 10, 23, 18, 30, 24, 99, 27};
        System.out.println("Các phần tử đang có trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Nhập số x:");
        int x = scanner.nextInt();
        System.out.println("Nhập số y:");
        int y = scanner.nextInt();

        System.out.println("Các số trong đoạn [x, y] vừa nhập vào là:");

        for (int i = 0; i < numbers.length; i++) {
            if (x <= numbers[i] && y >= numbers[i]) {
                System.out.print(numbers[i] + " ");
            }
        }

    }

}
