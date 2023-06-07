package Stack_Queue.Binary;

import java.util.Scanner;
import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số cần chuyển thành nhị phân: ");
        int number = Integer.parseInt(scanner.nextLine());
//        System.out.println("Nhập tên: ");
//        String name = scanner.nextLine();  // nếu dùng scanner.nextInt ở trên sẽ bị trôi lệnh Nhập tên

        System.out.println("Số sau khi chuyển thành nhị phân là: ");
        System.out.println(convertNumberToBinary(number));
    }


    public static String convertNumberToBinary(int number) {
        String str = "";
        Stack<Integer> stack = new Stack<>();

        if (number == 0) {
            return "0";
        }

        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        return str;
    }
}
