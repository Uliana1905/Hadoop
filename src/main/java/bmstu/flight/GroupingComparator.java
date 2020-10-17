package bmstu.flight;

import org.apache.hadoop.io.RawComparator;

public class GroupingComparator implements RawComparator {

    public int compare(FlightWritableComparable a, FlightWritableComparable b) {
        return a.compareTo(b);
    }
}


public class NaturalKeyGroupingComparator extends WritableComparator {
    protected NaturalKeyGroupingComparator() {
        super(StockKey.class, true);
    }
    @SuppressWarnings("rawtypes")
    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {
        StockKey k1 = (StockKey)w1;
        StockKey k2 = (StockKey)w2;

        return k1.getSymbol().compareTo(k2.getSymbol());
    }
}