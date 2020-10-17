package bmstu.flight;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;


import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlightJob {
    public static void main(String[] args) throws InterruptedException, Exception, ClassNotFoundException {

        Job job = Job.getInstance();
        job.setJarByClass(FlightJob.class);
        job.setJobName("JoinJob sort");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportMap.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightMap.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(FlightPartition.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setReducerClass(FlightReduce.class);
        job.setMapOutputKeyClass(FlightWritableComparable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}


