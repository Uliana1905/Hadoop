package lab2_hdp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable{
    private float arr_delay;//разница в минутах между расчетные времененем приземления и реальным (мб отрицательной)
    private int dest_airport_id; //город аэропорта
    private float air_time;  //время прибытия ( в локальном времени (hhmm)
    private float cancelled; //признак отмены


    public void readFields (DataInput in) throws IOException {
        arr_delay = in.readFloat();
        dest_airport_id = in.readInt();
        air_time = in.readFloat();
        cancelled = in.readInt();

    }

    public void write (DataOutput out) throws  IOException {


    }
}
