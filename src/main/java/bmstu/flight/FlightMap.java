package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{

    private static final String REQEX_SPLITTER = ",";
    private static final String FIRST_LINE = "\"YEAR\"";
    private static final int FLAG_FLIGHT = 1;
    private static final float NOT_CANCELED = 0;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] str = value.toString().split(REQEX_SPLITTER);

        if (!str[0].equals(FIRST_LINE) && !str[18].isEmpty()){
            if (Float.parseFloat(str[18]) != NOT_CANCELED) {
                FlightWritableComparable flight = new FlightWritableComparable(FLAG_FLIGHT,Integer.parseInt(str[14]));


                Text time = new Text(str[18]);


                context.write(flight, time);
            }
        }


    }


}
