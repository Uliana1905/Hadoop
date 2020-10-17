package bmstu.flight;

import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {

    public GroupingComparator () {
        super (FlightWritableComparable.class, true);
    }

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        FlightWritableComparable a1 = (FlightWritableComparable) a;
        FlightWritableComparable b1 = (FlightWritableComparable) b;

        return a1.compareTo(b1);
    }
}

