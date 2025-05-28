package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;  // Changed from Comparator<T>

    public MaxArrayDeque() {
        super();
        this.comparator = (Comparator<T>) Comparator.naturalOrder();
    };

    public MaxArrayDeque(Comparator<T> c) {  // Changed from Comparator<T>
        super();
        this.comparator = c;
    }

    public T max() {
        return max(comparator);
    }

    public T max(Comparator<? super T> c) {  // Changed from Comparator<T>
        if (isEmpty()) {
            return null;
        }
        T max_item = this.get(0);
        for (int i = 0; i < size(); i++) {
            T item = this.get(i);
            if (c.compare(item, max_item) > 0) {
                max_item = item;
            }
        }
        return max_item;
    }

    public static void main(String[] args) {
        // No cast needed now
        MaxArrayDeque<String> deque1 = new MaxArrayDeque<>((Comparator<String>) Comparator.reverseOrder());
        deque1.addFirst("hi");
        deque1.addLast("maybe");
        deque1.addLast("wow");
        System.out.println(deque1.max());

        // No cast needed now
        MaxArrayDeque<Integer> deque2 = new MaxArrayDeque<>();
        deque2.addFirst(100);
        deque2.addLast(1000);
        deque2.addLast(10000);
        System.out.println(deque2.max(Comparator.reverseOrder()));
    }
}
