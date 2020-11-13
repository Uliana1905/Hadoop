package lab1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;



public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String str = value.toString();
        final java.lang.String SPACE = "\\  ";
        str = str.replaceAll("\\?", "");
        str = str.replaceAll("\\!", "");
        str = str.replaceAll("\\.", "");
        str = str.replaceAll("\\,", "");
        str = str.replaceAll(SPACE, "");
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("\\]", "");
        str = str.replaceAll("\\<", "");
        str = str.replaceAll("\\>", "");
        str = str.replaceAll("\\'", "");
        str = str.replaceAll("\\—", "");
        str = str.replaceAll("\\\n", "");
        str = str.toLowerCase();
        //System.out.println(str);
        String[] subStr;
        String[] res;
        subStr = str.split(SPACE);
        for(int i = 0; i < subStr.length; i++) {
            context.write(new Text(subStr[i]), new IntWritable(1));
            }
            //System.out.println(subStr[i]+i);
     }

}



