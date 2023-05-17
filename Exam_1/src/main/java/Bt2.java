
//Tính trung bình cộng các số dương trong mảng 1 chiều các số thực

import java.util.Arrays;

public class Bt2 {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, -7, 8, -41, 3, -56, 5645, 1, -944, -34};
        System.out.println("Các phần tử đang có trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        float total = 0;
        int count = 0;
        float average;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                total += numbers[i];
                count++;
            }
        } average  = total/count;
        System.out.println("Trung bình cộng các phần tử dương trong mảng này là: " + average);
    }
}