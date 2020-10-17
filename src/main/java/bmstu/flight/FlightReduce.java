package bmstu.flight;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightReduce extends Reducer<FlightWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(FlightWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator <Text> iter =  values.iterator();
        Text name = new Text(iter.next()):
        float min = -1;
        float max = Float.MAX_VALUE;
        float midl = -1;
        while (iter.hasNext()){
            Text number = iter.next();
            float id = Float.parseFloat(number.toString());
            if (min > id){
                min = id ;
            }
            if  ( max < id){
                max = id ;
            }


        }


    }







    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        long count = 0;
        Iterator iter =  values.iterator();
        while (iter.hasNext()) {
            iter.next();
            count++;

        }
        context.write ( key, new LongWritable ( count));
    }

}
