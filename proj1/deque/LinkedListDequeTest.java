package deque;

import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

        assertEquals("string", s);
        assertEquals(3.14159, d, 1e-6);
        assertTrue(b);

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    /* Check get method, if index doesn't exist return null*/
    public void getIndexLLDequeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertNull("Should return null when call get method on an empty list", lld1.get(0));
        assertNull("Should return null when call get method on an empty list", lld1.get(1));

        lld1.addLast("a");
        lld1.addLast("b");
        lld1.addLast("c");
        lld1.addLast("d");
        lld1.addLast("e");
        lld1.addLast("f");

        assertEquals("a", lld1.get(0));
        assertEquals("f", lld1.get(5));
        assertNull("Should return null when index if out of bound", lld1.get(8));
    }

    @Test
    /* Check get method, if index doesn't exist return null*/
    public void getRecursiveLLDequeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertNull("Should return null when call get method on an empty list", lld1.get(0));
        assertNull("Should return null when call get method on an empty list", lld1.get(1));

        lld1.addLast("a");
        lld1.addLast("b");
        lld1.addLast("c");
        lld1.addLast("d");
        lld1.addLast("e");
        lld1.addLast("f");

        assertEquals("a", lld1.getRecursive(0));
        assertEquals("f", lld1.getRecursive(5));
        assertNull("Should return null when index if out of bound", lld1.getRecursive(8));
    }


    @Test
    /* Check get method, if index doesn't exist return null*/
    public void equalsDequeTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addLast("a");
        lld1.addLast("b");
        lld1.addLast("c");
        lld1.addLast("d");

        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addLast("a");
        lld2.addLast("b");
        lld2.addLast("c");

        assertTrue("Should return false as they are not equal",!lld1.equals(lld2));
        lld2.addLast("d");
        assertTrue("Should return true as they have same content",lld1.equals(lld2));

        LinkedListDeque<Integer> lld3 = new LinkedListDeque<Integer>();
        lld3.addLast(1);
        lld3.addLast(2);
        lld3.addLast(3);
        lld3.addLast(4);
        assertTrue("Should return false as they are not based on the same type",!lld1.equals(lld3));
    }


    @Test
    /* Check get method, if index doesn't exist return null*/
    public void iteratorTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        lld1.addLast("a");
        lld1.addLast("b");
        lld1.addLast("c");
        lld1.addLast("d");
        lld1.addLast("e");
        lld1.addLast("f");

        lld1.printDeque();
        Iterator<String> lld1iter = lld1.iterator();

        int i = 0;
        while (i < lld1.size()) {
            assertEquals("Should return the same element as the get() method does", lld1.get(i), lld1iter.next());
            i++;
        }
        assertFalse("Iterator should reach the end", lld1iter.hasNext());
    }

}
