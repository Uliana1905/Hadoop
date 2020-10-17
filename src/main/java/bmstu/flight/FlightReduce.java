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
        Text name = new Text(iter.next());
        float min = -1;
        float max = Float.MAX_VALUE;
        float midl = 0;
        long count = 0;

        while (iter.hasNext()){
            Text number = iter.next();
            float id = Float.parseFloat(number.toString());
            if (min > id){
                min = id ;
            }
            if  ( max < id) {
                max = id;
            }

            count ++;
            midl += id;
        }

        midl = midl / count;

        context.write (new Text(Integer.toString(key.getDes_air())), new Text("Название аэропорта: "+ name + ", Минимальное значение: " + min + ", Максимальное значение: " + max + ", Cреднее значение: " + midl) );


    }

}
