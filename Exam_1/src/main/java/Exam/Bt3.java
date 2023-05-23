package Exam;
// Đưa các số chia hết cho 3 về đầu mảng

import java.util.Arrays;

public class Bt3 {
    public static void main(String[] args) {
        int[] numbers = {5, 6, 7, 1, 2, 8, 30, 4, 9, 27};
        System.out.println("Các phần tử đang có trong mảng là:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Mảng sau khi đẩy các số chia hết cho 3 là:");
        change(numbers);
    }

    public static void change(int[] array) {
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
