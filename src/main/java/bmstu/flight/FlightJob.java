package bmstu.flight;

import org.apache.hadoop.mapred.JobConf;

public class FlightJob {
    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.err.println("Usage: FlightJob <input path> <output path>");
            System.exit(-1);
        }
        Job conf = new JobConf(JoinJob.class);
        conf.setJobName("map join");
        conf.setInputFormat(CompositeInputFormat.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        conf.set("mapred.join.expr", CompositeInputFormat.compose("inner",
                KeyValueTextInputFormat.class,
                args[0],
                args[1]
        ));
        conf.setMapperClass(MapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        JobClient.runJob(conf);
    }
}


