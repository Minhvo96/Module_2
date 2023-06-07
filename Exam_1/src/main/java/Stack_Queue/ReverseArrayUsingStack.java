package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayUsingStack {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        reverseArray(numbers);
        System.out.println(Arrays.toString(numbers));
    }


    public static void reverseArray(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
        int i = 0;

//        System.out.println("Duyệt bang stack.empty");
        while (!stack.empty()) {
            numbers[i] = stack.pop();
            i++;
        }
//        System.out.println(Arrays.toString(numbers)); không nên sout ra ở đây
    }
}
