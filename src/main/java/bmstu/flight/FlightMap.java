package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final String REQEX_SPLITTER = ",";
        final String COMPARE = "\"YEAR\"";
        final int FLAG_FLIGHT = 1;
        final float NOT_CANCELED = 0;
        String[] str = value.toString().split(REQEX_SPLITTER);

        if (!str[0].equals(COMPARE) && !str[18].isEmpty()){
            if (Float.parseFloat(str[18]) != NOT_CANCELED) {
                FlightWritableComparable flight = new FlightWritableComparable(FLAG_FLIGHT,Integer.parseInt(str[14]));


                Text time = new Text(str[18]);


                context.write(flight, time);
            }
        }


    }


}
