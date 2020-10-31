package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class AirportMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        final String REQEX_SPLITTER = ",(?! )";
        final String REQEX_REPLACE = "\"";
        final String REQEX_REPLACEMENT = "";
        final String COMPARE = "Code";
        final int FLAG_AIRPORT = 0;
        String[] str = value.toString().replaceAll(REQEX_REPLACE,REQEX_REPLACEMENT).split(REQEX_SPLITTER);

        if (!str[0].equals(COMPARE)) {
            FlightWritableComparable flight = new FlightWritableComparable(FLAG_AIRPORT,Integer.parseInt(str[0]));

            //System.out.println(str);

            Text name = new Text(str[1]);

            context.write(flight, name);
        }




    }


}
