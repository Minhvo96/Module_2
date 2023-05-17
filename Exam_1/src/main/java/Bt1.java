import java.util.Arrays;

// Tính tổng các giá trị lớn hơn giá trị đứng liền trước nó trong mảng 1 chiều các số thực
public class Bt1 {

    public static void main(String[] args) {
        int[] numbers = {5, 6, 7, 1, 2, 8, 0, 4};
        System.out.println("Mảng đang có các phần tử là");
        System.out.println(Arrays.toString(numbers));
        int total = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                total += numbers[i + 1];
            }
        }
        System.out.println("Tổng giá trị lớn hơn giá trị đứng trước là " + total);
    }
}
