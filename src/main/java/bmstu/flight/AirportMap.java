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
        final String REQEX_REPLACEMENT = " ";
        String[] str = value.toString().replaceAll(REQEX_REPLACE,  "").split(REQEX_SPLITTER);

        if (!str[0].equals("Code")) {
            FlightWritableComparable flight = new FlightWritableComparable(0,Integer.parseInt(str[0]));

            //System.out.println(str);

            Text name = new Text(str[1]);

            context.write(flight, name);
        }




    }


}
