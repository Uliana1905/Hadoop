package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class AirportMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{
    private static final String REQEX_SPLITTER = ",(?! )";
    private static final String REQEX_REPLACE = "\"";
    private static final String REQEX_REPLACEMENT = "";
    private static final String FIRST_LINE = "Code";
    private static final int FLAG_AIRPORT = 0;
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().replaceAll(REQEX_REPLACE,REQEX_REPLACEMENT).split(REQEX_SPLITTER);

        if (!str[0].equals(FIRST_LINE)) {
            FlightWritableComparable flight = new FlightWritableComparable(FLAG_AIRPORT,Integer.parseInt(str[0]));

            //System.out.println(str);

            Text name = new Text(str[1]);

            context.write(flight, name);
        }




    }


}
