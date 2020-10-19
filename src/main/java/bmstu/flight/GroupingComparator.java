package bmstu.flight;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {

    public GroupingComparator () {
        super (FlightWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        FlightWritableComparable a1 = (FlightWritableComparable) a;
        FlightWritableComparable b1 = (FlightWritableComparable) b;

        if (a1.getDes_air() > b1.getDes_air()){
            return 1;
        }
        if (a1.getDes_air() < b1.getDes_air()){
            return -1;
        }

        System.out.println(a1.getDes_air());

        return 0;

    }

}

