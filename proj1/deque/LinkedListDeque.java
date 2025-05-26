package deque;

import java.util.Iterator;

public class LinkedListDeque<T> {
    private Node sentinel;
    private int size;

    public class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T t, Node next, Node prev) {
            item = t;
            this.next = next;
            this.prev = prev;
        }
        public T getRecursive(int index) {
            if (index == 0) {
                return item;
            }
            return next.getRecursive(index - 1);
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node old_first = sentinel.next;
        sentinel.next = new Node(item, sentinel.next, sentinel);
        old_first.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        Node old_last = sentinel.prev;
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        old_last.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        String res = "";
        while (p != sentinel) {
            res += " " + p.item;
            p = p.next;
        }
        res += "\n";
        System.out.println(res);
    }

    public T removeFirst() {
        if (size > 0) {
            Node first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            size -= 1;
            return first.item;
        }
        return null;
    }

    public T removeLast() {
        if (size > 0) {
            Node last = sentinel.prev;
            sentinel.prev = last.prev;
            last.prev.next = sentinel;
            size -= 1;
            return last.item;
        }
        return null;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        } else if (index == size - 1) {
            return sentinel.prev.item;
        }
        Node p = sentinel.next;
        int i = 0;
        while (i != index) {
            i++;
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if (index < 0 || index > size - 1) {
            return null;
        }
        return sentinel.next.getRecursive(index);
    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedListDeque<?>)) {
            return false;
        }
        LinkedListDeque<?> obj = (LinkedListDeque<?>) o;

        if (this.size != obj.size()) {
            return false;
        }

        for (int i=0; i < this.size; i++) {
            if (this.get(i) != obj.get(i)) {
                return false;
            }
        }
        return true;
    }

    private class DequeIterator implements Iterator<T> {
        private Node p;
        public DequeIterator() { p = sentinel.next; }
        public boolean hasNext() { return p != sentinel; }
        public T next() {
            T nextItem = p.item;
            p = p.next;
            return nextItem;
        }
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }


    public static void main(String[] args) {
        LinkedListDeque<String> deque = new LinkedListDeque<String>();
        deque.addFirst("4");
        deque.addFirst("3");
        deque.addFirst("2");
        deque.addFirst("1");
        deque.addLast("5");
        deque.addLast("6");
//        System.out.println(deque.removeFirst());
//        System.out.println(deque.removeLast());
//        System.out.println(deque.get(0));
        System.out.println(deque.getRecursive(8));

        LinkedListDeque<String> deque2 = new LinkedListDeque<String>();
        deque2.addFirst("4");
        deque2.addFirst("3");
        deque2.addFirst("2");
        deque2.addFirst("1");
        deque2.addLast("5");
        System.out.println(deque2.equals(deque));

        Iterator<String> deque2Iterator = deque2.iterator();

        while (deque2Iterator.hasNext()) {
            System.out.println(deque2Iterator.next());
        }

    }
}