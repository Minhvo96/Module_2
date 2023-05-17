
// Hãy liệt kê các giá trị trong mảng mà thỏa điều kiện: lớn hơn giá trị tuyệt đối của giá trị đứng liền sau nó


import java.util.Arrays;

public class Bt6 {

    public static void main(String[] args) {
        int[] array = {3, 2, -5, 4, -1, 8, -7, 6, -10};
        System.out.println("Các phần tử trong mảng là:");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > tuyetdoi(array[i + 1])) {                // Có thể dùng hàm Math.abs
                System.out.println(array[i]);
            }
        }
    }

    public static int tuyetdoi(int number) {
        if (number > 0) {
            return number;
        } else {
            return number * -1;
        }


    }

}
