import bmstu.flight.FlightWritableComparable;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text

public class FlightPartitioner<K, V> extends Partitioner<K, V> {
    public int getPartition(FlightWritableComparable key, Text value, int numReduceTasks) {
        return key.getDes_air() % numReduceTasks;
    }
}