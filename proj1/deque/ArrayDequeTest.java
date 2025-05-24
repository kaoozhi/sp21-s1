package deque;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized adeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        ad1.addFirst("new_front");
        assertEquals(4, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }
    
    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addLast(10);
        // should not be empty
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        // should be empty
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());

        ad1.addFirst(10);
        assertEquals("ad1 should contain again 1 item", 1, ad1.size());

        ad1.removeLast();
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  ad1 = new ArrayDeque<String>();
        ArrayDeque<Double>  ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

        assertEquals("string", s);
        assertEquals(3.14159, d, 1e-6);
        assertTrue(b);

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, ad1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }

    }
    @Test
    /* Check get method, if index doesn't exist return null*/
    public void getIndexadequeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        assertNull("Should return null when call get method on an empty list", ad1.get(0));
        assertNull("Should return null when call get method on an empty list", ad1.get(1));

        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addLast("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addLast("f");

        assertEquals("a", ad1.get(0));
        assertEquals("f", ad1.get(5));
        assertNull("Should return null when index if out of bound", ad1.get(8));
    }
    
    @Test
    /* Check get method, if index doesn't exist return null*/
    public void equalsDequeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addLast("c");
        ad1.addLast("d");

        ArrayDeque<String> ad2 = new ArrayDeque<String>();
        ad2.addLast("a");
        ad2.addLast("b");
        ad2.addLast("c");

        assertTrue("Should return false as they are not equal",!ad1.equals(ad2));
        ad2.addLast("d");
        assertTrue("Should return true as they have same content",ad1.equals(ad2));

        ArrayDeque<Integer> ad3 = new ArrayDeque<Integer>();
        ad3.addLast(1);
        ad3.addLast(2);
        ad3.addLast(3);
        ad3.addLast(4);
        assertTrue("Should return false as they are not based on the same type",!ad1.equals(ad3));
    }
}
    
    



