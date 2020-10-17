package bmstu.flight;

import org.apache.hadoop.io.RawComparator;

public class GroupingComparator implements RawComparator {

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        return a.compareTo(b);
    }
}