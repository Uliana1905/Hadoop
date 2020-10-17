package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(",");

        if (!str[0].equals("\"YEAR\"") && Float.parseFloat(str[19]) != (float)1 && !str[18].equals("")){
            if (Float.parseFloat(str[18]) != (float) 0) {
                FlightWritableComparable flight = new FlightWritableComparable();

                flight.set_flag(1);
                flight.set_des_air(Integer.parseInt(str[14]));

                Text time = new Text(str[18]);

                context.write(flight, time);
            }
        }


    }


}
