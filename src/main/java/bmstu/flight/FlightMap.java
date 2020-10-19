package bmstu.flight;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <LongWritable, Text, FlightWritableComparable, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] str = value.toString().split(",");

        if (!str[0].equals("\"YEAR\"") && !str[18].isEmpty()){
            if (Float.parseFloat(str[18]) != (float) 0) {
                FlightWritableComparable flight = new FlightWritableComparable();

                flight.set_flag(1);
                flight.set_des_air(Integer.parseInt(str[14]));

                Text time = new Text(str[18]);
                System.out.println(flight.getDes_air());


                context.write(flight, time);
            }
        }


    }


}
