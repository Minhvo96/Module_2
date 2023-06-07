package ArrayList_LinkedList.Simple_ArrayList;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeArray.indexOf;

public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAUT_CAPACITY = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAUT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            elements = new Object[capacity];
        } else throw new IllegalArgumentException("Capacity:" + capacity);
    }

    public void add(int index, E element) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Index: " + index);
        } else if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = element;
        size++;
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException();
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    int size() {
        return this.size;
    }

    public ArrayList<E> clone() {
        ArrayList<E> clone = new ArrayList<>();
        clone.elements = Arrays.copyOf(this.elements, this.size);
        clone.size = this.size;
        return clone;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

}
