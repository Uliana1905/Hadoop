package bmstu.flight;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text;

public class FlightPartition  extends Partitioner<FlightWritableComparable, Text> {
    public int getPartition(FlightWritableComparable key, Text value, int numReduceTasks) {
        if (key.getDes_air() == 0) {
            System.out.println("            }}}}}}}}}}}}}" + key.getDes_air());

        }
        return key.getDes_air() % numReduceTasks;
    }
}