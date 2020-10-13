package bmstu.flight;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <LongWritable, Text, IntWritable, Text>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String [] str = value.toString().split(",");

        if (str.length > 2) {
            if (str[21].equals("")) {
                if (Float.parseFloat(str[20]) != (float) 0) {
                    context.write(new Text(str[20]), new IntWritable(Integer.parseInt(str[14])));
                }
            }

        }else{
            
        }

    }


}
