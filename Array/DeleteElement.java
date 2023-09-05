import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 4, 8, 7, 6, 1, 2};
        System.out.println("Các phần tử đang có trong mảng là: ");
        showArray(numbers);
        System.out.println("Nhập phần tử cần xóa: ");
        int num = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                index = i;
                System.out.printf("Số %s đang nằm tại vị trí %s \n", num, index);
            }
        }
        if (index != -1) {
            deleteElement(numbers, index);
        } else {
            System.out.printf("Số %s không có trong mảng", num);
        }
    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void deleteElement(int[] array, int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
            if (i == array.length - 2) {
                array[i + 1] = 0;
            }
        }
        System.out.println("Mảng sau khi xóa phần tử nhập vào: ");
        showArray(array);
    }

}


