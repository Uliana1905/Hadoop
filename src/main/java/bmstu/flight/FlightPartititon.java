package bmstu.flight;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text;

public class FlightPartition  extends Partitioner<FlightWritableComparable, Text> {
    public int getPartition(FlightWritableComparable key, Text value, int numReduceTasks) {
        return key.getDes_air() % numReduceTasks;
    }
}