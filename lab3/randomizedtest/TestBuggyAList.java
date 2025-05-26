package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> al1 = new AListNoResizing<>();
        BuggyAList<Integer> al2 = new BuggyAList<>();

        al1.addLast(4);
        al2.addLast(4);

        assertEquals(al1.getLast(), al2.getLast());

        al1.addLast(5);
        al2.addLast(5);

        assertEquals(al1.getLast(), al2.getLast());

        al1.addLast(6);
        al2.addLast(6);

        assertEquals(al1.getLast(), al2.getLast());

        al1.removeLast();
        al2.removeLast();
        assertEquals(al1.getLast(), al2.getLast());

        al1.removeLast();
        al2.removeLast();
        assertEquals(al1.getLast(), al2.getLast());

        al1.removeLast();
        al2.removeLast();
        assertEquals(0, al2.size());
        assertEquals(al1.size(), al2.size());

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                assertEquals(L.getLast(), BL.getLast());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(L.size(), BL.size());
                System.out.println("size: " + size);
            } else {
                if (L.size() > 0) {
                    L.removeLast();
                }
                if (BL.size() > 0) {
                    BL.removeLast();
                }
                System.out.println("Last element removed");
                if (L.size() > 0) {
                    System.out.println("getLast() = " + L.getLast());
                    assertEquals(L.getLast(), BL.getLast());
                }
            }
        }
    }
}
