import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable{
    private float arr_delay;
    private int dest_airport_id;
    private float air_time;
    private float cancelled;
    

    public void readFields (DataInput in) throws IOException {

    }

    public void write (DataOutput out) throws  IOException {

    }
}
