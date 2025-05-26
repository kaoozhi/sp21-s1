package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(0);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Double> times = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Integer> Ops = new AList<>();
        Ops.addLast(10000);

        // Size 1000
        Ns.addLast(1000);
        SLList<Integer> dummy0 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy0.addLast(i);
        }
        Stopwatch sw0 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy0.getLast();
        }
        times.addLast(sw0.elapsedTime());

        // Size 2000
        Ns.addLast(2000);
        SLList<Integer> dummy1 = new SLList<>();

        for (int i = 0; i < Ns.getLast(); i++) {
            dummy1.addLast(i);
        }
        Stopwatch sw1 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy1.getLast();
        }
        times.addLast(sw1.elapsedTime());

        // Size 4000
        Ns.addLast(4000);
        SLList<Integer> dummy2 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy2.addLast(i);
        }
        Stopwatch sw2 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy2.getLast();
        }
        times.addLast(sw2.elapsedTime());

        // Size 8000
        Ns.addLast(8000);
        SLList<Integer> dummy3 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy3.addLast(i);
        }

        Stopwatch sw3 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy3.getLast();
        }
        times.addLast(sw3.elapsedTime());

        // Size 16000
        Ns.addLast(16000);
        SLList<Integer> dummy4 = new SLList<>();

        for (int i = 0; i < Ns.getLast(); i++) {
            dummy4.addLast(i);
        }
        Stopwatch sw4 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy4.getLast();
        }
        times.addLast(sw4.elapsedTime());

        // Size 32000
        Ns.addLast(32000);
        SLList<Integer> dummy5 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy5.addLast(i);
        }
        Stopwatch sw5 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy5.getLast();
        }
        times.addLast(sw5.elapsedTime());

        // Size 64000
        Ns.addLast(64000);
        SLList<Integer> dummy6 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy6.addLast(i);
        }
        Stopwatch sw6 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy6.getLast();
        }
        times.addLast(sw6.elapsedTime());

        // Size 128000
        Ns.addLast(128000);
        SLList<Integer> dummy7 = new SLList<>();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy7.addLast(i);
        }
        Stopwatch sw7 = new Stopwatch();
        for (int i = 0; i < Ops.getLast(); i++) {
            dummy7.getLast();
        }
        times.addLast(sw7.elapsedTime());

        printTimingTable(Ns, times, Ops);
    }

}
