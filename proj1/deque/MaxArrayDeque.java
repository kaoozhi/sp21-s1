package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;  // Changed from Comparator<T>

    public MaxArrayDeque(Comparator<T> c) {  // Changed from Comparator<T>
        super();
        this.comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<T> c) {  // Changed from Comparator<T>
        if (isEmpty()) {
            return null;
        }
        T maxItem = this.get(0);
        for (int i = 0; i < size(); i++) {
            T item = this.get(i);
            if (c.compare(item, maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }
}
