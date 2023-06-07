package Exam;

import java.util.Arrays;

// Hãy cho biết tất cả các phần tử trong mảng a có nằm trong mảng b không
public class Bt13 {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 4, 5};
        int[] arrayB = {5, 4, 3, 2, 1};

        System.out.println("Mảng a có các phần tử là:");
        System.out.println(Arrays.toString(arrayA));

        System.out.println("Mảng b có các phần tử là:");
        System.out.println(Arrays.toString(arrayB));

        if (checkAnB(arrayA, arrayB) == true) {
            System.out.println("Các phần tử trong mảng a đều thuộc mảng b");
        } else if (checkAnB(arrayA, arrayB) == false) {
            System.out.println("Các phần tử trong mảng a không thuộc mảng b");
        }

    }

    private static boolean checkAnB(int[] arrayA, int[] arrayB) {
        boolean flag = false;

        for (int i = 0; i < arrayA.length; i++) {
            flag = false;

            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                return flag;
            }

        }
        return flag;
    }
}

