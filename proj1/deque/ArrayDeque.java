package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private static final double REFACTOR = 2.0;
    private static final double RATIO = 0.25;
    private static final int ARRAY_SIZE = 8;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[ARRAY_SIZE];
        nextFirst = 0;
        nextLast = nextFirst + 1;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize((int) (size * REFACTOR));
        }
        int arrayIndex = getArrayIndex(nextFirst);
        items[arrayIndex] = item;
        size += 1;
        nextFirst -= 1;
        nextLast = nextFirst + size + 1;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize((int) (size * REFACTOR));
        }
        int arrayIndex = getArrayIndex(nextLast);
        items[arrayIndex] = item;
        size += 1;
        nextLast += 1;
    }

//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String res = "";
        int count = 0;
        int start = nextFirst + 1;
        while (count < size) {
            int arrayIndex = getArrayIndex(start);
            res += " " + items[arrayIndex];
            start++;
            count++;
        }
        res += "\n";
        System.out.println(res);
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            if ((double) (size - 1) / items.length < RATIO) {
                resize((int) (items.length / REFACTOR));
            }
            int firstarrayIndex = getArrayIndex(nextFirst + 1);
            T removedItem = items[firstarrayIndex];
            items[firstarrayIndex] = null;
            size -= 1;
            nextFirst += 1;
            return removedItem;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            if ((double) (size - 1) / items.length < RATIO) {
                resize((int) (items.length / REFACTOR));
            }
            int lastarrayIndex = getArrayIndex(nextLast - 1);
            T removedItem = items[lastarrayIndex];
            items[lastarrayIndex] = null;
            size -= 1;
            nextLast -= 1;
            return removedItem;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        int arrayIndex = getArrayIndex(nextFirst + 1 + index);
        return items[arrayIndex];
    }

    private int getArrayIndex(int dequeIndex) {
        int arrayIndex = dequeIndex % items.length;
        return (arrayIndex < 0) ? arrayIndex + items.length : arrayIndex;
    }

    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            a[i] = this.get(i);
        }
        items = a;
        nextFirst = -1;
        nextLast = size;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ArrayDeque<?>)) {
            return false;
        }
        ArrayDeque<?> obj = (ArrayDeque<?>) o;

        if (this.size != obj.size()) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (this.get(i) != obj.get(i)) {
                return false;
            }
        }
        return true;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int wizPos;
        public ArrayDequeIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            T next = get(wizPos);
            wizPos++;
            return next;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);
        deque.addFirst(8);
        deque.addFirst(9);
        deque.addLast(0);
        deque.addLast(-1);
        deque.addLast(-2);
        deque.addFirst(10);
        deque.addFirst(11);
        deque.addFirst(12);
        for (int i = 13; i < 18; i++) {
            deque.addFirst(i);
        }
        deque.addLast(-3);
        for (int i = 0; i < 15; i++) {
            deque.removeLast();
        }
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addLast(-4);
        deque.removeLast();
        deque.removeLast();
        deque.printDeque();

        Iterator<Integer> dequeIterator = deque.iterator();
        while (dequeIterator.hasNext()) {
            System.out.println((dequeIterator.next()));
        }
    }

}
