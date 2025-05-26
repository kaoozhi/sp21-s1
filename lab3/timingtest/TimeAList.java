package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Double> times = new AList<>();
        AList<Integer> Ns = new AList<>();

        // Size 1000
        Ns.addLast(1000);
        AList<Integer> dummy0 = new AList<>();
        Stopwatch sw0 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy0.addLast(i);
        }
        times.addLast(sw0.elapsedTime());

        // Size 2000
        Ns.addLast(2000);
        AList<Integer> dummy1 = new AList<>();
        Stopwatch sw1 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy1.addLast(i);
        }
        times.addLast(sw1.elapsedTime());

        // Size 4000
        Ns.addLast(4000);
        AList<Integer> dummy2 = new AList<>();
        Stopwatch sw2 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy2.addLast(i);
        }
        times.addLast(sw2.elapsedTime());

        // Size 8000
        Ns.addLast(8000);
        AList<Integer> dummy3 = new AList<>();
        Stopwatch sw3 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy3.addLast(i);
        }
        times.addLast(sw3.elapsedTime());

        // Size 16000
        Ns.addLast(16000);
        AList<Integer> dummy4 = new AList<>();
        Stopwatch sw4 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy4.addLast(i);
        }
        times.addLast(sw4.elapsedTime());

        // Size 32000
        Ns.addLast(32000);
        AList<Integer> dummy5 = new AList<>();
        Stopwatch sw5 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy5.addLast(i);
        }
        times.addLast(sw5.elapsedTime());

        // Size 64000
        Ns.addLast(64000);
        AList<Integer> dummy6 = new AList<>();
        Stopwatch sw6 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy6.addLast(i);
        }
        times.addLast(sw6.elapsedTime());

        // Size 128000
        Ns.addLast(128000);
        AList<Integer> dummy7 = new AList<>();
        Stopwatch sw7 = new Stopwatch();
        for (int i = 0; i < Ns.getLast(); i++) {
            dummy7.addLast(i);
        }
        times.addLast(sw7.elapsedTime());

        printTimingTable(Ns, times, Ns);

    }
}
