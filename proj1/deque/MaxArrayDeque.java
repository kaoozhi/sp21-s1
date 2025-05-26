package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

//    private class MaxArrayDequeComparator implements Comparator<T> {
//        public int compare(T t1, T t2) {
//
//        }
//
//    }
    public MaxArrayDeque(Comparator<T> c) {

    };
    public T max() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public T max(Comparator<T> c) {
        return removeFirst();
    }
}
