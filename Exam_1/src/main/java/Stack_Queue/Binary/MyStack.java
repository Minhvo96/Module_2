package Stack_Queue.Binary;

import java.util.Arrays;

public class MyStack<E> {
    private Object arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new Object[size];
    }

    public void push(E value) {
        if (index == arr.length) {
            arr = Arrays.copyOf(arr, size * 2);
        }
        arr[index] = value;
        index++;
    }

    public E pop() {
        E temp = (E) arr[index - 1];
        arr[index - 1] = null;
        index--;

        return temp;
    }

    public E peek() {
        return (E) arr[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public static void main(String[] args) {
        MyStack<Double> stack = new MyStack<>(5);

        stack.push(1.0);
        stack.push(2.0);
        stack.push(1.0);
        stack.push(6.0);
        stack.push(9.5);

        stack.push(10.6);



        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
