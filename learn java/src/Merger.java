import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class IntervalMerger {
    private List<Interval> intervals = new ArrayList<>();

    public void addInterval(int start, int end) {
        intervals.add(new Interval(start, end));
    }

    public void printIntervals() {
        for (Interval interval : intervals) {
            System.out.print(interval);
        }
    }

    public void mergeIntervals() {
        sortIntervals();

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval current = null;

        for (Interval interval : intervals) {
            if (current == null || interval.getStart() > current.getEnd()) {
                mergedIntervals.add(interval);
                current = interval;
            } else if (interval.getEnd() > current.getEnd()) {
                current = new Interval(current.getStart(), interval.getEnd());
                mergedIntervals.set(mergedIntervals.size() - 1, current);
            }
        }

        intervals = mergedIntervals;
    }

    private void sortIntervals() {
        intervals.sort((o1, o2) -> Integer.compare(o1.getStart(), o2.getStart()));
    }
}

public class Merger {
    public static void main(String[] args) {
        IntervalMerger merger = new IntervalMerger();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of intervals: ");
        int numberOfIntervals = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfIntervals; i++) {
            System.out.print("Start: ");
            int start = scanner.nextInt();
            System.out.print("End: ");
            int end = scanner.nextInt();
            merger.addInterval(start, end);
        }

        merger.mergeIntervals();
        System.out.print("Merged Intervals: ");
        merger.printIntervals();
    }
}
