package deque;

public class ArrayDeque<T> {
    private int size;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return items[index];
    }
}