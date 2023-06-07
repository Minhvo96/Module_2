package ArrayList_LinkedList.Simple_ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAUT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAUT_CAPACITY];
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size] = element;
        size++;
    }

    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + i);
        }
        return (E) elements[i];
    }


    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();

        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        System.out.println("Element 4 is: " + listInteger.get(4));
        System.out.println("Element 2 is: " + listInteger.get(2));
//    System.out.println("element 6 is: " + listInteger.get(6));

        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }

}

