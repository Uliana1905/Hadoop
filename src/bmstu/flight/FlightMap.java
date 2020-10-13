package bmstu.flight;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class FlightMap  extends Mapper <FlightWritable,Text, FlightWritableComparable, Text>{
    @Override
    protected void map(FlightWritable key, Text value, Context context) throws IOException, InterruptedException {
        String [] str = value.toString().split(",");

        if (str[21].equals ("")){
            
        }

    }


}
