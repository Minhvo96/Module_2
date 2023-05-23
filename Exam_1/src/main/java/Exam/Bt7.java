package Exam;

import java.util.Arrays;

// Hãy liệt kê các vị trí mà giá trị tại đó là số chính phương trong mảng 1 chiều các số nguyên
public class Bt7 {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 9, 16, 21, 59, 11, 66, 24, 19, 16};
        System.out.println("Các phần tử trong mảng là:");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Vị trí của các số chính phương trong mảng là:");
        isPerfectSquare(numbers);
    }

    public static void isPerfectSquare(int[] array) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            // 3.00 3.021213123 đổi số thành chuỗi, rồi xem các phần tử sau dấu phẩy có = 0 ko
            boolean flag = true;
            String squareNum = String.valueOf(Math.sqrt(array[i]));
            for (int j = 0; j < squareNum.length(); j++) {
                if (squareNum.charAt(j) == '.') {
                    for (int z = j + 1; z < squareNum.length(); z++) {
                        if (squareNum.charAt(z) != '0') {
                            flag = false;
                            break;
                        }

                    }
                    if (flag == true) {
                        index = i;
                        System.out.println("Số chính phương ở tại vị trí " + i);
                    }
                }
            }


        }
    }

}
