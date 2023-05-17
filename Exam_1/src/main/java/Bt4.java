
// Đảo ngược mảng ban đầu

import java.util.Arrays;

public class Bt4 {
    public static void main(String[] args) {
        int[] numbers = {58, 6, 17, 1, 20, 8, 30, 4, 9, 27};
        System.out.println("Các phần tử đang có trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Mảng sau khi đảo ngược vị trí là:");
        reverseArray(numbers);
    }


    public static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
