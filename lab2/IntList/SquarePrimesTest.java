package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesTwoPrimes() {
        IntList lst = IntList.of(4, 5, 6, 7, 8, 11, 13);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 25 -> 6 -> 49 -> 8 -> 121 -> 169", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesNoPrimes() {
        IntList lst = IntList.of(4, 6, 8, 12, 20);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 6 -> 8 -> 12 -> 20", lst.toString());
        assertFalse(changed);
    }
}
