import bmstu.flight.FlightWritableComparable;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text

public class FlightPartitioner  extends Partitioner<FlightWritableComparable, Text> {
    public int getPartition(FlightWritableComparable key, Text value, int numReduceTasks) {
        return key.getDes_air() % numReduceTasks;
    }
}